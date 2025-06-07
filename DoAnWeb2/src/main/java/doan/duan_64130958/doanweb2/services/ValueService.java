package doan.duan_64130958.doanweb2.services;

import doan.duan_64130958.doanweb2.models.Event;
import doan.duan_64130958.doanweb2.models.Value;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValueService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertValueNative(Value value) {
        entityManager.createNativeQuery(
                        "INSERT INTO value (name,image,value,id_event) VALUES (?,?,?,?)")
                .setParameter(1, value.getName())
                .setParameter(2, value.getImage())
                .setParameter(3, value.getValue())
                .setParameter(4, value.getIdEvent())
                .executeUpdate();
    }
    @Transactional
    public void deleteValue(long id_event) {
        Query query = entityManager.createNativeQuery("DELETE FROM value WHERE id_event=?")
                .setParameter(1,id_event);
        entityManager.joinTransaction();
        query.executeUpdate();
    }
}
