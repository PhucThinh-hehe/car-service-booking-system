package com.example.carservicebooking.service;
import com.example.carservicebooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carservicebooking.entity.User;
import com.example.carservicebooking.dto.request.UserCreatetionRequest;
import com.example.carservicebooking.dto.request.UserUpdateRequest;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public User _createUser( UserCreatetionRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setActive(request.isActive());
        user.setCreatedAt(request.getCreatedAt());
        return userRepository.save(user);
    }
    public List<User> _getAllUsers() {
        return userRepository.findAll();
    }
    public User _getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User _updateUser(String id, UserUpdateRequest request) {
        User user = _getUserById(id);
        if (user != null) {
            user.setPassword(request.getPassword());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setAddress(request.getAddress());
            user.setDateOfBirth(request.getDateOfBirth());
            user.setPhoneNumber(request.getPhoneNumber());
            user.setEmail(request.getEmail());
            user.setRole(request.getRole());
            user.setActive(request.isActive());
            user.setCreatedAt(request.getCreatedAt());
            return userRepository.save(user);
        }
        return null;
    }
    public String _deleteUser(String id){
        User user = _getUserById(id);
        if (user !=null) {
            userRepository.delete(user);
        };
        return "Exception: Have some issue in deleting user."; 
    }
}
