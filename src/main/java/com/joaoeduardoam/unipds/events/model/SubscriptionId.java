package com.joaoeduardoam.unipds.events.model;


import jakarta.persistence.*;
import lombok.*;


@Embeddable
@Getter
@Setter
public class SubscriptionId {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

}
