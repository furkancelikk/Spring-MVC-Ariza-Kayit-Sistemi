package com.ileriJava.service;

import com.google.gson.Gson;
import com.ileriJava.dao.CommentRepository;
import com.ileriJava.dao.MainDAO;
import com.ileriJava.dao.PostRepository;
import com.ileriJava.model.Category;
import com.ileriJava.model.FaultRecords;
import com.ileriJava.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class PostService {

    private final MainDAO mainDAO;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = false)
    public FaultRecords create(String title, String context, Long categoryID, HttpServletRequest request) {

        Category category = (Category) mainDAO.loadObject(Category.class, categoryID);

        FaultRecords faultRecords = new FaultRecords();
        faultRecords.setContext(context);
        faultRecords.setTitle(title);
        faultRecords.setCreationTime(new Date());
        faultRecords.setIsExpired(false);
        faultRecords.setIsResolved(false);
        faultRecords.setCategory(category);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        faultRecords.setUser(user);


        Object object = mainDAO.saveObject(faultRecords);
        return faultRecords;
    }

    public List<FaultRecords> getByUserID(Long userid) {
        return postRepository.findByUserID(userid);
    }

    public FaultRecords getByID(Long faultid) {
        FaultRecords record = (FaultRecords) mainDAO.loadObject(FaultRecords.class, faultid);
        return record;
    }

    @Transactional
    public FaultRecords update(String strFaultRecord) {
        Gson gson = new Gson();
        FaultRecords faultRecords = gson.fromJson(strFaultRecord, FaultRecords.class);
        mainDAO.updateObject(faultRecords);
        return faultRecords;
    }

    public List<FaultRecords> getAll() {
        List<FaultRecords> faultRecords=postRepository.getAll();
        return faultRecords;
    }

    @Transactional
    public boolean delete(FaultRecords faultRecords){
        try {
            mainDAO.delete(faultRecords);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
