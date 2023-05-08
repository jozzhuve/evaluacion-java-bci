package pe.bci.com.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.bci.com.clients.entity.ClientRecord;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientRecord, UUID> {

  Optional<ClientRecord> findClientRecordByEmail(String email);

}
