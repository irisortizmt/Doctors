package com.doctors.controller;


import com.doctors.modelo.ReservationModel;
import com.doctors.repository.CountClient;
import com.doctors.service.ReservationService;
import com.doctors.service.StatusAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping(("/all"))
    public List<ReservationModel> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ReservationModel> getAllReservations2(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/{idReservation}")
    public Optional<ReservationModel> getReservation(@PathVariable Integer idReservation){
        return reservationService.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel saveReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.saveReservation(reservationModel);
    }
    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable Integer idReservation){
        return reservationService.deleteReservation(idReservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel updateReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.updateReservation(reservationModel);
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<ReservationModel> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsPeriod(dateOne, dateTwo);
    }
    @GetMapping("/report-dates/amount/{dateOne}/{dateTwo}")
    public Integer getReservationsReportDatesAmount(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsPeriod(dateOne,dateTwo).size();
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationsStatusReport(){
        return reservationService.getReservationsStatusReport();
    }
    @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return reservationService.getTopClients();
    }
}
