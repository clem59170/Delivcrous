package com.example.delivcrous.service;

import com.example.delivcrous.model.Plat;
import com.example.delivcrous.repository.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatService {

    @Autowired
    private PlatRepository platRepository;

    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    public void createPlat(Plat plat) {
        platRepository.save(plat);
    }
}
