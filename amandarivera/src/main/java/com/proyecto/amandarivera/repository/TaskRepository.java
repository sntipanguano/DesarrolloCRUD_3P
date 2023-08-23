package com.proyecto.amandarivera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.amandarivera.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
