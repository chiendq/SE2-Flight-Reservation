package vn.hanu.fit.se2flightreservation.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.*;
import vn.hanu.fit.se2flightreservation.enums.EGender;
import vn.hanu.fit.se2flightreservation.enums.ERole;
import vn.hanu.fit.se2flightreservation.enums.EStatus;
import vn.hanu.fit.se2flightreservation.role.admin.services.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/admin/init")
public class InitController {

    private static final Logger logger = LoggerFactory.getLogger(InitController.class);

    private AirlineService airlineService;

    private AirportService airportService;

    private AirplaneService airplaneService;

    private FlightClassService flightClassService;

    private RoleService roleService ;

    private TicketService ticketService;

    private UserService userService;

    public InitController(AirlineService airlineService, AirportService airportService, AirplaneService airplaneService, FlightClassService flightClassService, RoleService roleService, TicketService ticketService, UserService userService) {
        this.airlineService = airlineService;
        this.airportService = airportService;
        this.airplaneService = airplaneService;
        this.flightClassService = flightClassService;
        this.roleService = roleService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    public void initAirlines(){
        List<Airline> airlines = new ArrayList<>();
        airlines.add(new Airline(1,"Vietjet Air","https://storage.googleapis.com/tripi-flights/agenticons/Vietjet_Air_logo_transparent.png"));
        airlines.add(new Airline(2,"Vietname Arilines","https://storage.googleapis.com/tripi-flights/agenticons/VietnamAirlines_logo_transparent.png"));
        airlines.add(new Airline(3,"Bamboo Airway","https://storage.googleapis.com/tripi-flights/agenticons/bamboo_airway.png', 'Bamboo Airway"));
        airlines.add(new Airline(4,"Pacific Airlines","https://storage.googleapis.com/tripi-flights/agenticons/Pacific%20Airlines.png"));
        airlines.forEach(airline -> {
            airlineService.save(airline);
        });
        logger.info("INITIALIZED airlines");
    }

    public void initAirplanes(){
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(new Airplane(1,"Airbus A320"));
        airplanes.add(new Airplane(2,"Airbus A321"));
        airplanes.add(new Airplane(3,"Airbus A350"));
        airplanes.add(new Airplane(4,"Boeing 787"));
        airplanes.add(new Airplane(5,"VN262"));
        airplanes.add(new Airplane(6,"VN260"));
        airplanes.add(new Airplane(7,"VN321"));
        airplanes.add(new Airplane(8,"QH280"));
        airplanes.forEach(airplane -> {
            airplaneService.save(airplane);
        });
        logger.info("INITIALIZED airplanes");
    }

    public void initAirports(){
        List<Airport> airports = new ArrayList<>();
        airports.add(new Airport(1,"HAN","Sân bay Nội Bài","Hà Nội"));
        airports.add(new Airport(2,"SGN","Sân bay Tân Sơn Nhất","Sài Gòn"));
        airports.add(new Airport(3,"DAD","Sân bay Quốc Tế Đà Nẵng","Đà Nẵng"));
        airports.add(new Airport(4,"CXR","Sân bay Cam Ranh","Nha Trang"));
        airports.add(new Airport(5,"PQC","Sân bay Quốc tế Phú Quốc","Phú Quốc"));
        airports.add(new Airport(6,"HUI","Sân bay Quốc tế Phú Bài","Huế"));
        airports.add(new Airport(7,"HPH","Sân bay Quốc Tế Cát Bi","Hải Phòng"));
        airports.forEach(airport -> {
            airportService.save(airport);
        });
        logger.info("INITIALIZED airports");
    }

    public void initFlightClasses(){
        List<FlightClass> flightClasses = new ArrayList<>();
        flightClasses.add(new FlightClass(1,"Economy Class","Bay tiết kiệm, đáp ứng mọi nhu cầu cơ bản."));
        flightClasses.add(new FlightClass(2,"Special Economy Class","Chi phí hợp lý với bữa ăn ngon và chỗ để chân rộng rãi."));
        flightClasses.add(new FlightClass(3,"Business Class","Bay đẳng cấp, với quầy làm thủ tục và khu ghế ngồi riêng."));
        flightClasses.add(new FlightClass(4,"First Class","Bay vippro, mọi thứ thuộc về bạn."));

        flightClasses.forEach(flightClass -> {
            flightClassService.save(flightClass);
        });
        logger.info("INITIALIZED flightClasses");
    }

    public void initTickets(){

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1,
                airlineService.getAirlineById(1),
                airportService.getAirportById(1),
                airportService.getAirportById(2),
                flightClassService.getFlightClassById(1),
                airplaneService.getAirplaneById(1),
                new Timestamp(2022,04,29,18,0,0,0),
                new Timestamp(2022,04,29,18,0,0,0),
                100,
                EStatus.STATUS_AVAILABLE,
                1,
                null));
        tickets.add(new Ticket(2,
                airlineService.getAirlineById(1),
                airportService.getAirportById(1),
                airportService.getAirportById(2),
                flightClassService.getFlightClassById(2),
                airplaneService.getAirplaneById(1),
                new Timestamp(2022,04,29,18,0,0,0),
                new Timestamp(2022,04,29,18,0,0,0),
                200,
                EStatus.STATUS_AVAILABLE,
                2,
                null));
        tickets.add(new Ticket(3,
                airlineService.getAirlineById(1),
                airportService.getAirportById(1),
                airportService.getAirportById(2),
                flightClassService.getFlightClassById(3),
                airplaneService.getAirplaneById(1),
                new Timestamp(2022,04,29,18,0,0,0),
                new Timestamp(2022,04,29,18,0,0,0),
                300,
                EStatus.STATUS_AVAILABLE,
                3,
                null));
        tickets.add(new Ticket(4,
                airlineService.getAirlineById(1),
                airportService.getAirportById(1),
                airportService.getAirportById(2),
                flightClassService.getFlightClassById(4),
                airplaneService.getAirplaneById(1),
                new Timestamp(2022,04,29,18,0,0,0),
                new Timestamp(2022,04,29,18,0,0,0),
                400,
                EStatus.STATUS_AVAILABLE,
                4,
                null));
        tickets.forEach(ticket -> {
            ticketService.save(ticket);
        });
        logger.info("INITIALIZED tickets");
    }

    @GetMapping("/random/tickets")
    public String initRandomTenTicketS(){
        for (int i = 0; i < 1000; i++) {
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            int airlineId = rand.nextInt(1,4);
            int departureAirportId = rand.nextInt(1,7);
            int arrivalAirportId = rand.nextInt(1,7);
            if(departureAirportId == arrivalAirportId){
                arrivalAirportId = rand.nextInt(1,7);
            }
            int flightClassId = rand.nextInt(1,4);
            int airplaneId = rand.nextInt(1,7);
            int departureDate = rand.nextInt(1,29);
            int arrivalDate = rand.nextInt(1,29);
            if(departureDate > arrivalDate){
                int temp = departureDate;
                departureDate = arrivalDate;
                arrivalDate = temp;
            }
            int hourDepature = rand.nextInt(1,24);
            int hourArrival = rand.nextInt(1,24);
            int cost = rand.nextInt(200,999);
            int seat = rand.nextInt(1,100);
            ticketService.save(new Ticket(
                    airlineService.getAirlineById(airlineId),
                    airportService.getAirportById(departureAirportId),
                    airportService.getAirportById(arrivalAirportId),
                    flightClassService.getFlightClassById(flightClassId),
                    airplaneService.getAirplaneById(airplaneId),
                    new Timestamp(122,04,departureDate,hourDepature,0,0,0),
                    new Timestamp(122,04,arrivalDate,hourArrival,0,0,0),
                    cost,
                    EStatus.STATUS_AVAILABLE,
                    seat,
                    null));
        }
        deleteDuplicatedAirport();
        return "Initialized 1000 random ticket";
    }
    @DeleteMapping("/tickets")
    public String deleteDuplicatedAirport(){
        int count = 0;
        for (Ticket ticket: ticketService.getAllTickets()
             ) {
            if(ticket.getStatus().equals(EStatus.STATUS_AVAILABLE)
            && ticket.getArrivalAirport().equals(ticket.getDepartureAirport())){
                ticketService.deleteTicketById(ticket.getId());
                count ++;
            }
        }
        return "Deleted " + count + " ticket that duplicate";
    }

    @PutMapping("/tickets")
    public String updateIncorrectTicketType(){
        int count = 0;
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (Ticket ticket: ticketService.getAllTickets()
        ) {
            int hourDepature = rand.nextInt(0,23);
            int hourArrival = rand.nextInt(0,23);

            ticket.getDepartureTime().setHours(hourDepature);
            ticket.getArrivalTime().setHours(hourArrival);
            ticketService.updateTicket(ticket, ticket.getId());
                count ++;
        }

        return "Update " + count + " ticket that incorrect Data";
    }

    @GetMapping("/dummyTickets")
    public String deleteDummyTickets(){
        int count = 0;
        for (Ticket ticket: ticketService.getAllTickets()
        ) {
            if(ticket.getAirplane() == null
            || ticket.getDepartureAirport() == null
            || ticket.getArrivalAirport() == null
            || ticket.getArrivalTime() == null
            || ticket.getStatus() == null
            || ticket.getDepartureTime() == null
            || ticket.getFlightClass() == null
            || ticket.getSeat() == 0){
                ticketService.deleteTicketById(ticket.getId());
                count ++;
            }

        }
        return "Delete " + count + " tickets that incorrect type";
    }

    public void initRoles(){
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, ERole.ROLE_USER,"user"));
        roles.add(new Role(2, ERole.ROLE_MODERATOR,"mod"));
        roles.add(new Role(3, ERole.ROLE_ADMIN,"admin"));

        roles.forEach(role -> {
            roleService.save(role);
        });
        logger.info("INITIALIZED roles");
    }

    public void initUser(){
        List<User> users = new ArrayList<>();
        Set<Role>roles = new HashSet<>();
        roles.add(roleService.getRoleById(1));
        roles.add(roleService.getRoleById(2));
        roles.add(roleService.getRoleById(3));

        users.add(new User(1,
                roles,
                "chieesnddafo",
                "chieesnddafo",
                "$2a$10$iCDLUsBEpOkLhq2iSrgdceAcNru1C/LMJ5eBVYEUATP.OAZTgucje",
                "012345678",
                EGender.male,
                "chieesnddafo@gmail.com"
        ));
        Set<Role>roles1 = new HashSet<>();
        roles.add(roleService.getRoleById(3));
        users.add(new User(2,
                roles1,
                "admin",
                "admin",
                "$2a$10$l6ga5K/6xosf8hzZGTaz6envHXaONVLunSKKYAoHXK/Dwt1e9LG8K",
                "012345678",
                EGender.male,
                "admin@gmail.com"
        ));
        Set<Role>roles2 = new HashSet<>();
        roles.add(roleService.getRoleById(1));
        users.add(new User(3,
                roles2,
                "user",
                "user",
                "$2a$10$zfbSUb9VTkouQ4sPJnj6/Oof0TEFtKDgh7Az2ki.UVfrOR/7.4VrC",
                "012345678",
                EGender.male,
                "user@gmail.com"
        ));
        users.forEach(user -> {
            userService.save(user);
        });
        logger.info("INITIALIZED users");
    }

    @PostMapping("/airlines")
    public String airlines(){
        initAirlines();
        return "OK";
    }

    @PostMapping("/airplanes")
    public String airplanes(){
        initAirplanes();
        return "OK";
    }

    @PostMapping("/airports")
    public String airports(){
        initAirports();
        return "OK";
    }

    @PostMapping("/flightClasses")
    public String flightClasses(){
        initFlightClasses();
        return "OK";
    }


    @PostMapping("/roles")
    public String roles(){
        initRoles();
        return "OK";
    }

    @PostMapping("/tickets")
    public String tickets(){
        initTickets();
        return "OK";
    }

    @PostMapping("/users")
    public String users(){
        initUser();
        return "OK";
    }

    @PostMapping("")
    public String initAll(){
        initAirlines();
        initAirplanes();
        initAirports();
        initFlightClasses();
        initTickets();
        return "INITIALIZED DATA";
    }

    @PostMapping("/clearALl")
    public String clearAll(){
        airlineService.deleteAll();
        airplaneService.deleteAll();
        airportService.deleteAll();
        flightClassService.deleteAll();
        userService.deleteAll();
        ticketService.deleteAll();
        return "ALL CLEARED";
    }

}
