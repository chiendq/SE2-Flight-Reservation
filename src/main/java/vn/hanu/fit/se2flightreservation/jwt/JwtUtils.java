package vn.hanu.fit.se2flightreservation.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import vn.hanu.fit.se2flightreservation.configs.securities.UserDetailsImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${se2flightreservation.app.jwtSecret}")
    private String jwtSecret;

    @Value("${se2flightreservation.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${se2flightreservation.app.jwtCookieName}")
    private String jwtCookie;

    public String getJwtFromCookies(HttpServletRequest request) {
        String rawCookie = request.getHeader("Cookie");
        if(rawCookie == null) return null;
        if(rawCookie.contains(";")){
            String[] rawCookieParams = rawCookie.split(";");
            for(String rawCookieNameAndValue :rawCookieParams)
            {
                String[] rawCookieNameAndValuePair = rawCookieNameAndValue.split("=");
                if(rawCookieNameAndValuePair[0].trim().equals(jwtCookie)){
                    return rawCookieNameAndValuePair[1];
                }
            }
        }else {
            String[] rawCookieNameAndValuePair = rawCookie.split("=");
            if(rawCookieNameAndValuePair[0].trim().equals(jwtCookie)){
                return rawCookieNameAndValuePair[1];
            }
        }
        return null;
    }

    public String getJwtFromAuthorization(HttpServletRequest request){
        return request.getHeader(HttpHeaders.AUTHORIZATION);
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        return ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
    }

    public ResponseCookie getCleanJwtCookie() {
        return ResponseCookie.from(jwtCookie, null).path("/api").build();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
