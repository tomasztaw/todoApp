/**
 * Created by tomasz_taw
 * Date: 08.12.2023
 * Time: 21:05
 * Project Name: todoApp
 * Description:
 */
package pl.taw.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final TaskService taskService;

    @GetMapping
    public String homePage(Model model) {
        List<String> taskTypes = taskService.listOfTaskTypes();
        model.addAttribute("taskTypes", taskTypes);

        return "index";
    }
}
