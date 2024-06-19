package com.example.DBtoExcel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mydetails")
public class MyDetails {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String gender;
}
