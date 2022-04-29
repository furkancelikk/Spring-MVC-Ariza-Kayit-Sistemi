package com.ileriJava.service;

import com.google.gson.Gson;
import com.ileriJava.dao.CategoryRepository;
import com.ileriJava.dao.MainDAO;
import com.ileriJava.model.Category;
import com.ileriJava.model.FaultRecords;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Struct;
import java.util.List;

/**
 * @author furkancelik
 **/

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final MainDAO mainDAO;

    public List<Category> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Transactional(readOnly = false)
    public Boolean create(String name, String description) {
        Category category = new Category();
        category.setDescription(description);
        category.setName(name);
        category.setActive(true);
        try {
            mainDAO.saveObject(category);
            return true;
        }catch (Exception exception){
            return false;
        }
    }
    @Transactional
    public  Category update(String strCategory)
    {
        Gson gson = new Gson();
        Category category = gson.fromJson(strCategory, Category.class);
        mainDAO.updateObject(category);
        return category;
    }
    @Transactional
    public boolean delete(Long id)
    {
        try {
            Category category = (Category)mainDAO.loadObject(Category.class, id);
            category.setActive(false);
            mainDAO.updateObject(category);
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }



    }

    public Category getByID(Long id) {
        Category category = new Category();
        try {
            category = (Category) mainDAO.loadObject(Category.class, id);
        }catch (Exception e){
            category = null;
        }

        return category;
    }
}
