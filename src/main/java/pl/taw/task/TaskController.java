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
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);

        return "taskDetails";
    }

    @GetMapping("/{taskType}")
    public String tasksByType(@PathVariable("taskType") String taskType, Model model) {
        List<Task> tasks = taskService.findTasksByType(taskType);

        model.addAttribute("tasks", tasks);

        return "tasksByType";
    }

    @GetMapping("/new")
    public String showAddTaskForm(Model model) {
        Task newTask = new Task();
        model.addAttribute("newTask", newTask);
        return "add-task";
    }

    @PostMapping
    public String addTask(@ModelAttribute("newTask") Task newTask) {
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

    @PutMapping("/complete/{taskId}")
    public String completeTask(@PathVariable Integer taskId) {
        Task task = taskService.findTaskById(taskId);
        if (task != null) {
            task.setCompleted(true);
            taskService.saveTask(task);
        }

        return "redirect:/tasks";
    }

    @GetMapping("/complete/{taskId}")
    public String completeTaskGet(@PathVariable Integer taskId) {
        return "redirect:/tasks";
    }

    @PostMapping("/complete/{taskId}")
    public String completeTaskPost(@PathVariable Integer taskId) {
        Task task = taskService.findTaskById(taskId);
        if (task != null) {
            task.setCompleted(true);
            taskService.saveTask(task);
        }
        return "redirect:/tasks";
    }

    @DeleteMapping("/delete/{taskId}")
    public String deleteTaskById(@PathVariable Integer taskId) {
        Task task = taskService.findTaskById(taskId);
        if (task != null) {
            taskService.deleteTask(task);
        } else {
            throw new RuntimeException("There is no task with id: " + taskId);
        }
        return "redirect:/tasks";
    }
}
