package com.joaoeduardoam.unipds.events.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@ToString
public class Subscription {

    @EmbeddedId
    private SubscriptionId id;

    private LocalDateTime createdAt;

    private Integer level;

    public User getUser() {
        return id.getUser();
    }


    public Session getSession() {
        return id.getSession();
    }




}
