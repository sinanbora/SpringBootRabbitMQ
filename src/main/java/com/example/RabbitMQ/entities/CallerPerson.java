package com.example.RabbitMQ.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class CallerPerson implements Serializable {
    @Id
    private String callerPersonId;
    private String callerPerson;
    private Date createdAt;
    private boolean seen;
    private String message;

    @Override
    public String toString() {
        return "CallerPerson{" +
                "callerPersonId='" + callerPersonId + '\'' +
                ", callerPerson='" + callerPerson + '\'' +
                ", createdAt=" + createdAt +
                ", seen=" + seen +
                ", message='" + message + '\'' +
                '}';
    }

    public String getCallerPersonId() {
        return callerPersonId;
    }

    public void setCallerPersonId(String callerPersonId) {
        this.callerPersonId = callerPersonId;
    }

    public String getCallerPerson() {
        return callerPerson;
    }

    public void setCallerPerson(String callerPerson) {
        this.callerPerson = callerPerson;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
