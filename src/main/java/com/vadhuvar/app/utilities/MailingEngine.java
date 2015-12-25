package com.vadhuvar.app.utilities;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.vadhuvar.app.vo.Mail;

public class MailingEngine {

  private MailSender mailSender;
  private VelocityEngine velocityEngine;

  public void setMailSender(final MailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void setVelocityEngine(final VelocityEngine velocityEngine) {
    this.velocityEngine = velocityEngine;
  }

  public void sendMail(final Mail mail)
      throws ResourceNotFoundException, ParseErrorException, Exception {
    final SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(mail.getMailFrom());
    message.setTo(mail.getMailTo());
    message.setSubject(mail.getMailSubject());

    final Template template = velocityEngine.getTemplate("./templates/" + mail.getTemplateName());

    final VelocityContext velocityContext = new VelocityContext();
    velocityContext.put("firstName", mail.getFirstName());
    velocityContext.put("lastName", mail.getLastName());
    velocityContext.put("location", "Pune");

    final StringWriter stringWriter = new StringWriter();

    template.merge(velocityContext, stringWriter);

    message.setText(stringWriter.toString());

    mailSender.send(message);
  }
}
