package blog.davetheitguy.backend.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import blog.davetheitguy.backend.entities.Task;
import blog.davetheitguy.backend.repositories.TaskRepository;
import blog.davetheitguy.backend.services.TaskService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setCompleted(task.isCompleted());
            return taskRepository.saveAndFlush(existingTask);
        });
    }

    @Override
    public void deleteTask(Long id) {
        try{
            taskRepository.deleteById(id);
        }catch(Exception e){
            // noop
        } finally{
            taskRepository.flush();
        }
    }
}
