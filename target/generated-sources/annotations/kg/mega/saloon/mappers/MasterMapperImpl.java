package kg.mega.saloon.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.mega.saloon.models.dto.MasterDto;
import kg.mega.saloon.models.dto.SaloonDto;
import kg.mega.saloon.models.entities.Master;
import kg.mega.saloon.models.entities.Saloon;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T12:31:26+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
public class MasterMapperImpl implements MasterMapper {

    @Override
    public Master toEntity(MasterDto d) {
        if ( d == null ) {
            return null;
        }

        Master master = new Master();

        master.setId( d.getId() );
        master.setName( d.getName() );
        master.setSurname( d.getSurname() );
        master.setActive( d.isActive() );
        master.setSaloon( saloonDtoToSaloon( d.getSaloon() ) );
        master.setWorkType( d.getWorkType() );

        return master;
    }

    @Override
    public MasterDto toDto(Master e) {
        if ( e == null ) {
            return null;
        }

        MasterDto masterDto = new MasterDto();

        masterDto.setId( e.getId() );
        masterDto.setName( e.getName() );
        masterDto.setSurname( e.getSurname() );
        masterDto.setSaloon( saloonToSaloonDto( e.getSaloon() ) );
        masterDto.setWorkType( e.getWorkType() );
        masterDto.setActive( e.isActive() );

        return masterDto;
    }

    @Override
    public List<Master> toEntities(List<MasterDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Master> list1 = new ArrayList<Master>( list.size() );
        for ( MasterDto masterDto : list ) {
            list1.add( toEntity( masterDto ) );
        }

        return list1;
    }

    @Override
    public List<MasterDto> toDtos(List<Master> list) {
        if ( list == null ) {
            return null;
        }

        List<MasterDto> list1 = new ArrayList<MasterDto>( list.size() );
        for ( Master master : list ) {
            list1.add( toDto( master ) );
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
}
