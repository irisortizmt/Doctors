package com.doctors.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="doctor")
public class DoctorModel implements Serializable {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String department;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name="specialtyId")
    @JsonIgnoreProperties("doctors")
    private SpecialtyModel specialty;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<MessageModel> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor","client"})
    private List<ReservationModel> reservations;


    public DoctorModel(){
    }

    public DoctorModel(String name, String department, Integer year, String description) {
        this.name = name;
        this.department = department;
        this.year = year;
        this.description = description;
    }

    public DoctorModel(Integer id, String name, String department, Integer year, String description) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.year = year;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }

    public SpecialtyModel getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyModel specialty) {
        this.specialty = specialty;
    }

    public List<ReservationModel> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationModel> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "DoctorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", messages=" + messages +
                ", specialty=" + specialty +
                ", reservations=" + reservations +
                '}';
    }
}
