package com.master.batch.writer;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.batch.item.ItemWriter;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleJxlItemWriter<T> implements ItemWriter<T> {

    private String templatePath;
    private String outputPath;

    protected Map encapsulateReportMap(List<? extends T> items) {
        Map<String, Object> map = new HashMap<>();
        map.put("report", items);
        return map;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {

        Map<String, Object> map = encapsulateReportMap(items);

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