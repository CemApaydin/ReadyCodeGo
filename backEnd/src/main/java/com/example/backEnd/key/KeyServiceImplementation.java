package com.example.backEnd.key;

import com.example.backEnd.student.Student;
import com.example.backEnd.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KeyServiceImplementation implements KeyService {

    private final KeyRepository keyRepository;

    @Autowired
    public KeyServiceImplementation(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    @Override
    public Key saveInstructorKey(Key key) {

        String newKey = key.generateToken();
        String type = "Instructor";
        key.setKeyType(type);
        key.setKey(newKey);
        return keyRepository.save(key);
    }
    @Override
    public Key saveFacultyBoardMemberKey(Key key) {
        String newKey = key.generateToken();
        String type = "FacultyBoardMember";
        key.setKeyType(type);
        key.setKey(newKey);
        return keyRepository.save(key);
    }
    @Override
    public Key saveCoordinatorKey(Key key) {
        String newKey = key.generateToken();
        String type = "Coordinator";
        key.setKeyType(type);
        key.setKey(newKey);
        return keyRepository.save(key);
    }


    @Override
    public List<Key> getAllKeys() {
        return keyRepository.findAll();
    }
    @Override
    public Key findById(Long keyID) {
        return keyRepository.findById(keyID).orElse(null);
    }
    @Override
    public Key saveKeys(Key key) {
        return keyRepository.save(key);
    }



}
