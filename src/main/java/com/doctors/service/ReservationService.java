package com.doctors.service;

import com.doctors.modelo.ReservationModel;
import com.doctors.repository.CountClient;
import com.doctors.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        if(reservationModel.getIdReservation()==null){
            return reservationRepository.saveReservation(reservationModel);
        }else{
            Optional<ReservationModel> e=reservationRepository.getReservation(reservationModel.getIdReservation());
            if(e.isEmpty()){
                return reservationRepository.saveReservation(reservationModel);
            }else{
                return reservationModel;
            }
        }

    }

    public boolean deleteReservation (Integer idReservation){
        try{
            reservationRepository.deleteReservation(idReservation);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        if(reservationModel.getIdReservation()!=null){
            Optional<ReservationModel> r = reservationRepository.getReservation(reservationModel.getIdReservation());
            if(!r.isEmpty()){
                if(reservationModel.getStartDate()!=null){
                    r.get().setStartDate(reservationModel.getStartDate());
                }
                if(reservationModel.getDevolutionDate()!=null){
                    r.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if(reservationModel.getStatus()!=null){
                    r.get().setStatus(reservationModel.getStatus());
                }
                if(reservationModel.getDoctor()!=null){
                    r.get().setDoctor(reservationModel.getDoctor());
                }
                if(reservationModel.getClient()!=null){
                    r.get().setClient(reservationModel.getClient());
                }
                if(reservationModel.getScore()!=null){
                    r.get().setScore(reservationModel.getScore());
                }
                reservationRepository.saveReservation(r.get());
                return r.get();
            }else{
                return reservationModel;
            }
        }else{
            return reservationModel;
        }
    }

     public List<ReservationModel> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a=new Date();
        Date b=new Date();
        try{
            a=parser.parse(dateA);
            b=parser.parse(dateB);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }

    }

    public StatusAmount getReservationsStatusReport(){
        List<ReservationModel> completed = reservationRepository.getReservationsByStatus("completed");
        List<ReservationModel> cancelled = reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(), cancelled.size());
    }

    public List<CountClient> getTopClients() {
        return reservationRepository.getTopClients();
    }

}
