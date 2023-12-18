package com.example.service;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    @RolesAllowed("ADMIN")
    public String getName() {
        return "Fantastico";
    }
}