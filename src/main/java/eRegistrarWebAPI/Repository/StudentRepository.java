package eRegistrarWebAPI.Repository;
import eRegistrarWebAPI.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //public Student findByStudentNumber(String studentNumber);


}
