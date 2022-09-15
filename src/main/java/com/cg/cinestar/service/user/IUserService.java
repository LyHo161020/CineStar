package com.cg.cinestar.service.user;

import com.cg.cinestar.model.User;
import com.cg.cinestar.model.dto.UserDTO;
import com.cg.cinestar.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {

    User getByUsername(String username);
    void blockUser(Long id);

    Optional<UserDTO> unlockUser(Long id);

    User updateUser(Optional<User> user, User userUpdate);

    User create(User user);


    List<User> search(String searchInput);


    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    Optional<UserDTO> findUserDTOByID(Long id);

    Optional<UserDTO> findUserDTOByUsername(String username);
}
