package builder;

import java.sql.SQLException;
import java.util.Random;

public class Builder {

    static String names[] = {"'Ali'", "'Mohammed'", "'Sami'", "'Hoda'", "'Nour'", "'Yosef'", "'Taqi'", "'Mohand'"};
    static String med[] = {"'prophen'", "'herphen'", "'rani'", "'zenos'", "'zerox'", "'morophen'", "'hypayotic'", "'banadol'"};
    static String addresses[] = {"'21 shoubra'", "'22 sahel'", "'22 khalafawi'", "'1 monfya'", "'3 new cairo'", "'32 aswan'", "'333 gsr el bahr'", "'12 giza st.'"};
    static String hobby[] = {"'football'", "'volley'", "'tennis'", "'work'", "'drawing'", "'painting'", "'photoshop'", "'games'"};

    public static void main(String[] args) throws SQLException {

        DB_driver.startDB("jdbc:derby://localhost:1527/charity", "aboahmed", "aboahmed");

        build_charity();

    }

    public static void build_charity() throws SQLException {

        // creating raising money department 
        DB_driver.addTableCol_exe("create table Donor ( \n"
                + "Donor_ID number(11) primary key,\n"
                + "address varchar2(30) not null ,\n"
                + "birth_date date \n"
                + ");");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("Donor", i + "", addresses[new Random().nextInt(8)], "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'");
        }

