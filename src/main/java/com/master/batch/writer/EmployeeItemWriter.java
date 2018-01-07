package com.master.batch.writer;

import com.master.batch.model.Employee;
import com.master.batch.model.EmployeeExportReport;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeItemWriter extends SimpleJxlItemWriter<Employee> {

    @Override
    protected Map encapsulateReportMap(List<? extends Employee> items) {
        EmployeeExportReport report = new EmployeeExportReport();
        report.setEmployees((List<Employee>)items);
        report.setCurrentDate(new Date());
        Map<String, Object> map = new HashMap<>();
        map.put("report", report);
        return map;
    }

}