package kg.mega.saloon.models.entities;

import kg.mega.saloon.enums.WorkDayEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //ключ будет генерироваться
    Long id;
    LocalTime startTime;
    LocalTime endTime;
    @Enumerated(EnumType.STRING)
    WorkDayEnum workDay;
}
