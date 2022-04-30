package vn.hanu.fit.se2flightreservation.configs.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import vn.hanu.fit.se2flightreservation.configs.jwt.AuthEntryPointJwt;
import vn.hanu.fit.se2flightreservation.configs.jwt.AuthTokenFilter;
import vn.hanu.fit.se2flightreservation.admin.services.servicesImpl.UserDetailsServiceImpl;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        List<String> allowedHeaders = new java.util.ArrayList<>();
        allowedHeaders.add("X-Requested-With");
        allowedHeaders.add("Origin");
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("Accept");
        allowedHeaders.add("Accept-Encoding");
        allowedHeaders.add("Accept-Language");
        allowedHeaders.add("Authorization");
        allowedHeaders.add("Access-Control-Allow-Credentials");
        allowedHeaders.add("Access-Control-Allow-Headers");
        allowedHeaders.add("Access-Control-Allow-Methods");
        allowedHeaders.add("Access-Control-Allow-Origin");
        allowedHeaders.add("Access-Control-Expose-Headers");
        allowedHeaders.add("Access-Control-Max-Age");
        allowedHeaders.add("Access-Control-Request-Headers");
        allowedHeaders.add("Access-Control-Request-Method");
        allowedHeaders.add("Age");
        allowedHeaders.add("Allow");
        allowedHeaders.add("Alternates");
        allowedHeaders.add("Content-Range");
        allowedHeaders.add("Content-Disposition");
        allowedHeaders.add("Connection");
        allowedHeaders.add("Cookies");
        allowedHeaders.add("Cookie");
        allowedHeaders.add("Referer");
        allowedHeaders.add("Host");
        allowedHeaders.add("withCredentials");
        corsConfiguration.setAllowedHeaders(allowedHeaders);


        List<String> origins = new java.util.ArrayList<>();
//        corsConfiguration.setAllowedOriginPatterns(origins);

        origins.add("http://localhost:3000");
//        origins.add("https://train-reservation.vercel.app/");
        origins.add("https://flight-reservation.vercel.app/");
        corsConfiguration.setAllowedOrigins(origins);

        List<String> allowedMethods = new java.util.ArrayList<>();
        allowedMethods.add("GET");
        allowedMethods.add("POST");
        allowedMethods.add("PUT");
        allowedMethods.add("DELETE");
        allowedMethods.add("PUT");
        allowedMethods.add("OPTIONS");
        allowedMethods.add("PATCH");
        allowedMethods.add("DELETE");
        corsConfiguration.setAllowedMethods(allowedMethods);

        corsConfiguration.setAllowCredentials(false);

        List<String> exposedHeaders = new java.util.ArrayList<>();
        exposedHeaders.add("Cookie");
        exposedHeaders.add("Cookies");
        exposedHeaders.add("application/json");
        corsConfiguration.setExposedHeaders(exposedHeaders);
        http.csrf().disable().cors().configurationSource(request -> corsConfiguration).and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/admin/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/api/v1/admin/**").hasRole("ADMIN")
                .antMatchers("/api/v1/auth/**").permitAll()
                .antMatchers("/api/v1/**").permitAll()
        ;
//                .anyRequest().authenticated();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }



}
