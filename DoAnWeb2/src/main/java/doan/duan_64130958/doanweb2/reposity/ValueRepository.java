package doan.duan_64130958.doanweb2.reposity;

import doan.duan_64130958.doanweb2.models.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValueRepository extends JpaRepository<Value, Long> {
    List<Value> findByIdEvent(Long eventId);
}
