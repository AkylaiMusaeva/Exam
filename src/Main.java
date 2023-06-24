import database.DataBase;
import enums.Gender;
import model.Doctor;
import model.Hospital;
import model.Patient;
import service.DoctorService;
import service.HospitalService;
import service.PatientService;
import service.serviceImpl.DoctorServiceImpl;
import service.serviceImpl.HospitalServiceImpl;
import service.serviceImpl.PatientServiceImpl;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**жаны пакет тузунуз - model, service, dao, enums
 model пакетине класстарды тузунуз.
 Класстар: Hospital, Doctor, Patient
 Hospital классынын свойствалары: id, name, address, List<Doctor>doctors, List<Patient>patients
 Doctor классынын свойствалары: id, firstName,lastName, email, List<Patient>patients,gender
 Patient классынын свойствалары: id, firstName,lastName, phoneNumber,gender,age
 service пакетине ар бир класска тиешелуу жана бир generic интерфейс тузуп, томонку методдорду жазыныз:
 1. - HospitalService:
 List<T>add(T t);
 List<T>getAll();
 - HospitalService:
 List<Hospital>addHospitals(List<Hospital> hospitals);
 Hospital getHospitalById(Long id);
 void updateHospital(Long id, Hospital hospital);
 List<Hospital>sortHospitalByName(String sort);//Stream menen
 3. - DoctorService:
 Doctor getDoctorById(Long id);//Stream
 List<Doctor> filterByGender(String gender);//Stream
 -PatientService
 - List<Patient>addPatient(List<Patient>patients);
 Patient getPatientByfirstName(String name);//stream
 - void groupingByGender();//Stream
 List<Patient>filterByAge();//30 dan oido pasientter chyksyn
 Реализацияларын impl класстарда кылабыз.
 Методдорду озгортууго болбойт, условияда кандай берилсе ошол бойдон иштегиле!*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num;
        DataBase dataBase=new DataBase();
        HospitalServiceImpl hospitalService=new HospitalServiceImpl(dataBase);
        DoctorServiceImpl doctorService=new DoctorServiceImpl(dataBase);
        PatientServiceImpl patientService=new PatientServiceImpl(dataBase);
        while(true){
            System.out.println("""
                    Choose operation
                    1-add a new patient                       8-get hospital by id
                    2-get patient by first name               9-update hospital 
                    3-group patients by gender                10-sort hospital by name
                    4-filter patients above 30years old       11-add doctor
                    5-add one hospital                        12-get doctor by id
                    6-add list of hospitals                   13-filter doctors by gender
                    7-get all hospitals                       14-get all doctors
                                                              15-add one more doctor
                    """);
            List<Patient>patients=new ArrayList<>(List.of( new Patient(1L, "Akylai", "Musaeva", "+996702790266", Gender.FEMALE, 21),
                    new Patient(2L, "Myrza", "Musaev", "+996773543669", Gender.MALE, 23),
                    new Patient(3L, "Elena", "Valentinovna", "+996773543669", Gender.FEMALE, 43),
                    new Patient(4L, "Kamilla", "Asanova", "+996773543789", Gender.FEMALE, 31),
                    new Patient(5L, "Torogeldi", "Ahmatov", "+996773547898", Gender.MALE, 54)));

            List<Patient>patients1=new ArrayList<>(List.of( new Patient(1L, "Akylai", "Musaeva", "+996702790266", Gender.FEMALE, 21),
                    new Patient(6L, "Asel", "Temirbekova", "+996773543669", Gender.FEMALE, 78),
                    new Patient(7L, "Manas", "Alymbaev", "+996773543669", Gender.MALE, 36)));

            List<Patient>patients2=new ArrayList<>(List.of( new Patient(1L, "Akylai", "Musaeva", "+996702790266", Gender.FEMALE, 21),
                    new Patient(8L, "Ainazik", "Temirbekova", "+996773543669", Gender.FEMALE, 18),
                    new Patient(9L, "Murat", "Alymbaev", "+996773543669", Gender.MALE, 56)));


            switch (num= scanner.nextInt()){
                case 1-> System.out.println(patientService.addPatient(patients));
                case 2-> System.out.println(patientService.getPatientByFirstName("Myrza"));
                case 3->patientService.groupingByGender();
                case 4-> System.out.println(patientService.filterByAge());
                case 5-> System.out.println(hospitalService.add(
                        new Hospital(1L, "Hospital1", "Address1",new ArrayList<>(),new ArrayList<>())));
                case 6-> System.out.println(hospitalService.addHospitals(List.of(
                        new Hospital(2L, "Hospital2", "Address2", new ArrayList<>(), new ArrayList<>()),
                        new Hospital(3L, "Hospital3", "Address3", new ArrayList<>(), new ArrayList<>()),
                        new Hospital(4L, "Hospital4", "Address4", new ArrayList<>(), new ArrayList<>()))));
                case 7-> System.out.println(hospitalService.getAll());
                case 8-> System.out.println(hospitalService.getHospitalById(2L));
                case 9-> hospitalService.updateHospital(4L,new Hospital("NewHospital","NewHospitalAddress"));
                case 10-> System.out.println(hospitalService.sortHospitalByName("sort"));
                case 11-> System.out.println(doctorService.add(
                        new Doctor(1L, "Milana", "Asanova", "milana@gmail.com", patients1, Gender.FEMALE)));

                case 12-> System.out.println(doctorService.getDoctorById(2L));
                case 13-> System.out.println(doctorService.filterByGender("FEMALE"));
                case 14-> System.out.println(doctorService.getAll());
                case 15-> System.out.println(doctorService.add(
                        new Doctor(2L,"Valeriy","Mihailov","valera@gmail.com",patients2,Gender.MALE)));


            }
        }
    }
}