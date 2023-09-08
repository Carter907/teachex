package carte.proj.teachexback.service

import carte.proj.teachexback.model.Teacher
import carte.proj.teachexback.repository.TeacherRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TeacherService(
    val repo: TeacherRepository
) {

    fun addTeacher(teacher: Teacher) {
        if (repo.findById(teacher.id).isPresent)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "student already exists with that id")

        repo.save(teacher)
    }

    fun updateTeacher(id: Long, teacher: Teacher) {
        if (repo.findById(id).isEmpty)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "no student available to update")

        repo.save(teacher)
    }

    fun getAllTeachers(): MutableList<Teacher> = repo.findAll()


    fun removeTeacher(id: Long): Teacher {
        val potentialTeacher = repo.findById(id);
        if (potentialTeacher.isEmpty)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "no student available to delete")

        repo.delete(potentialTeacher.get())
        return potentialTeacher.get();
    }

}