        DB_driver.addTableCol_exe("create table Manager ( \n"
                + "Manager_ID number(11) primary key,\n"
                + "Manager_name varchar2(30) not null,\n"
                + "address varchar2(30) ,\n"
                + "Salary number(11)\n"
                + "\n"
                + ");");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("Manager", i + "", names[new Random().nextInt(8)], addresses[new Random().nextInt(8)], new Random().nextInt(100) + "");
        }

        DB_driver.addTableCol_exe("create table volunteer ( \n"
                + "volunteer_ID number(11) primary key,\n"
                + "volunteer_name varchar2(30) not null,\n"
                + "year_experience varchar2(30) ,\n"
                + "manager_id number(11),\n"
                + "FOREIGN KEY (manager_id) REFERENCES manager(manager_id)\n"
                + ");");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("volunteer", i + "", names[new Random().nextInt(8)], hobby[new Random().nextInt(8)], new Random().nextInt(100) + "");
        }

        DB_driver.addTableCol_exe("create table Donation ( \n"
                + "donation_ID number(11) primary key,\n"
                + "money number(11) not null ,\n"
                + "pay_type varchar2(30) ,\n"
                + "Donor_id number(11) ,\n"
                + "volunteer_id number(11) ,\n"
                + "FOREIGN KEY (Donor_id) REFERENCES Donor(Donor_id),\n"
                + "FOREIGN KEY (volunteer_id) REFERENCES  Volunteer(volunteer_id)\n"
                + "\n"
                + ");\n");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("Donation", i + "", new Random().nextInt(100) + "", "'cache'", new Random().nextInt(100) + "", new Random().nextInt(100) + "");
        }

        // creating medical department
        DB_driver.addTableCol_exe("create table medicine (\n"
                + " medicine_id number(11) not null  PRIMARY KEY ,"
                + "  medicine_name varchar2(30) not null ,\n"
                + " side_effects varchar2(30) ,\n"
                + " expire_date date not null,\n"
                + " availability number(11) not null);");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("medicine", i + "",  med[new Random().nextInt(8)], "'no side effect'", "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'", new Random().nextInt(100) + "");
        }

        DB_driver.addTableCol_exe("create table room(\n"
                + "room_id number(11) not null PRIMARY KEY,\n"
                + "location varchar2(30) not null, \n"
                + "availability number(11) not null,"
                + " no_of_bed number(11) not null);");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("room", i + "", addresses[new Random().nextInt(8)], new Random().nextInt(100) + "", new Random().nextInt(10) + "");
        }

        DB_driver.addTableCol_exe("create table doctors(\n"
                + "doctor_id number(11) not null  PRIMARY KEY, "
                + "doctor_name varchar2 (30) not null, \n"
                + "birth_date date not null,\n"
                + "salary number(11) not null);");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("doctors", i + "", names[new Random().nextInt(8)],  "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'" , new Random().nextInt(100) + "");
        }

        DB_driver.addTableCol_exe("create table patients(\n"
                + "patient_id number(11) not null PRIMARY KEY, "
                + "patient_name varchar2(30) not null,\n"
                + "birth_date date not null);");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("patients", i + "", names[new Random().nextInt(8)], "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'");
        }

        DB_driver.addTableCol_exe("create table assign_room(\n"
                + "assign_id number(11)  PRIMARY KEY,\n"
                + "patient_id number(11),\n"
                + "room_id number(11),\n"
                + "assign_date date , \n"
                + "FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ,\n"
                + "FOREIGN KEY (room_id) REFERENCES room(room_id)\n"
                + ");\n");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("assign_room", i + "", new Random().nextInt(100) + "", new Random().nextInt(100) + "", "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'");
        }

        DB_driver.addTableCol_exe("create table assign_medicine(\n"
                + "assign_id number(11)  PRIMARY KEY,\n"
                + "patient_id number(11),\n"
                + "medicine_id number(11),\n"
                + "doctor_id number(11),\n"
                + "assign_date date , \n"
                + "prescription varchar2(30), \n"
                + "FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ,\n"
                + "FOREIGN KEY (medicine_id) REFERENCES medicine(medicine_id) ,\n"
                + "FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) \n"
                + ");");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("assign_medicine", i + "", new Random().nextInt(100) + "", new Random().nextInt(100) + "", new Random().nextInt(100) + "", "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'" , "'no conmment'");
        }

        // creating education department
        DB_driver.addTableCol_exe("create table student ( \n"
                + "student_id number(11) primary key,\n"
                + "student_name varchar2(30) , \n"
                + "birth_date date not null ,\n"
                + "academic_degree number(11) );");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("student", i + "", names[new Random().nextInt(8)], "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'", new Random().nextInt(100) + "");
        }

        DB_driver.addTableCol_exe("create table teacher ( \n"
                + "teacher_id number(11) primary key,\n"
                + "teacher_name varchar2(30) , \n"
                + "birth_date date not null ,\n"
                + "job varchar2(30) );");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("teacher", i + "", names[new Random().nextInt(8)], "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'", "'math'");
        }

        DB_driver.addTableCol_exe("create table certificate ( \n"
                + "certificate_id number(11) primary key,\n"
                + "certificate_name varchar2(30) , \n"
                + "date_get date not null,\n"
                + "degree varchar2(30) ,\n"
                + "student_id number(11) , \n"
                + "FOREIGN KEY (student_id) references student(student_id)\n"
                + ");");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("certificate", i + "", "'computer science'", "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'", "'degree no. " + new Random().nextInt(100) + "'", new Random().nextInt(100) + "");
        }

        DB_driver.addTableCol_exe("create table course ( \n"
                + "course_id number(11) primary key,\n"
                + "course_name varchar2(30) , \n"
                + "course_degree number(11) ,\n"
                + "course_hours number(11) );");

        
        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("course", i + "", "'computer science'",  new Random().nextInt(100) + ""  ,  new Random().nextInt(100) + "");
        }

        
        DB_driver.addTableCol_exe("create table prerequest ( \n"
                + "prerequest_id number(11) primary key,\n"
                + "course_id number(11) , \n"
                + "prequest_id number(11) ,\n"
                + "FOREIGN KEY (course_id) references course(course_id) , \n"
                + "FOREIGN KEY (prequest_id) references course(course_id) \n"
                + " );");

         
        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("prerequest", i + "",  new Random().nextInt(100) + ""  ,  new Random().nextInt(100) + "");
        }

        
        DB_driver.addTableCol_exe("create table sessions ( \n"
                + "session_id number(11) primary key,\n"
                + "cost number(11) , \n"
                + "date_get date not null,\n"
                + "hall varchar2(30) ,\n"
                + "course_id number(11) ,\n"
                + "student_id number(11) ,\n"
                + "teacher_id number(11) ,\n"
                + "FOREIGN KEY (student_id) references student\n"
                + "(student_id) , \n"
                + "FOREIGN KEY (course_id) references course(course_id) \n"
                + ",\n"
                + "FOREIGN KEY (teacher_id) references teacher\n"
                + "(teacher_id)\n"
                + ");");

        for (int i = 0; i < 100; i++) {
            DB_driver.insterROW("sessions", i + "", new Random().nextInt(100) + "", "'" + (new Random().nextInt(16) + 2000) + "-0" + (new Random().nextInt(9) + 1) + "-0" + (new Random().nextInt(9) + 1) + "'", "'hall no." + new Random().nextInt(10) + "'", new Random().nextInt(100) + "", new Random().nextInt(100) + "" , new Random().nextInt(100) + "") ;
        }

    }

}
