package org.najeungyoon.guestbook.controller;

import lombok.RequiredArgsConstructor;
import org.najeungyoon.guestbook.domain.GuestBook;
import org.najeungyoon.guestbook.service.GuestBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller("bookController")
@RequestMapping("/book")
public class BookController {
    private final GuestBookService guestBookService;

    private List<GuestBook> bookList;

    @GetMapping({"/list", "/"})
    public String getBookList(Model model) {
        bookList = guestBookService.listBooks();
        model.addAttribute("dataList", bookList);
        return "list";
    }

    @GetMapping("/add")
    public String writeArticle() {
        return "write";
    }

    @PostMapping("/add")
    public String addArticle(@RequestParam String post, @RequestParam String writer) {
        GuestBook book = new GuestBook();
        book.setPost(post);
        book.setWriter(writer);

        guestBookService.addPost(book);

        return "redirect:list";
    }
}