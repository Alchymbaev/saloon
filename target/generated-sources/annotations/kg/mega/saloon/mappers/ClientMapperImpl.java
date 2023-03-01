package kg.mega.saloon.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.mega.saloon.models.dto.ClientDto;
import kg.mega.saloon.models.entities.Client;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T12:31:27+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientDto d) {
        if ( d == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( d.getId() );
        client.setName( d.getName() );
        client.setSurname( d.getSurname() );
        client.setPhoneNumber( d.getPhoneNumber() );
        client.setEmail( d.getEmail() );
        client.setActive( d.isActive() );

        return client;
    }

    @Override
    public ClientDto toDto(Client e) {
        if ( e == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( e.getId() );
        clientDto.setName( e.getName() );
        clientDto.setSurname( e.getSurname() );
        clientDto.setPhoneNumber( e.getPhoneNumber() );
        clientDto.setEmail( e.getEmail() );
        clientDto.setActive( e.isActive() );

        return clientDto;
    }

    @Override
    public List<Client> toEntities(List<ClientDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Client> list1 = new ArrayList<Client>( list.size() );
        for ( ClientDto clientDto : list ) {
            list1.add( toEntity( clientDto ) );
        }

        return list1;
    }

    @Override
    public List<ClientDto> toDtos(List<Client> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientDto> list1 = new ArrayList<ClientDto>( list.size() );
        for ( Client client : list ) {
            list1.add( toDto( client ) );
        }

        return list1;
    }
}
