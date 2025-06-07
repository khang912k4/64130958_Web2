package doan.duan_64130958.doanweb2.services;

import doan.duan_64130958.doanweb2.models.Userr;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserrService{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertUserNative(Userr userr) {
        entityManager.createNativeQuery(
                        "INSERT INTO userr (email,fullname,password,sdt,join_event,receive) VALUES (?,?,?,?,?,?)")
                .setParameter(1, userr.getEmail())
                .setParameter(2, userr.getFullname())
                .setParameter(3, userr.getPassword())
                .setParameter(4, userr.getSdt())
                .setParameter(5,userr.getJoinEvent())
                .setParameter(6,userr.getReceive())
                .executeUpdate();
    }
}
