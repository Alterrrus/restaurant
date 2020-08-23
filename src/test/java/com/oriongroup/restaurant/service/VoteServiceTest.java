package com.oriongroup.restaurant.service;

import com.oriongroup.restaurant.model.Vote;
import com.oriongroup.restaurant.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.oriongroup.restaurant.RestTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    private VoteService voteService;
    @Test
    public void get() {
        Vote actual=voteService.get(10004,10002,10000);
        VOTE_TEST_MATCHER.assertMatch(actual,VOTE_A1);
    }
    @Test
    public void getAll(){
        List<Vote> actual=voteService.getAll(10002);
        VOTE_TEST_MATCHER.assertMatch(actual,VOTE_LIST_L);
    }
    @Test
    public void delete() {
       voteService.delete(10004,10002,10000);
       assertThrows(NotFoundException.class,()->voteService.get(10004,10002,10000));
    }
    @Test
    public void getByTimeExist(){
        List<Vote>actual=voteService.getByTimeExist(10000);

        VOTE_TEST_MATCHER.assertMatch(actual,VOTE_LIST_A1);
    }
    @Test
    public void save(){
        Vote vote=voteService.save(10003,10000);
        //если голосовал сегодня-вернуть или голос из базы (если после 11)
        //или вернуть голос с тем же id но новым временем (апдейт)
        //если не голосовал сегодня - вернуть новый голос (новый id, новое время)
        //привязка ко времмени и вся логика метода в слое сервис

    }

}