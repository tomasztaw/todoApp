/**
 * Created by tomasz_taw
 * Date: 26.11.2023
 * Time: 20:53
 * Project Name: todoApp
 * Description:
 */
package pl.taw.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String showTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);

        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String showTaskById(@PathVariable("taskId") Integer id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);

        return "taskDetails";
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
}
