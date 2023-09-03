package carte.proj.teachexback.service

import carte.proj.teachexback.model.Student
import carte.proj.teachexback.repository.StudentRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StudentService(
    val repo: StudentRepository,
) {

    fun addStudent(student: Student) {
        if (repo.findById(student.id).isPresent)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "student already exists with that id")

        repo.save(student)
    }

    fun updateStudent(id: Long, student: Student) {
        if (repo.findById(id).isEmpty)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "no student available to update")

        repo.save(student)
    }

    fun getAllStudents(): MutableList<Student> = repo.findAll()


    fun removeStudent(id: Long): Student {
        val potentialStudent = repo.findById(id);
        if (potentialStudent.isEmpty)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "no student available to delete")

        repo.delete(potentialStudent.get())
        return potentialStudent.get();
    }



}