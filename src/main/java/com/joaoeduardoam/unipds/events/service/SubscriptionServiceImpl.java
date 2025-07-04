package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements ISubscriptionService{

    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getAllByUser(User user) {
        return subscriptionRepository.findByIdUser(user);
    }

    @Override
    public List<Subscription> getAllBySession(Session session) {
        return subscriptionRepository.findByIdSession(session);
    }


}
