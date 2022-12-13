package com.example.backEnd.coordinator;

import com.example.backEnd.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/coordinator")
public class CoordinatorController {
    private final CoordinatorService coordinatorService;

    @Autowired
    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @GetMapping("/findAll")
    public List<Coordinator> getAllCoordinators()
    {
        return coordinatorService.getAllCoordinators();
    }

    @PostMapping("/createCoordinator")
    public String createCoordinator(@RequestBody Coordinator newCoordinator)
    {

        coordinatorService.saveCoordinator(newCoordinator);
        return "Adding Done!!";
    }
    @GetMapping("/{userId}")
    public Coordinator getOneStudent(@PathVariable Long userId)
    {
        return coordinatorService.findById(userId);
    }
    @GetMapping("/coordinator/{userId}")
    public Coordinator getOneStudentA(@PathVariable Long userId)
    {
        return coordinatorService.findById(userId);
    }

}
