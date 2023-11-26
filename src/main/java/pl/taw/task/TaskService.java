/**
 * Created by tomasz_taw
 * Date: 26.11.2023
 * Time: 20:58
 * Project Name: todoApp
 * Description:
 */
package pl.taw.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no task with id: %s".formatted(id)));
    }


    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
