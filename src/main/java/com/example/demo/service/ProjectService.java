package com.example.demo.service;


import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project findProjectById(Integer id) {
        return projectRepository.findById(id).orElse(null) ;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public void save(Project project) {
        projectRepository.save(project);
    }


    public void delete (Integer id) {projectRepository.deleteById(id);}


}
