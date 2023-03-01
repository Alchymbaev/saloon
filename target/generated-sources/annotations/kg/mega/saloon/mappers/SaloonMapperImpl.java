package kg.mega.saloon.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.mega.saloon.models.dto.SaloonDto;
import kg.mega.saloon.models.entities.Saloon;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T12:31:26+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
public class SaloonMapperImpl implements SaloonMapper {

    @Override
    public Saloon toEntity(SaloonDto d) {
        if ( d == null ) {
            return null;
        }

        Saloon saloon = new Saloon();

        saloon.setId( d.getId() );
        saloon.setName( d.getName() );
        saloon.setAddress( d.getAddress() );
        saloon.setPhoneNumber( d.getPhoneNumber() );
        saloon.setActive( d.isActive() );

        return saloon;
    }

    @Override
    public SaloonDto toDto(Saloon e) {
        if ( e == null ) {
            return null;
        }

        SaloonDto saloonDto = new SaloonDto();

        saloonDto.setId( e.getId() );
        saloonDto.setName( e.getName() );
        saloonDto.setAddress( e.getAddress() );
        saloonDto.setPhoneNumber( e.getPhoneNumber() );
        saloonDto.setActive( e.isActive() );

        return saloonDto;
    }

    @Override
    public List<Saloon> toEntities(List<SaloonDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Saloon> list1 = new ArrayList<Saloon>( list.size() );
        for ( SaloonDto saloonDto : list ) {
            list1.add( toEntity( saloonDto ) );
        }

        return list1;
    }

    @Override
    public List<SaloonDto> toDtos(List<Saloon> list) {
        if ( list == null ) {
            return null;
        }

        List<SaloonDto> list1 = new ArrayList<SaloonDto>( list.size() );
        for ( Saloon saloon : list ) {
            list1.add( toDto( saloon ) );
        }

        return list1;
    }
}
