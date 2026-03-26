package org.najeungyoon.guestbook.repository;

import org.najeungyoon.guestbook.domain.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository extends JpaRepository<GuestBook,Integer> {
}
