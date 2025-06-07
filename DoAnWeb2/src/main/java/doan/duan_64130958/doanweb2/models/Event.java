package doan.duan_64130958.doanweb2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Long idEvent;

    @Column(name ="title")
    private String title;

    @Column(name = "event_end")
    private LocalDateTime eventEnd;

    @Column(name = "event_start")
    private LocalDateTime eventStart;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "description")
    private String mota;

    @Column(name = "image")
    private byte[] image;
}