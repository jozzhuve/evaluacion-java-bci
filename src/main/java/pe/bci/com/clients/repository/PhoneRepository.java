package pe.bci.com.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.bci.com.clients.entity.PhoneRecord;

import java.util.UUID;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneRecord, UUID> {
}
