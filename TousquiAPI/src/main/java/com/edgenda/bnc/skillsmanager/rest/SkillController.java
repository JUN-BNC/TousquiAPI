package com.edgenda.bnc.skillsmanager.rest;

import com.edgenda.bnc.skillsmanager.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(path = "" , method = RequestMethod.GET)
    public List<Skill> getSkills() {
        return skillService.getSkills();
    }

    @RequestMapping(path = "/{id}/employees" , method = RequestMethod.GET)
    public List<Employee> getEmployeesSkills(@PathVariable Long id) {
        return skillService.getSkill(id).getEmployees();
    }

    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    public Skill getSkill(@PathVariable Long id) {
        return skillService.getSkill(id);
    }
}
