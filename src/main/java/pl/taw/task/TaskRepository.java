package pl.taw.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("SELECT DISTINCT t.taskType FROM Task t")
    List<String> listOfTaskTypes();
}
