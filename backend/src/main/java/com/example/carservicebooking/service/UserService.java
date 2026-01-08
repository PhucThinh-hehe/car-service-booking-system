package com.example.carservicebooking.service;
import com.example.carservicebooking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import com.example.carservicebooking.entity.User;
import com.example.carservicebooking.exception.CustomException;
import com.example.carservicebooking.dto.request.UserCreatetionRequest;
import com.example.carservicebooking.dto.request.UserUpdateRequest;
import com.example.carservicebooking.exception.ErrorCode;
import java.util.List;
import com.example.carservicebooking.dto.response.UserResponse;
import com.example.carservicebooking.mapper.UserMapper;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
     UserMapper userMapper;

     ///create user
    public UserResponse _createUser( UserCreatetionRequest request) {
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername())) {
            throw new CustomException(ErrorCode.USER_EXISTED);
        }
        
        user = userMapper.creatUser(request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    ///get all users
    public List<UserResponse> _getAllUsers() {
        return userMapper.toAllUserResponse(userRepository.findAll());
    }


    ///get user by id
    public UserResponse _getUserById(String id) {

        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND)));
    }

    ///update user
    public UserResponse _updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        if (user == null) {
           throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
         userMapper.updateUser(user, request);  
        return userMapper.toUserResponse(userRepository.save(user));
    }


    ///delete user
    public String _deleteUser(String id){
        User user = userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        try{
            if (user !=null) {
                userRepository.delete(user);
            }
            return "User deleted successfully.";
        } catch (CustomException cException) {
            return "Error deleting user: " + cException.getMessage(); 
        }
    }
}
