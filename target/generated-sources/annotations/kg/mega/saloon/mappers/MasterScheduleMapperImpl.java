package kg.mega.saloon.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.mega.saloon.models.dto.MasterDto;
import kg.mega.saloon.models.dto.MasterScheduleDto;
import kg.mega.saloon.models.dto.SaloonDto;
import kg.mega.saloon.models.dto.ScheduleDto;
import kg.mega.saloon.models.entities.Master;
import kg.mega.saloon.models.entities.MasterSchedule;
import kg.mega.saloon.models.entities.Saloon;
import kg.mega.saloon.models.entities.Schedule;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T12:31:27+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
public class MasterScheduleMapperImpl implements MasterScheduleMapper {

    @Override
    public MasterSchedule toEntity(MasterScheduleDto d) {
        if ( d == null ) {
            return null;
        }

        MasterSchedule masterSchedule = new MasterSchedule();

        masterSchedule.setId( d.getId() );
        masterSchedule.setMaster( masterDtoToMaster( d.getMaster() ) );
        masterSchedule.setSchedule( scheduleDtoToSchedule( d.getSchedule() ) );

        return masterSchedule;
    }

    @Override
    public MasterScheduleDto toDto(MasterSchedule e) {
        if ( e == null ) {
            return null;
        }

        MasterScheduleDto masterScheduleDto = new MasterScheduleDto();

        masterScheduleDto.setId( e.getId() );
        masterScheduleDto.setMaster( masterToMasterDto( e.getMaster() ) );
        masterScheduleDto.setSchedule( scheduleToScheduleDto( e.getSchedule() ) );

        return masterScheduleDto;
    }

    @Override
    public List<MasterSchedule> toEntities(List<MasterScheduleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<MasterSchedule> list1 = new ArrayList<MasterSchedule>( list.size() );
        for ( MasterScheduleDto masterScheduleDto : list ) {
            list1.add( toEntity( masterScheduleDto ) );
        }

        return list1;
    }

    @Override
    public List<MasterScheduleDto> toDtos(List<MasterSchedule> list) {
        if ( list == null ) {
            return null;
        }

        List<MasterScheduleDto> list1 = new ArrayList<MasterScheduleDto>( list.size() );
        for ( MasterSchedule masterSchedule : list ) {
            list1.add( toDto( masterSchedule ) );
        }

        return list1;
    }

    protected Saloon saloonDtoToSaloon(SaloonDto saloonDto) {
        if ( saloonDto == null ) {
            return null;
        }

        Saloon saloon = new Saloon();

        saloon.setId( saloonDto.getId() );
        saloon.setName( saloonDto.getName() );
        saloon.setAddress( saloonDto.getAddress() );
        saloon.setPhoneNumber( saloonDto.getPhoneNumber() );
        saloon.setActive( saloonDto.isActive() );

        return saloon;
    }

    protected Master masterDtoToMaster(MasterDto masterDto) {
        if ( masterDto == null ) {
            return null;
        }

        Master master = new Master();

        master.setId( masterDto.getId() );
        master.setName( masterDto.getName() );
        master.setSurname( masterDto.getSurname() );
        master.setActive( masterDto.isActive() );
        master.setSaloon( saloonDtoToSaloon( masterDto.getSaloon() ) );
        master.setWorkType( masterDto.getWorkType() );

        return master;
    }

    protected Schedule scheduleDtoToSchedule(ScheduleDto scheduleDto) {
        if ( scheduleDto == null ) {
            return null;
        }

        Schedule schedule = new Schedule();

        schedule.setId( scheduleDto.getId() );
        schedule.setStartTime( scheduleDto.getStartTime() );
        schedule.setEndTime( scheduleDto.getEndTime() );
        schedule.setWorkDay( scheduleDto.getWorkDay() );

        return schedule;
    }

    protected SaloonDto saloonToSaloonDto(Saloon saloon) {
        if ( saloon == null ) {
            return null;
        }

        SaloonDto saloonDto = new SaloonDto();

        saloonDto.setId( saloon.getId() );
        saloonDto.setName( saloon.getName() );
        saloonDto.setAddress( saloon.getAddress() );
        saloonDto.setPhoneNumber( saloon.getPhoneNumber() );
        saloonDto.setActive( saloon.isActive() );

        return saloonDto;
    }

    protected MasterDto masterToMasterDto(Master master) {
        if ( master == null ) {
            return null;
        }

        MasterDto masterDto = new MasterDto();

        masterDto.setId( master.getId() );
        masterDto.setName( master.getName() );
        masterDto.setSurname( master.getSurname() );
        masterDto.setSaloon( saloonToSaloonDto( master.getSaloon() ) );
        masterDto.setWorkType( master.getWorkType() );
        masterDto.setActive( master.isActive() );

        return masterDto;
    }

    protected ScheduleDto scheduleToScheduleDto(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        ScheduleDto scheduleDto = new ScheduleDto();

        scheduleDto.setId( schedule.getId() );
        scheduleDto.setStartTime( schedule.getStartTime() );
        scheduleDto.setEndTime( schedule.getEndTime() );
        scheduleDto.setWorkDay( schedule.getWorkDay() );

        return scheduleDto;
    }
}
