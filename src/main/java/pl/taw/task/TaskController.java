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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @GetMapping("/{taskId}")
    public String showTaskById(@PathVariable("taskId") Integer id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);

        return "taskDetails";
    }


    @GetMapping("/new")
    public String showAddTaskForm(Model model) {
        Task newTask = new Task();
        model.addAttribute("newTask", newTask);
        return "add-task";
    }

    @PostMapping
    public String addTask(@ModelAttribute("newTask") Task newTask) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        String format = LocalDateTime.now().format(formatter);
        Task taskForSave = Task.builder()
                .taskId(newTask.getTaskId())
                .taskType(newTask.getTaskType())
                .taskTitle(newTask.getTaskTitle())
                .taskContent(newTask.getTaskContent())
                .createdTime(LocalDateTime.now())
                .build();
        taskService.saveTask(taskForSave);

        return "redirect:/tasks";
    }
}
