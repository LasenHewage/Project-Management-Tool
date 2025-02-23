package com.lasen.projectmanagementsystem.repository;

import com.lasen.projectmanagementsystem.model.Project;
import com.lasen.projectmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

// List<Project> finByOwner(User user);

 List<Project> findByNameContainingAndTeamContains(String partialName, User user);

// @Query("SELECT p FROM Project p JOIN p.team t WHERE t=:user")
// List<Project> findProjectByTeam(@Param("user") User user);

 List<Project> findByTeamContainingOrOwner(User user, User owner);

}
