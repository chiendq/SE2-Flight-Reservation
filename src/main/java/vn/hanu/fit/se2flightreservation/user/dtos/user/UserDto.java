package vn.hanu.fit.se2flightreservation.user.dtos.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.hanu.fit.se2flightreservation.enums.EGender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(exclude = "UserDto")
public class UserDto implements Serializable {
    private int userId;

    private String fullName;
    private String phone;

    @Enumerated(EnumType.STRING)
    private EGender gender;

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                '}';
    }
}
