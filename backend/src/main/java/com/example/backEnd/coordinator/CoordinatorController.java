package com.example.backEnd.coordinator;

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
    @PostMapping("/addUniversity/{userId}")
    public String addUniversity(@PathVariable Long userId,@RequestBody Long universityID)
    {
        Coordinator coordinator = coordinatorService.findById(userId);
        coordinator.addUniversityIdList(universityID);
        coordinatorService.saveCoordinator(coordinator);
        return "done";

    }
    @GetMapping("/{userId}")
    public Coordinator getOneStudent(@PathVariable Long userId)
    {
        return coordinatorService.findById(userId);
    }
    @GetMapping("/getUniversity/{userId}")
    public List<Long> getUniversity(@PathVariable Long userId)
    {
        return coordinatorService.findById(userId).getUniversityIdList();
    }
    @GetMapping("/getApplication/{userId}")
    public List<Long> getApplication(@PathVariable Long userId)
    {
        return coordinatorService.findById(userId).getApplicationIdList();
    }
    @PostMapping("/addApplication/{userId}")
    public String addApplication(@PathVariable Long userId, @RequestBody Long applicationID)
    {
        Coordinator coordinator = coordinatorService.findById(userId);
        coordinator.addApplicationIdList(applicationID);
        coordinatorService.saveCoordinator(coordinator);
        return "done";
    }
    @GetMapping("/coordinator/{userId}")
    public Coordinator getOneStudentA(@PathVariable Long userId)
    {
        return coordinatorService.findById(userId);
    }

}
