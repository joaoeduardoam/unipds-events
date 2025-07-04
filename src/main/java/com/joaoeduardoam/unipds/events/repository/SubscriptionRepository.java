package com.joaoeduardoam.unipds.events.repository;

import com.joaoeduardoam.unipds.events.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId> {

    public List<Subscription> findByIdUser(User user);

    public List<Subscription> findByIdSession(Session session);

}
