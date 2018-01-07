package com.master.batch.tasklet;

import com.master.batch.model.MailDetail;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class MailTasklet implements Tasklet, InitializingBean {

    private MailDetail mailDetail;

    public MailDetail getMailDetail() {
        return mailDetail;
    }

    public void setMailDetail(MailDetail mailDetail) {
        this.mailDetail = mailDetail;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("------------mockup sending mail----------------");
        System.out.println(mailDetail);
        System.out.println("-----------------------------------------------");
        return RepeatStatus.FINISHED;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(getMailDetail(), "Mail details can't be null");
    }
}