package com.cg.cinestar.service.user;

import com.cg.cinestar.model.User;
import com.cg.cinestar.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    void blockUser(Long id);

    void unlockUser(Long id);

    User updateUser(Optional<User> user, User userUpdate);

    List<User> search(String searchInput);

    User create(User user);

}
