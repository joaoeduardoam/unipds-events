package com.joaoeduardoam.unipds.events.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
public class Subscription {

    @Id
    private SubscriptionId id;

    private LocalDateTime createdAt;

    private Integer level;


}
