package com.cg.cinestar.service.user;

import com.cg.cinestar.model.User;
import com.cg.cinestar.model.UserPrinciple;
import com.cg.cinestar.model.dto.UserDTO;
import com.cg.cinestar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void blockUser(Long id) {
        userRepository.blockUser(id);
    }

    @Override
    public Optional<UserDTO> unlockUser(Long id) {
        userRepository.unlockUser(id);
        return null;
    }

    @Override
    public User create(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> search(String searchInput) {
        List<User> users = findAll();
        List<User> listSearch = new ArrayList<>();

        for(User user : users){
            if(user.toString().toLowerCase().contains(searchInput)){
                listSearch.add(user);
            }
        }

        return listSearch;
    }


    @Override
    public User updateUser(Optional<User> user, User userUpdate) {

        return user.get()
                .setFullName(userUpdate.getFullName())
                .setPhone(userUpdate.getPhone())
                .setEmail(userUpdate.getEmail())
                .setAddress(userUpdate.getAddress())
                .setDateOfBirth(userUpdate.getDateOfBirth());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(userOptional.get());
    }

    public Optional<UserDTO> findUserDTOByID(Long id) {
        return userRepository.findUserDTOByID(id);
    }

    @Override
    public Optional<UserDTO> findUserDTOByUsername(String username) {
        return userRepository.findUserDTOByUsername(username);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
