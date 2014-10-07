/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import javax.persistence.*;


@Entity
public class Chatting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;
    private int fromEmpId;
    private int toEmpId;
    private String Message;
    private Date timeStamp;

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getFromEmpId() {
        return fromEmpId;
    }

    public void setFromEmpId(int fromEmpId) {
        this.fromEmpId = fromEmpId;
    }

    public int getToEmpId() {
        return toEmpId;
    }

    public void setToEmpId(int toEmpId) {
        this.toEmpId = toEmpId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}
