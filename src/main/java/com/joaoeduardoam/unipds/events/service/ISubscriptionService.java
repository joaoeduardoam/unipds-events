package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.model.*;

import java.util.*;

public interface ISubscriptionService {

    public Subscription addSubscription(Subscription subscription);
    public List<Subscription> getAllByUser(User user);
    public List<Subscription> getAllBySession(Session session);


}
