package com.ileriJava.test;

import com.ileriJava.config.AppConfig;
import com.ileriJava.config.WebConfig;
import com.ileriJava.config.WebInitializer;
import com.ileriJava.dao.CommentRepository;
import com.ileriJava.model.Comments;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author furkancelik
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebInitializer.class, AppConfig.class,
        WebConfig.class})
@Transactional
@WebAppConfiguration
public class TestCommentRepository {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void loadByPostID(){
        Long postID = 1L;
        List<Comments> commentsList = commentRepository.getAllByPostID(postID);
        Assert.assertTrue(commentsList.size() >= 0);
    }

    @Test
    public void loadByPostIDandPagination(){
        Long postID = 1L;
        Integer start = 0;
        Integer limit = 5;

        List<Comments> commentsList = commentRepository.findByPostIDPagination(postID, start, limit);
        Assert.assertTrue(commentsList.size() >= 0 && commentsList.size() <= limit);
    }

    @Test
    public void loadByUserID(){
        Long userID = 1L;
        List<Comments> commentsList = commentRepository.getByUserID(userID);
        Assert.assertTrue(commentsList.size() >= 0);
    }
}
