package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.model.*;

import java.util.*;

public interface ISessionService {

    public Session addSession(Session session);
    public Session getSessionById(Integer id);
    public List<Session> getAllSessions();


}
