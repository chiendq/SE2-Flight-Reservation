package vn.hanu.fit.se2flightreservation.admin.dtos.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveUserDto {
    private String username;
    private String gender;
    private String phone;
    private String email;
}
