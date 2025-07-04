package com.joaoeduardoam.unipds.events.service;

import com.joaoeduardoam.unipds.events.exception.*;
import com.joaoeduardoam.unipds.events.model.*;
import com.joaoeduardoam.unipds.events.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ConferenceServiceImpl implements IConferenceService{

    private final ConferenceRepository conferenceRepository;

    @Override
    public Conference addConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Override
    public Conference getConferenceById(Integer id) {
        return conferenceRepository.findById(id).orElseThrow(() -> new NotFoundException("Conference not found: "+ id));
    }

    @Override
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }



}
