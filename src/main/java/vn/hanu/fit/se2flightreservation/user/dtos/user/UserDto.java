package vn.hanu.fit.se2flightreservation.user.dtos.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import vn.hanu.fit.se2flightreservation.enums.EGender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
public class UserDto {
    private int userId;

    private String fullName;
    private String phone;

    @Enumerated(EnumType.STRING)
    private EGender gender;
}
