/**
 * Created by tomasz_taw
 * Date: 25.11.2023
 * Time: 21:56
 * Project Name: todoApp
 * Description:
 */
package pl.taw.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
@With
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    private String taskType;
    private String taskContent;
    private LocalDateTime timestamp;

}
