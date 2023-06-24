package service.serviceImpl;

import database.DataBase;
import enums.Gender;
import model.Patient;
import service.Generic;
import service.PatientService;

import java.util.List;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService, Generic<Patient> {
    private DataBase dataBase;

    public PatientServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Patient> addPatient(List<Patient> patients) {
        dataBase.getPatients().addAll(patients);
        System.out.println("Patients are successfully saved");
        return dataBase.getPatients();
    }

    @Override
    public Patient getPatientByFirstName(String name) {//stream
        List<Patient> list = dataBase.getPatients()
                .stream()
                .filter(patient -> patient.getFirstName().equalsIgnoreCase(name))
                .toList();
        return list.get(0);
    }

    @Override
    public void groupingByGender() {
        System.out.println("Only male:");
        dataBase.getPatients().stream()
                .filter(patient -> patient.getGender().equals(Gender.MALE)).forEach(System.out::println);
        System.out.println("Only female:");
        dataBase.getPatients().stream()
                .filter(patient -> patient.getGender().equals(Gender.FEMALE)).forEach(System.out::println);
    }

    @Override
    public List<Patient> filterByAge() {
        List<Patient> list = dataBase.getPatients().stream()
                .filter(patient -> patient.getAge() > 30)
                .toList();
        return list;
    }

    @Override
    public List<Patient> add(Patient patient) {
        dataBase.getPatients().add(patient);
        return dataBase.getPatients();
    }

    @Override
    public List<Patient> getAll() {
        return dataBase.getPatients();
    }
}
