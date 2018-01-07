package com.master.batch.model;

import java.util.Date;
import java.util.List;

public class EmployeeExportReport {

    private List<Employee> employees;
    private Date currentDate;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

}