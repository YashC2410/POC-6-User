package com.poc6.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer userId;
@NotNull
@Size(max=100)
private String employeeId;
@NotNull
@Size(max=100)
private String userName;
@NotNull
@Size(max=100)
private String lname;
@NotNull
@Min(0)
@Max(100)
private int age;
@NotNull
@Size(max=100)
private String umail;
@NotNull
@Size(max=100)
private String ucontact;
@NotNull
@Size(max=100)
private String area;
@NotNull
@Size(max=100)
private String userPinCode;
@NotNull
@Size(max=100)
private String city;
@NotNull
@Size(max=100)
private String state;
@NotNull
@Size(max=100)
private String country;
}
