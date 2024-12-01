package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.SearchCardForm;
import com.example.demo.service.CardSearchService;

@RequestMapping("cardSearch")
@Controller
public class CardSearchController {
	
	@Autowired
	private CardSearchService service;
	
	@GetMapping("/index")
	public String display() {
		return "cardSearch";
	}
	
	@GetMapping("/search")
	public String search(@ModelAttribute SearchCardForm form, Model model, RedirectAttributes redirectAttributes) {
		service.searchCard(form);
		// リダイレクトいらないかもしれない、不明
		return "redirect:index";
	}
}