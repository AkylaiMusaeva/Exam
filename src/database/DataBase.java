package database;

import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Hospital> hospitals=new ArrayList<>();
    private List<Doctor> doctors=new ArrayList<>();
    private List<Patient> patients=new ArrayList<>();

    public DataBase(){

    }
    public DataBase(List<Hospital> hospitals, List<Doctor> doctors, List<Patient> patients) {
        this.hospitals = hospitals;
        this.doctors = doctors;
        this.patients = patients;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
    public void setHospital(Hospital hospital){
        if(this.hospitals==null){
            this.hospitals=new ArrayList<>();
        }
        this.hospitals.add(hospital);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
