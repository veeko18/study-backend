package com.example.study.services.implementations;

import com.example.study.models.Authority;
import com.example.study.repositories.AuthorityRepository;
import com.example.study.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of Authority Service
 *
 * @author Vinod John
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void createAuthority(Authority authority) {
        authorityRepository.save(authority);
    }

    @Override
    public Optional<Authority> findAuthorityByName(String name) {
        return authorityRepository.findByName(name);
    }

    @Override
    public List<Authority> findAllAuthorities() {
        return authorityRepository.findAll();
    }
}
