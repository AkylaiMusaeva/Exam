package service;

import model.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> addHospitals(List<Hospital> hospitals);
    Hospital getHospitalById(Long id);
    void updateHospital(Long id, Hospital hospital);
    List<Hospital>sortHospitalByName(String sort);//Stream menen


}
