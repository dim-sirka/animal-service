package com.dimsirka.animalservice.services;

import com.dimsirka.animalservice.entities.Admin;

public interface AdminService {
    Admin create(Admin admin);

    Admin update(Admin admin);

    Admin getById(Long id);
}
