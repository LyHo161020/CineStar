package com.cg.cinestar.service.user;

import com.cg.cinestar.model.User;
import com.cg.cinestar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void unlockUser(Long id) {
        userRepository.unlockUser(id);
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
}
