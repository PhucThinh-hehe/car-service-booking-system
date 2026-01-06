package com.example.carservicebooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carservicebooking.entity.User;
public interface UserRepository extends JpaRepository<User, String> {
    
    boolean existsByUsername(String username);
}
