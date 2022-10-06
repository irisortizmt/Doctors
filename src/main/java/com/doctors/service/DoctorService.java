package com.doctors.service;

import com.doctors.modelo.DoctorModel;
import com.doctors.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctors(){
        return doctorRepository.getAllDoctors();
    }

    public Optional<DoctorModel> getDoctor(Integer id){
        return doctorRepository.getDoctor(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel){
        return doctorRepository.saveDoctor(doctorModel);
    }
    public boolean deleteDoctor (Integer id){
        try {
            doctorRepository.deleteDoctor(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public DoctorModel updateDoctor(DoctorModel doctorModel){
        if (doctorModel.getId() != null) {
            Optional<DoctorModel> d = doctorRepository.getDoctor(doctorModel.getId());
            if (!d.isEmpty()) {
                if (doctorModel.getName() != null) {
                    d.get().setName(doctorModel.getName());
                }
                if (doctorModel.getDepartment() != null) {
                    d.get().setDepartment(doctorModel.getDepartment());
                }
                if (doctorModel.getYear() != null) {
                    d.get().setYear(doctorModel.getYear());
                }
                if (doctorModel.getDescription() != null) {
                    d.get().setDescription(doctorModel.getDescription());
                }
                if (doctorModel.getMessages() != null) {
                    d.get().setMessages(doctorModel.getMessages());
                }
                if (doctorModel.getSpecialty() != null) {
                    d.get().setSpecialty(doctorModel.getSpecialty());
                }
                if (doctorModel.getReservations() != null) {
                    d.get().setReservations(doctorModel.getReservations());
                }
                doctorRepository.saveDoctor(d.get());
                return d.get();
            } else {
                return doctorModel;
            }
        } else {
            return doctorModel;
        }
    }
 }


