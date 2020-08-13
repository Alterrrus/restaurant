package com.oriongroup.restaurant.service;

import com.oriongroup.restaurant.repository.JPA.VoteRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VoteService extends AbstractService{
    protected final Logger log= LoggerFactory.getLogger(getClass());
    private final VoteRepo voteRepo;

    public VoteService(VoteRepo voteRepo) {
        this.voteRepo = voteRepo;
    }

}
