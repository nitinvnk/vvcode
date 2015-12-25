package com.vadhuvar.app.vo;

import java.util.Date;

public class Mail {
  private String firstName;

  private String lastName;

  private String mailFrom;

  private String mailTo;

  private String mailCc;

  private String mailBcc;

  private String mailSubject;

  private String mailContent;

  private String templateName;

  private String contentType;

  public Mail() {
    contentType = "text/html";
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(final String contentType) {
    this.contentType = contentType;
  }

  public String getMailBcc() {
    return mailBcc;
  }

  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(final String templateName) {
    this.templateName = templateName;
  }

  public void setMailBcc(final String mailBcc) {
    this.mailBcc = mailBcc;
  }

  public String getMailCc() {
    return mailCc;
  }

  public void setMailCc(final String mailCc) {
    this.mailCc = mailCc;
  }

  public String getMailFrom() {
    return mailFrom;
  }

  public void setMailFrom(final String mailFrom) {
    this.mailFrom = mailFrom;
  }

  public String getMailSubject() {
    return mailSubject;
  }

  public void setMailSubject(final String mailSubject) {
    this.mailSubject = mailSubject;
  }

  public String getMailTo() {
    return mailTo;
  }

  public void setMailTo(final String mailTo) {
    this.mailTo = mailTo;
  }

  public Date getMailSendDate() {
    return new Date();
  }

  public String getMailContent() {
    return mailContent;
  }

  public void setMailContent(final String mailContent) {
    this.mailContent = mailContent;
  }

  @Override
  public String toString() {
    final StringBuilder lBuilder = new StringBuilder();
    lBuilder.append("Mail From:- ").append(getMailFrom());
    lBuilder.append("Mail To:- ").append(getMailTo());
    lBuilder.append("Mail Cc:- ").append(getMailCc());
    lBuilder.append("Mail Bcc:- ").append(getMailBcc());
    lBuilder.append("Mail Subject:- ").append(getMailSubject());
    lBuilder.append("Mail Send Date:- ").append(getMailSendDate());
    lBuilder.append("Mail Content:- ").append(getMailContent());
    return lBuilder.toString();
  }
}
