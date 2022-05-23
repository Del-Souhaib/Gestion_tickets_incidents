package com.example.gestion_tickets_incidents.service;

import com.example.gestion_tickets_incidents.model.Role;
import com.example.gestion_tickets_incidents.model.User;
import com.example.gestion_tickets_incidents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        for (Role r : user.getRoles())
            System.out.println("Role:" + r.getNom());
        return new MyUserDetails(user);
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                user.getRoles().stream().map(r -> new SimpleGrantedAuthority( r.getNom())).collect(Collectors.toList()));


    }


}
