package pl.taw.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("SELECT DISTINCT t.taskType FROM Task t")
    List<String> listOfTaskTypes();

    List<Task> findAllByOrderByTaskIdAsc();
    List<Task> findAllByOrderByTaskIdDesc();

    List<Task> findAllByOrderByTaskTypeAsc();
    List<Task> findAllByOrderByTaskTypeDesc();

    List<Task> findAllByOrderByTaskTitleAsc();
    List<Task> findAllByOrderByTaskTitleDesc();

    List<Task> findAllByOrderByTaskTimeAsc();
    List<Task> findAllByOrderByTaskTimeDesc();

    List<Task> findAllByCompletedTrue();
    List<Task> findAllByCompletedFalse();
}
