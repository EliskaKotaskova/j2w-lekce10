package cz.czechitas.java2webapps.lekce10.repository;

import cz.czechitas.java2webapps.lekce10.entity.Trida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public interface TridaRepository  extends JpaRepository<Trida, Short> {

    @Query("SELECT p FROM Trida p WHERE p.nazev IS NOT null ORDER BY p.nazev")
    Page<Trida> findTridy(Pageable tridyList);

}
