package com.dimsirka.animalservice.services.impl;

import com.dimsirka.animalservice.entities.Admin;
import com.dimsirka.animalservice.exceptions.AdminNotFoundException;
import com.dimsirka.animalservice.repositories.AdminRepository;
import com.dimsirka.animalservice.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin update(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(()-> new AdminNotFoundException("Admin with a specified id isn't found!"));
    }
}
