package com.devglan.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*@Entity
@Table(name = "TBL_SMS")*/
public class Sms implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SMS_ID")
    @SequenceGenerator(name = "SEQ_SMS_ID", sequenceName = "SEQ_SMS_ID")
    private Long smsId;
    private String mobile;
    private String uuId;
    private String shortNo;
    private String msgReceive;
    private String msgSend;
    private Long msgSendId;
    private String status;
    private String totalOutSms;
    private String ok;
    private String sendDAte;
    private String sendTime;
    /*@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USERID")
    private User user;*/
    private Date createdDate;

    public Sms() {
        this.createdDate = new Date();
    }

    public Sms(TempSms tempSms) {
        this.createdDate = tempSms.getCreatedDate();
        this.mobile = tempSms.getMobile();
        this.uuId = tempSms.getUuId();
        this.shortNo = tempSms.getShortNo();
        this.msgReceive = tempSms.getMsgReceive();
        this.msgSend = tempSms.getMsgSend();
        this.msgSendId = tempSms.getMsgSendId();
        this.status = tempSms.getStatus();
        this.totalOutSms = tempSms.getTotalOutSms();
        this.ok = tempSms.getOk();
        this.sendDAte = tempSms.getSendDAte();
        this.sendTime = tempSms.getSendTime();
    }


    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getShortNo() {
        return shortNo;
    }

    public void setShortNo(String shortNo) {
        this.shortNo = shortNo;
    }

    public String getMsgReceive() {
        return msgReceive;
    }

    public void setMsgReceive(String msgReceive) {
        this.msgReceive = msgReceive;
    }

    public String getMsgSend() {
        return msgSend;
    }

    public void setMsgSend(String msgSend) {
        this.msgSend = msgSend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalOutSms() {
        return totalOutSms;
    }

    public void setTotalOutSms(String totalOutSms) {
        this.totalOutSms = totalOutSms;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public String getSendDAte() {
        return sendDAte;
    }

    public void setSendDAte(String sendDAte) {
        this.sendDAte = sendDAte;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

/*    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
