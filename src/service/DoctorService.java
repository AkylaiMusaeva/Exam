package service;

import model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor getDoctorById(Long id);//Stream
    List<Doctor> filterByGender(String gender);//Stream

}
