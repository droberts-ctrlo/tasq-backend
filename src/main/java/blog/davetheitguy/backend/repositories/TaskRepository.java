package blog.davetheitguy.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.davetheitguy.backend.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
