package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Rodic;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodicService {
    private final RodicRepository rodicRepository;

    @Autowired
    public RodicService(RodicRepository rodicRepository) {
        this.rodicRepository = rodicRepository;
    }

    public Rodic rodic(Integer id) {
        return rodicRepository.getOne(id);
    }
}
