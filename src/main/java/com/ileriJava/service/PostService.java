package com.ileriJava.service;

import com.ileriJava.dao.MainDAO;
import com.ileriJava.dao.PostRepository;
import com.ileriJava.model.FaultRecords;
import com.ileriJava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class PostService {

    @Autowired
    private MainDAO mainDAO;
    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = false)
    public void create(String title, String context, HttpServletRequest request) {
        FaultRecords faultRecords = new FaultRecords();
        faultRecords.setContext(context);
        faultRecords.setFaulttitle(title);
        faultRecords.setCreationtime(new Date());
        faultRecords.setIsexpired(false);
        faultRecords.setIsresolved(false);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        faultRecords.setUserid(user);

        mainDAO.saveObject(faultRecords);
    }

    public List<FaultRecords> getByUserID(Long userid) {
        return postRepository.findByUserID(userid);
    }

    public FaultRecords getByID(Long faultid) {
        FaultRecords record = (FaultRecords) mainDAO.loadObject(FaultRecords.class, faultid);
        return record;
    }

    public void update(FaultRecords faultRecords) {
        mainDAO.saveObject(faultRecords);
    }
}
