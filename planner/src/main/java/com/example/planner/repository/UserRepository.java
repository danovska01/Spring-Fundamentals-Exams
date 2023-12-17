package com.example.planner.repository;

import com.example.planner.model.entity.Task;
import com.example.planner.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username);

    Optional<Object> findUserById(String userId);

    Optional<User> findByEmail(String email);

    Set<User> findAllByIdIsNot(String id);

    Optional<User> findUserByAssignedTasksFalse();
    @Query("SELECT u.assignedTasks FROM User u WHERE u.id = :id")
    Set<Task> findAllByUserId(String id);
}
