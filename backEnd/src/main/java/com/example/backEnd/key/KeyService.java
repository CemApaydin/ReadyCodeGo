package com.example.backEnd.key;
import com.example.backEnd.student.Student;

import java.util.List;
public interface KeyService {
    public List<Key> getAllKeys();
    public Key findById(Long keyID);
    public Key saveKeys(Key key);
    public Key saveCoordinatorKey(Key key);
    public Key saveInstructorKey(Key key);
    public Key saveFacultyBoardMemberKey(Key key);


    }
