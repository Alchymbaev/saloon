package kg.mega.saloon.service;

import kg.mega.saloon.enums.WorkDayEnum;
import kg.mega.saloon.models.dto.ScheduleDto;

import java.time.LocalTime;
import java.util.List;

public interface ScheduleService extends BaseService<ScheduleDto>{

    List<ScheduleDto> getScheduleByMasterName (String name);
    List<ScheduleDto> getScheduleByMasterId (Long id);

    ScheduleDto create(WorkDayEnum workDayEnum, LocalTime startTime, LocalTime endTime);
}
