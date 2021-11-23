package grsu.lection.service;

import grsu.lection.dao.api.UserDetailsDao;
import grsu.lection.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsDao userDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AppUser appUser = Optional.ofNullable(userDetailsDao.getByName(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(appUser.getRole().toString())
                .build();
    }
}
