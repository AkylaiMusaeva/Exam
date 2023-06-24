package service.serviceImpl;

import database.DataBase;
import enums.Gender;
import model.Doctor;
import service.DoctorService;
import service.Generic;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, Generic<Doctor> {
    private DataBase dataBase;

    public DoctorServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public List<Doctor> add(Doctor doctor) {
        dataBase.getDoctors().add(doctor);
        System.out.println("Doctor is saved");
        return null;
    }
    @Override
    public Doctor getDoctorById(Long id) {
        List<Doctor> list = dataBase.getDoctors().stream()
                .filter(doctor -> doctor.getId().equals(id))
                .toList();
        return list.get(0);
    }

    @Override
    public List<Doctor> filterByGender(String gender) {
        System.out.println("doctor you searched by gender is: ");
        List<Doctor> list = dataBase.getDoctors().stream()
                .filter(doctor -> doctor.getGender().name().equals(gender)).toList();

        return list;
    }
    @Override
    public List<Doctor> getAll() {
        return dataBase.getDoctors();
    }
}
