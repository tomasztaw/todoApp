/**
 * Created by tomasz_taw
 * Date: 25.11.2023
 * Time: 21:56
 * Project Name: todoApp
 * Description:
 */
package pl.taw.task;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@With
@Entity
@Builder
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "task_type")
    private String taskType;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_content")
    private String taskContent;

    @Column(name = "created_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdTime;

    @Column(name = "completed")
    private boolean completed;

}
