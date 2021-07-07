package com.vti.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "Department", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {

}
