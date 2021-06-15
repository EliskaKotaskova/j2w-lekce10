package cz.czechitas.java2webapps.lekce10.controller;
import cz.czechitas.java2webapps.lekce10.service.RodicService;
import cz.czechitas.java2webapps.lekce10.service.StudentService;
import cz.czechitas.java2webapps.lekce10.service.UcitelService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import cz.czechitas.java2webapps.lekce10.service.TridaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;


@Controller
public class TridaController {
    private final TridaService tridaService;
    private final StudentService studentService;
    private final RodicService rodicService;
    private final UcitelService ucitelService;

    @Autowired
    public TridaController(TridaService tridaService, StudentService studentService, RodicService rodicService, UcitelService ucitelService) {
        this.tridaService = tridaService;
        this.studentService = studentService;
        this.rodicService = rodicService;
        this.ucitelService = ucitelService;

    }

    @GetMapping("/")
    public ModelAndView zakladniSeznam(@PageableDefault(value = 20, sort = {"id"}) Pageable pageable) {
        return new ModelAndView("tridy")
                .addObject("tridy", tridaService.seznamTrid(pageable));
    }

    @GetMapping("/trida/{id:[0-9]+}")
    public ModelAndView trida(@PathVariable short id, @PageableDefault(sort = {"prijmeni"}) Pageable pageable) {
        return new ModelAndView("trida")
                .addObject("trida", tridaService.trida(id));
    }

    @GetMapping("/student/{id:[0-9]+}")
    public ModelAndView student(@PathVariable Integer id) {
        return new ModelAndView("student")
                .addObject("student", studentService.student(id));
    }
}