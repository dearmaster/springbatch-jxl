package com.master.batch.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class ShouldMailDecider implements JobExecutionDecider {

    private final boolean shouldMail;

    private static final String MAIL_DECISION = "MAIL";
    private static final String SKIP_MAIL_DECISION = "SKIP_MAIL";

    public ShouldMailDecider(boolean shouldMail) {
        this.shouldMail = shouldMail;
    }

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        return shouldMail ? new FlowExecutionStatus(MAIL_DECISION) : new FlowExecutionStatus(SKIP_MAIL_DECISION);
    }
}
