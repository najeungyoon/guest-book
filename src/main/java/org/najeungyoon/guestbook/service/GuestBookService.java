package org.najeungyoon.guestbook.service;


import lombok.RequiredArgsConstructor;
import org.najeungyoon.guestbook.domain.GuestBook;
import org.najeungyoon.guestbook.repository.GuestBookRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestBookService {
    private final GuestBookRepository guestBookRepository;

    public List<GuestBook> listBooks() throws DataAccessException {
        List<GuestBook> bookList = guestBookRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return bookList;
    }

    public void addPost(GuestBook book) throws DataAccessException {
        guestBookRepository.save(book);
    }
}
