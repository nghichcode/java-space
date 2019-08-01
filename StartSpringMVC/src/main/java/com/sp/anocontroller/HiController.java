package com.sp.anocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HiController {
	@RequestMapping("/")
	public String index() {return "anosay";}

}
