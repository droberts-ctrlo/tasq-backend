package blog.davetheitguy.backend.services;

import java.util.List;
import java.util.Optional;

import blog.davetheitguy.backend.entities.Task;

public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTask(Long id);
    Task createTask(Task task);
    Optional<Task> updateTask(Long id, Task task);
    void deleteTask(Long id);
}
