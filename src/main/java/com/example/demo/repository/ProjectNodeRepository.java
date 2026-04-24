package com.example.demo.repository;

import com.example.demo.entity.ProjectNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectNodeRepository extends JpaRepository<ProjectNode, Long> {
}