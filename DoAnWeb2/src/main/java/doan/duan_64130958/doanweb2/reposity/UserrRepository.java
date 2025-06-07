package doan.duan_64130958.doanweb2.reposity;

import doan.duan_64130958.doanweb2.models.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserrRepository extends JpaRepository<Userr, Long> {
}
