package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Ucitel;
import cz.czechitas.java2webapps.lekce10.repository.UcitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UcitelService {
    private final UcitelRepository ucitelRepository;

    @Autowired
    public UcitelService(UcitelRepository ucitelRepository) {
        this.ucitelRepository = ucitelRepository;
    }

    public Ucitel ucitel(Integer id) {
        return ucitelRepository.getOne(id);
    }
}