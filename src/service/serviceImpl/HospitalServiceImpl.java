package service.serviceImpl;

import database.DataBase;
import model.Hospital;
import service.Generic;
import service.HospitalService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HospitalServiceImpl implements HospitalService,Generic<Hospital> {
    private DataBase dataBase;

    public HospitalServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Hospital> add(Hospital hospital) {
        dataBase.getHospitals().add(hospital);
        return dataBase.getHospitals();
    }

    @Override
    public List<Hospital> getAll() {
        return dataBase.getHospitals();
    }

    @Override
    public List<Hospital> addHospitals(List<Hospital> hospitals) {
        dataBase.getHospitals().addAll(hospitals);
        return hospitals;
    }

    @Override
    public Hospital getHospitalById(Long id) {
        List<Hospital> list = dataBase.getHospitals().stream()
                .filter(hospital -> hospital.getId().equals(id)).toList();
        return list.get(0);
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        for (Hospital h : dataBase.getHospitals()) {
            if (h.getId().equals(id)) {
                h.setName(hospital.getName());
                h.setAddress(hospital.getAddress());

            }
        }
        System.out.println("Successfully updated");
    }

    @Override
    public List<Hospital> sortHospitalByName(String sort) {
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.println("""
                press 1-by ascending
                press 2-by descending""");
        switch (num = scanner.nextInt()) {
            case 1 -> {
                List<Hospital> list = new java.util.ArrayList<>(dataBase.getHospitals().stream().toList());
                list.sort(sortByAcs);
                return list;
            }
            case 2 -> {
                List<Hospital> list = new java.util.ArrayList<>(dataBase.getHospitals().stream().toList());
                list.sort(sortByDesc);
                return list;
            }
        }
        return null;
    }

    Comparator<Hospital> sortByAcs = new Comparator<Hospital>() {
        @Override
        public int compare(Hospital o1, Hospital o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    Comparator<Hospital> sortByDesc = new Comparator<Hospital>() {
        @Override
        public int compare(Hospital o1, Hospital o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

}