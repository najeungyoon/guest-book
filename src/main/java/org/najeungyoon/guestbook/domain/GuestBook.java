package org.najeungyoon.guestbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class GuestBook {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="post_no")
    private Integer id;


    @Column(length=2000)
    private String post;

    @CreationTimestamp
    private LocalDateTime writeDate;

    private String writer;
}