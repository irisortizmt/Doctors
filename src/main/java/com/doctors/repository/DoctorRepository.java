package com.doctors.repository;

import com.doctors.modelo.DoctorModel;
import com.doctors.repository.crudrepository.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {

    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<DoctorModel> getAllDoctors() {
        return (List<DoctorModel>) doctorCrudRepository.findAll();
    }

    public Optional<DoctorModel> getDoctor(Integer id) {
        return doctorCrudRepository.findById(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel ){

        return doctorCrudRepository.save(doctorModel);
    }
    public boolean deleteDoctor(Integer id){
        doctorCrudRepository.deleteById(id);
        return true;
    }

    public DoctorModel updateDoctor (DoctorModel doctorModel ){
        return doctorCrudRepository.save(doctorModel);
    }
}