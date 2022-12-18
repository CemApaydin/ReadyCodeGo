package com.example.backEnd.student;

import com.example.backEnd.university.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class StudentServiceImplementation implements StudentService {
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
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long userId) {
        return studentRepository.findById(userId).orElse(null);
    }
    
    public void excelToStudentList(InputStream is) {
        int index = 0;
        try {
            if(is== null) {
                System.out.println("null");    
            }
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            while(rows.hasNext()) {
                Row currentRow = rows.next(); 
                // skip header (this means that the table should be in the same format forever)
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.cellIterator();
                int cellId = 0;
                Double id = Double.valueOf(currentRow.getCell(3).getNumericCellValue()); // again should be the same format (cellnum:3)
                System.out.println(id);
                if(studentRepository.findById(id.longValue()).isPresent()) {
                    Student student = studentRepository.findById(id.longValue()).get();
                    System.out.println(student.getName());
                    Set <Long> uniIDs = new HashSet<Long>(5);
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();
                        switch(cellId) {
                            case(20):
                            student.setPlacementGrade(currentCell.getNumericCellValue());
                            System.out.println("placement grade is:" + student.getPlacementGrade());
                            break;
                            case(22):
                            universityList.findByName(currentCell.getStringCellValue()).ifPresent( university -> 
                            {
                                uniIDs.add(university.getUniversityID());
                                    System.out.println(currentRow.getCell(21).getStringCellValue());
                                    if(currentRow.getCell(21).getStringCellValue().equals("Bahar Dönemi")) {
                                        System.out.println("system works");
                                        System.out.println(student.isPlaced());
                                        System.out.println(university.getStudentLimit());
                                        if(!(student.isPlaced())&& university.getStudentLimit()> 0) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(0);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                    }
                                    else if(currentRow.getCell(21).getStringCellValue().equals("Güz Dönemi")) {
                                        if(!(student.isPlaced())&&  0 < university.getStudentLimit2()) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit2()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(1);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                }
                                else if(currentRow.getCell(21).getStringCellValue().equals("1 Akademik Yil")) {
                                    if(!(student.isPlaced())&& university.getStudentLimit()>0 && university.getStudentLimit2()>0 ){
                                        student.setPlaced(true);
                                        student.setHostUniversityID(university.getUniversityID());
                                        university.setStudentLimit(university.getStudentLimit2()-1);
                                        university.setStudentLimit(university.getStudentLimit()-1);
                                        university.incrementNumofStudents();
                                        university.setPreferedSemester(2);
                                        System.out.println("student is placed:" + university);
                                        universityList.save(university);
                                        studentRepository.save(student);
                                    }
                                }
                            });
                            break;
                            case(23):
                            universityList.findByName(currentCell.getStringCellValue()).ifPresent( university -> 
                            {
                                uniIDs.add(university.getUniversityID());
                                    System.out.println(currentRow.getCell(21).getStringCellValue());
                                    if(currentRow.getCell(21).getStringCellValue().equals("Bahar Dönemi")) {
                                        if(!(student.isPlaced())&& university.getStudentLimit()> 0) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(0);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                    }
                                    else if(currentRow.getCell(21).getStringCellValue().equals("Güz Dönemi")) {
                                        if(!(student.isPlaced())&&  0 < university.getStudentLimit2()) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit2()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(1);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                }
                                else if(currentRow.getCell(21).getStringCellValue().equals("1 Akademik Yil")) {
                                    if(!(student.isPlaced())&& university.getStudentLimit() > 0 && university.getStudentLimit2() > 0 ){
                                        student.setPlaced(true);
                                        student.setHostUniversityID(university.getUniversityID());
                                        university.setStudentLimit(university.getStudentLimit2()-1);
                                        university.setStudentLimit(university.getStudentLimit()-1);
                                        university.incrementNumofStudents();
                                        university.setPreferedSemester(2);
                                        System.out.println("student is placed:" + university);
                                        universityList.save(university);
                                        studentRepository.save(student);
                                    }
                                }
                            });
                            break;
                            case(24):
                            universityList.findByName(currentCell.getStringCellValue()).ifPresent( university -> 
                            {
                                uniIDs.add(university.getUniversityID());
                                    System.out.println(currentRow.getCell(21).getStringCellValue());
                                    if(currentRow.getCell(21).getStringCellValue().equals("Bahar Dönemi")) {
                                        if(!(student.isPlaced())&& university.getStudentLimit()> 0) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(0);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                    }
                                    else if(currentRow.getCell(21).getStringCellValue().equals("Güz Dönemi")) {
                                        if(!(student.isPlaced())&&  0 < university.getStudentLimit2()) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit2()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(1);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                }
                                else if(currentRow.getCell(21).getStringCellValue().equals("1 Akademik Yil")) {
                                    if(!(student.isPlaced())&& university.getStudentLimit() > 0 && university.getStudentLimit2() > 0 ){
                                        student.setPlaced(true);
                                        student.setHostUniversityID(university.getUniversityID());
                                        university.setStudentLimit(university.getStudentLimit2()-1);
                                        university.setStudentLimit(university.getStudentLimit()-1);
                                        university.incrementNumofStudents();
                                        university.setPreferedSemester(2);
                                        System.out.println("student is placed:" + university);
                                        universityList.save(university);
                                        studentRepository.save(student);
                                    }
                                }
                            });
                            break;
                            case(25):
                            universityList.findByName(currentCell.getStringCellValue()).ifPresent( university -> 
                            {
                                uniIDs.add(university.getUniversityID());
                                    System.out.println(currentRow.getCell(21).getStringCellValue());
                                    if(currentRow.getCell(21).getStringCellValue().equals("Bahar Dönemi")) {
                                        if(!(student.isPlaced())&& university.getStudentLimit()> 0) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(0);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                    }
                                    else if(currentRow.getCell(21).getStringCellValue().equals("Güz Dönemi")) {
                                        if(!(student.isPlaced())&&  0 < university.getStudentLimit2()) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit2()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(1);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                }
                                else if(currentRow.getCell(21).getStringCellValue().equals("1 Akademik Yil")) {
                                    if(!(student.isPlaced())&& university.getStudentLimit() > 0 && university.getStudentLimit() > 0){
                                        student.setPlaced(true);
                                        student.setHostUniversityID(university.getUniversityID());
                                        university.setStudentLimit(university.getStudentLimit2()-1);
                                        university.setStudentLimit(university.getStudentLimit()-1);
                                        university.incrementNumofStudents();
                                        university.setPreferedSemester(2);
                                        System.out.println("student is placed:" + university);
                                        universityList.save(university);
                                        studentRepository.save(student);
                                    }
                                }
                            });
                            break;
                            case(26):
                            universityList.findByName(currentCell.getStringCellValue()).ifPresent( university -> 
                            {
                                uniIDs.add(university.getUniversityID());
                                    System.out.println(currentRow.getCell(21).getStringCellValue());
                                    if(currentRow.getCell(21).getStringCellValue().equals("Bahar Dönemi")) {
                                        if(!(student.isPlaced())&& university.getStudentLimit()> 0) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(0);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                    }
                                    else if(currentRow.getCell(21).getStringCellValue().equals("Güz Dönemi")) {
                                        if(!(student.isPlaced())&&  0 < university.getStudentLimit2()) {
                                            student.setPlaced(true);
                                            student.setHostUniversityID(university.getUniversityID());
                                            university.setStudentLimit(university.getStudentLimit2()-1);
                                            university.incrementNumofStudents();
                                            university.setPreferedSemester(1);
                                            System.out.println("student is placed:" + university);
                                            universityList.save(university);
                                            studentRepository.save(student);
                                        }
                                }
                                else if(currentRow.getCell(21).getStringCellValue().equals("1 Akademik Yil")) {
                                    if(!(student.isPlaced())&& university.getStudentLimit()> 0 && university.getStudentLimit2() > 0){
                                        student.setPlaced(true);
                                        student.setHostUniversityID(university.getUniversityID());
                                        university.setStudentLimit(university.getStudentLimit2()-1);
                                        university.setStudentLimit(university.getStudentLimit()-1);
                                        university.incrementNumofStudents();
                                        university.setPreferedSemester(2);
                                        System.out.println("student is placed:" + university);
                                        universityList.save(university);
                                        studentRepository.save(student);
                                    }
                                }
                            });
                            break;
                        }  
                        cellId++;
                    }
                    student.getApplication().setAppliedUniversityIds(uniIDs);
                    studentRepository.save(student);
                }
                workbook.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}

