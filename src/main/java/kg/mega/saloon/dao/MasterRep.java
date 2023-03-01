package kg.mega.saloon.dao;

import kg.mega.saloon.models.entities.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MasterRep extends JpaRepository<Master, Long> {


}
