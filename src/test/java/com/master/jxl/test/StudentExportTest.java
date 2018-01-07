package com.master.jxl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = {"classpath:student-job-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentExportTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testEmployeeExport() throws Throwable {
        final JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        final List<Throwable> throwables = jobExecution.getAllFailureExceptions();
        for(Throwable throwable : throwables) {
            throw throwable;
        }
        Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

}