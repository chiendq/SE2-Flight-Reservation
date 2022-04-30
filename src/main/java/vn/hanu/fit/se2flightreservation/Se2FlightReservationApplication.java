package vn.hanu.fit.se2flightreservation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.hanu.fit.se2flightreservation.role.admin.services.RoleService;
import vn.hanu.fit.se2flightreservation.role.admin.services.UserService;
import vn.hanu.fit.se2flightreservation.init.InitController;

@SpringBootApplication
public class Se2FlightReservationApplication {
    private InitController initController;

    private RoleService roleService;

    private UserService userService;

    public Se2FlightReservationApplication(InitController initController, RoleService roleService, UserService userService) {
        this.initController = initController;
        this.roleService = roleService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Se2FlightReservationApplication.class, args);
    }

    @Bean
    InitializingBean initData(){
        return () ->{
          if(roleService.isEmpty()) initController.initRoles();
          if(userService.isEmpty()) initController.initUser();
        };
    }
}
