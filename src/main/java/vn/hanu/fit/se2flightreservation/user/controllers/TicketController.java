package vn.hanu.fit.se2flightreservation.user.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    @GetMapping("/test")
    public String test(){
        return "OKEEE";
    }
}
