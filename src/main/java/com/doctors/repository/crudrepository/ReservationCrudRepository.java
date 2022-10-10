package com.doctors.repository.crudrepository;

import com.doctors.modelo.ReservationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {
    @Query("Select c.client, count(c.client) from ReservationModel as c group by c.client order by count (c.client) desc ")
    public List<Object[]> countTotalReservationsByClient();

    public List<ReservationModel> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    public List<ReservationModel> findAllByStatus(String status);
}
