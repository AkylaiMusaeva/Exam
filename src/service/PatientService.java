package service;

import model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> addPatient(List<Patient>patients);
    Patient getPatientByFirstName(String name);//stream
    void groupingByGender();//Stream
    List<Patient>filterByAge();//30 dan oido pasientter chyksyn
}
