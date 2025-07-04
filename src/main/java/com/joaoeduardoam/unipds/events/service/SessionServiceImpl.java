package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.exception.*;
import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements ISessionService{

    private final SessionRepository sessionRepository;

    @Override
    public Session addSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session getSessionById(Integer id) {
        return sessionRepository.findById(id).orElseThrow(()-> new NotFoundException("Session "+id+" not found"));
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }


}
