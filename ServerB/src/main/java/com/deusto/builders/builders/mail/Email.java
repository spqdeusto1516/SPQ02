package com.deusto.builders.builders.mail;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class Email {
    private MimeMessagePreparator messagePreparator;

    private Email() {
    }

    private Email(MimeMessagePreparator messagePreparator) {
        this.messagePreparator = messagePreparator;
    }

    public MimeMessagePreparator messagePreparator() {
        return messagePreparator;
    }

    private String nestfrom;
    private String nestto;
    private String nestsubject;
    private String nesttext;

    public static com.deusto.builders.mail.Email builder() {
        return new com.deusto.builders.mail.Email();
    }

    public com.deusto.builders.mail.Email from(String nestfrom) {
        this.nestfrom = nestfrom;
        return this;
    }

    public com.deusto.builders.mail.Email to(String nestto) {
        this.nestto = nestto;
        return this;
    }

    public com.deusto.builders.mail.Email subject(String nestsubject) {
        this.nestsubject = nestsubject;
        return this;
    }

    public com.deusto.builders.mail.Email text(String nesttext) {
        this.nesttext = nesttext;
        return this;
    }

    public com.deusto.builders.mail.Email build() {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            messageHelper.setFrom(this.nestfrom);
            messageHelper.setTo(this.nestto);
            messageHelper.setSubject(this.nestsubject);
            messageHelper.setText(this.nesttext, true); // true - its means first input parameter have HTML format
        };
        return new com.deusto.builders.mail.Email(messagePreparator);
    }
}