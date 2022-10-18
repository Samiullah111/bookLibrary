package com.example.booklibrary;

import com.example.booklibrary.Repository.UserRepository;
import com.example.booklibrary.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailService implements UserDetailsService
{

private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =repo.findByUsername(username);
    if(user==null)
        throw new UsernameNotFoundException("User Not Found ");
    return new UserPrincipals(user);
    }
}
