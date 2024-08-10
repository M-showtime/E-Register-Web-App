package eRegistrarWebAPI.Service;
import eRegistrarWebAPI.Domain.Student;
import eRegistrarWebAPI.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

//
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
//

//
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setStudentNumber(updatedStudent.getStudentNumber());
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setMiddleName(updatedStudent.getMiddleName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setCgpa(updatedStudent.getCgpa());
                    student.setEnrollmentDate(updatedStudent.getEnrollmentDate());
                    student.setIsInternational(updatedStudent.getIsInternational());
                    return studentRepository.save(student);
                }).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}

