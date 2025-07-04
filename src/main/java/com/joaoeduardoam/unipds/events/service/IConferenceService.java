package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.model.*;

import java.util.*;

public interface IConferenceService {
    public Conference addConference(Conference conference);
    public Conference getConferenceById(Integer id);
    public List<Conference> getAllConferences();
}
