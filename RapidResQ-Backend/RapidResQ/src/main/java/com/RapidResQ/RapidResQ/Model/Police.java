package com.RapidResQ.RapidResQ.Model;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "police")
@Getter
@Setter
@Entity
public class Police {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String userName;
    private String password;
     @OneToOne
    @JoinColumn(name = "coordinates_id")
    private Coordinates coordinates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Police() {
    }

    public Police(int id, String email, String userName, String password, Coordinates coordinates) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.coordinates = coordinates;
    }
}
