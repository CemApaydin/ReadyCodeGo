package com.example.backEnd.key;

import com.example.backEnd.course.Course;
import com.example.backEnd.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/key")
public class KeyController {
    private final KeyService keyService;

    @Autowired
    public KeyController(KeyService keyService) {
        this.keyService = keyService;
    }

    @GetMapping("/findAll")
    public List<Key> getAllKeys()
    {
        return keyService.getAllKeys();
    }

    @PostMapping("/createKey/facultyBoardMember")
    public String createFacultyBoardMemberKey(@RequestBody Key newKey)
    {

        keyService.saveFacultyBoardMemberKey(newKey);
        return "Adding Done!!";
    }

    @PostMapping("/createKey/instructor")
    public String createInstructorKey(@RequestBody Key newKey)
    {

        keyService.saveInstructorKey(newKey);
        return "Adding Done!!";
    }

    @PostMapping("/createKey/coordinator")
    public String createCoordinatorKey(@RequestBody Key newKey)
    {

        keyService.saveCoordinatorKey(newKey);
        return "Adding Done!!";
    }

    @GetMapping("/{keyID}")
    public Key getOneKey(@PathVariable long keyID)
    {
        return keyService.findById(keyID);
    }
    @GetMapping("/key/{keyID}")
    public Key getOneKeyA(@PathVariable long keyID)
    {
        return keyService.findById(keyID);
    }

    @GetMapping("/checkKey/facultyBoardMember/{key}")
    public Boolean checkFacultyBoardMemberKey(@PathVariable String key)
    {
        List<Key> keys = keyService.getAllKeys();
        //i = 0 olcak
        for(int i = 0; i < keys.size(); i++) {
            if( keys.get(i).getKeyType().equals("FacultyBoardMember")) {
                if (keys.get(i).getKey().equals(key)) {
                    System.out.println("Key Matched!");
                    return true;
                }

            }
        }
        System.out.println("ERROR! Key Not MATCHED!");
        return false;
    }

    @GetMapping("/checkKey/instructor/{key}")
    public Boolean checkInstructorKey(@PathVariable String key)
    {

        List<Key> keys = keyService.getAllKeys();
        for(int i = 0; i < keys.size(); i++) {
            if( keys.get(i).getKeyType().equals("Instructor")) {
                if (keys.get(i).getKey().equals(key)) {
                    System.out.println("Key Matched!");
                    return true;
                }

            }
        }
        System.out.println("ERROR! Key Not MATCHED!");
        return false;
    }

    @GetMapping("/checkKey/coordinator/{key}")
    public Boolean checkCoordinatorKey(@PathVariable String key)
    {
        List<Key> keys = keyService.getAllKeys();
        for(int i = 0; i < keys.size(); i++) {
                if( keys.get(i).getKeyType().equals("Coordinator")) {
                    if (keys.get(i).getKey().equals(key)) {
                        System.out.println("Key Matched!");
                        return true;
                    }

                }
        }
        System.out.println("ERROR! Key Not MATCHED!");
        return false;
    }


}
