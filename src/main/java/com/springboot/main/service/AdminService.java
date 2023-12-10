package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.springboot.main.exception.InvalidIdException; // Import the InvalidIdException
import com.springboot.main.model.Admin;
import com.springboot.main.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin insert(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getOne(int id) throws InvalidIdException {
        Optional<Admin> adminOptional = adminRepository.findById(id);
        if (!adminOptional.isPresent()) {
            throw new InvalidIdException("Admin not found with ID: " + id);
        }
        return adminOptional.get();
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void deleteAdmin(Admin admin) {
        adminRepository.delete(admin);
    }
}
