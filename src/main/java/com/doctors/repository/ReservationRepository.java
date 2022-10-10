package com.doctors.repository;

import com.doctors.modelo.ClientModel;
import com.doctors.modelo.ReservationModel;
import com.doctors.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(Integer idReservation) {
        return reservationCrudRepository.findById(idReservation);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel) {

        return reservationCrudRepository.save(reservationModel);
    }

    public boolean deleteReservation(Integer idReservation) {
        reservationCrudRepository.deleteById(idReservation);
        return true;
    }

    public ReservationModel updateReservation(ReservationModel reservationModel) {
        return reservationCrudRepository.save(reservationModel);
    }

    public List<ReservationModel> getReservationPeriod(Date a, Date b) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ReservationModel> getReservationsByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<CountClient> getTopClients() {
        List<CountClient> res = new ArrayList<>();
        List<Object[]>report = reservationCrudRepository.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new CountClient((Long) report.get(i)[1], (ClientModel) report.get(i)[0]));
        }
        return res;
    }

}
