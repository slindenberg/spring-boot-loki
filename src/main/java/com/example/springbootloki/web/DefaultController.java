package com.example.springbootloki.web;

import com.example.springbootloki.dom.SomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class DefaultController {

	private SomeService service;

	@Autowired
	public DefaultController(SomeService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ModelAndView index() {
		log.info("Index page requested.");
		final ModelAndView mav = new ModelAndView("index");
		mav.addObject("entities", service.list());
		return mav;
	}
}
