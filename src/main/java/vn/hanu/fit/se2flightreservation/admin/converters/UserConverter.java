package vn.hanu.fit.se2flightreservation.admin.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.admin.dtos.User.ResponseUserDto;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.enums.EGender;

@Component
public class UserConverter {

    public ResponseUserDto toResponseUserDto(User user){
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(user.getId());
//        responseUserDto.setPurchasedHistories();
        responseUserDto.setEmail(user.getEmail());
        responseUserDto.setPhoneNumber(user.getPhone());
        responseUserDto.setFullName(user.getFullname());
        responseUserDto.setUsername(user.getUsername());
        responseUserDto.setPassword(user.getPassword());

        String gender = "male";
        if(user.getGender().equals(EGender.female)) gender = "female";
        responseUserDto.setGender(gender);

//        responseUserDto.setCreatedAt(user.get);

        return responseUserDto;
    }
}
