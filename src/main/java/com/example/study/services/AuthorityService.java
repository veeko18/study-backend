package com.example.study.services;

import com.example.study.models.Authority;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle authority related operations
 *
 * @author Vinod John
 */
public interface AuthorityService {
    /**
     * To create a new authority
     *
     * @param authority Authority
     */
    void createAuthority(Authority authority);

    /**
     * To find authority by name
     *
     * @param name Authority name
     * @return optional of authority
     */
    Optional<Authority> findAuthorityByName(String name);

    /**
     * To find all authorities
     *
     * @return list of authority
     */
    List<Authority> findAllAuthorities();
}
