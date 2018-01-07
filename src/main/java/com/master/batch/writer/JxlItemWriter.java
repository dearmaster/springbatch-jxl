package com.master.batch.writer;

import com.master.batch.model.Employee;
import com.master.batch.model.EmployeeExportReport;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.batch.item.ItemWriter;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JxlItemWriter implements ItemWriter<Employee> {

    private String templatePath;
    private String outputPath;

    @Override
    public void write(List<? extends Employee> items) throws Exception {
        EmployeeExportReport report = new EmployeeExportReport();
        report.setEmployees((List<Employee>)items);
        report.setCurrentDate(new Date());
        Map<String, Object> map = new HashMap<>();
        map.put("model", report);

        XLSTransformer xlsTransformer = new XLSTransformer();

        InputStream is = null;
        OutputStream os = null;

        try {
            is = this.getClass().getClassLoader().getResourceAsStream(templatePath);
            os = new FileOutputStream(outputPath);
            Workbook workbook = xlsTransformer.transformXLS(is, map);
            workbook.write(os);
            System.out.println("Successfully transformed");
        } catch (Exception e) {
            throw e;
        } finally {
            if(is != null)
                is.close();
            if(os != null)
                os.close();
        }
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

}