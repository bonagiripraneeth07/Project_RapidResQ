package com.RapidResQ.RapidResQ.Model;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ambulancedrivers")
@Getter
@Setter
@Entity
public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ambulanceNumber;
    private String hospitalName;
    private String userName;
    private String password;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private DriverDetails driverDetails;




    public String getAmbulanceNumber() {
        return ambulanceNumber;
    }

    public void setAmbulanceNumber(String ambulanceNumber) {
        this.ambulanceNumber = ambulanceNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public DriverDetails getDriverDetails() {
        return driverDetails;
    }

    public void setDriverDetails(DriverDetails driverDetails) {
        this.driverDetails = driverDetails;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Ambulance() {
    }

    public Ambulance(int id, String ambulanceNumber, String hospitalName, DriverDetails driverDetails, String userName, String password) {
        this.id = id;
        this.ambulanceNumber = ambulanceNumber;
        this.hospitalName = hospitalName;
        this.driverDetails = driverDetails;
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
