package com.github.hoodcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.hoodcat.domain.Guestbook;
import com.github.hoodcat.service.GuestbookService;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
    @Autowired
    GuestbookService guestbookService;

    @RequestMapping("")
    public String guestbook(Model model) {
        model.addAttribute("list", guestbookService.getList());
        return "guestbook/list";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute Guestbook guestbook) {
        guestbookService.insert(guestbook);
        return "redirect:/guestbook";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "no", required = true) int no) {
        return "guestbook/delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute Guestbook guestbook) {
        guestbookService.delete(guestbook);
        return "redirect:/guestbook";
    }

    @RequestMapping("/ajax")
    public String ajax() {
        return "guestbook/index-ajax";
    }
}
