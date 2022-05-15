package com.ileriJava.test;

import com.google.gson.Gson;
import com.ileriJava.config.AppConfig;
import com.ileriJava.config.WebConfig;
import com.ileriJava.config.WebInitializer;
import com.ileriJava.controller.CommentController;
import com.ileriJava.model.Comments;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @author furkancelik
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebInitializer.class, AppConfig.class,
        WebConfig.class})
@Transactional
@WebAppConfiguration
@Rollback
public class TestCommentController {

    @Autowired
    private CommentController commentController;

    @Test
    public void save(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        String str = commentController.saveComment("Test Yorum", 1L, request, response);
        Gson gson = new Gson();
        HashMap map = gson.fromJson(str, HashMap.class);
        Boolean success = (Boolean) map.get("success");
        Assert.assertTrue(success);
    }

    @Test
    public void loadByPostID(){
        Long postID = 1L;
        Integer start = 0;
        Integer limit = 0;

        String str = commentController.getByPost(postID, start, limit);

        Gson gson = new Gson();
        HashMap map = gson.fromJson(str, HashMap.class);

        Boolean success = (Boolean) map.get("success");
        List<Comments> commentList = (List<Comments>) map.get("data");

        Assert.assertTrue(success && (commentList.size() >= 0 && commentList.size() <= limit));
    }

    @Test
    public void deleteByID(){
        Long commentID = 14L;

        String str = commentController.delete(commentID);

        Gson gson = new Gson();
        HashMap map = gson.fromJson(str, HashMap.class);
        Boolean success = (Boolean) map.get("success");

        Assert.assertTrue(success);
    }

}
