package com.aerotravel.flightticketbooking.services.servicesimpl;


import com.aerotravel.flightticketbooking.model.User;
import com.aerotravel.flightticketbooking.repository.UserRepository;
import com.aerotravel.flightticketbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service

public class UserServiceImpl implements UserService {

    public User getUser() {
        return null;
    }

    public void createUser() {

    }


}
