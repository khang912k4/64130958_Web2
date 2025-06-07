package doan.duan_64130958.doanweb2.services;

import doan.duan_64130958.doanweb2.models.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertEventNative(Event event) {
        entityManager.createNativeQuery(
                        "INSERT INTO event (title,description,image,event_start,event_end,created_by) VALUES (?,?,?,?,?,?)")
                .setParameter(1, event.getTitle())
                .setParameter(2, event.getMota())
                .setParameter(3, event.getImage())
                .setParameter(4, event.getEventStart())
                .setParameter(5, event.getEventEnd())
                .setParameter(6,event.getCreatedBy())
                .executeUpdate();
    }
}
