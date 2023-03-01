package kg.mega.saloon.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.mega.saloon.models.dto.ScheduleDto;
import kg.mega.saloon.models.entities.Schedule;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T12:31:27+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
public class ScheduleMapperImpl implements ScheduleMapper {

    @Override
    public Schedule toEntity(ScheduleDto d) {
        if ( d == null ) {
            return null;
        }

        Schedule schedule = new Schedule();

        schedule.setId( d.getId() );
        schedule.setStartTime( d.getStartTime() );
        schedule.setEndTime( d.getEndTime() );
        schedule.setWorkDay( d.getWorkDay() );

        return schedule;
    }

    @Override
    public ScheduleDto toDto(Schedule e) {
        if ( e == null ) {
            return null;
        }

        ScheduleDto scheduleDto = new ScheduleDto();

        scheduleDto.setId( e.getId() );
        scheduleDto.setStartTime( e.getStartTime() );
        scheduleDto.setEndTime( e.getEndTime() );
        scheduleDto.setWorkDay( e.getWorkDay() );

        return scheduleDto;
    }

    @Override
    public List<Schedule> toEntities(List<ScheduleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Schedule> list1 = new ArrayList<Schedule>( list.size() );
        for ( ScheduleDto scheduleDto : list ) {
            list1.add( toEntity( scheduleDto ) );
        }

        return list1;
    }

    @Override
    public List<ScheduleDto> toDtos(List<Schedule> list) {
        if ( list == null ) {
            return null;
        }

        List<ScheduleDto> list1 = new ArrayList<ScheduleDto>( list.size() );
        for ( Schedule schedule : list ) {
            list1.add( toDto( schedule ) );
        }

        return list1;
    }
}
