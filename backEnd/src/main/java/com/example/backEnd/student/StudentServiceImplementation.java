package com.example.backEnd.student;
import com.example.backEnd.university.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.backEnd.application.Application;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    static String SHEET = "Universities";
    private final StudentRepository studentRepository;
    private final UniversityRepository universityList;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository, UniversityRepository uni) {
        this.studentRepository = studentRepository;
        this.universityList = uni;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        //return studentRepository.findAll();
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long userId) {
        return studentRepository.findById(userId).orElse(null);
    }
    public void excelToStudentList(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Student> students = studentRepository.findAll();
            int rowNumber = 0;
            while(rows.hasNext()) {
                Row currentRow = rows.next(); 
                // skip header (this means that the table should be in the same format forever)
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.cellIterator();
                int cellId = 23;
                Double id = Double.valueOf(currentRow.getCell(4).getNumericCellValue()); // again should be the same format (cellnum:4)
                if(studentRepository.findById(id.longValue()).isPresent()) {
                    Application app = new Application();
                    Set <Long> uniIDs = new HashSet<Long>(5);
                    Long uniID;
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();
                        switch(cellId) {
                            case(23):
                            uniID = universityList.findByName(currentCell.getStringCellValue()).getUniversityID();
                            uniIDs.add(uniID);
                            break;
                            case(24):
                            uniID = universityList.findByName(currentCell.getStringCellValue()).getUniversityID();
                            uniIDs.add(uniID);
                            break;
                            case(25):
                            uniID = universityList.findByName(currentCell.getStringCellValue()).getUniversityID();
                            uniIDs.add(uniID);
                            break;
                            case(26):
                            uniID = universityList.findByName(currentCell.getStringCellValue()).getUniversityID();
                            uniIDs.add(uniID);
                            break;
                            case(27):
                            uniID = universityList.findByName(currentCell.getStringCellValue()).getUniversityID();
                            uniIDs.add(uniID);
                            break;
                        }  
                    }
                    app.setAppliedUniversityIds(uniIDs);
                    studentRepository.findById(id.longValue()).ifPresent(student-> student.setApplication(app));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }      
}
