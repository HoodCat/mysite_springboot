package com.github.hoodcat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.hoodcat.domain.Guestbook;
import com.github.hoodcat.repository.GuestbookRepository;

@Service
public class GuestbookService {
    private GuestbookRepository guestbookRepository;

    public List<Guestbook> getList() {
        return guestbookRepository.findAll();
    }
    /*
    public List<Guestbook> getMessageList(Long no) {
        return guestBookDao.getList(no);
    }
    */
    public Guestbook insert(Guestbook guestbook) {
        return guestbookRepository.save(guestbook);
    }
    
    public void delete(Guestbook guestbook) {
        guestbookRepository.delete(guestbook);
    }
}
