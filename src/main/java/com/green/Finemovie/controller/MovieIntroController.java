package com.green.Finemovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.Finemovie.domain.dto.MovieIntroDTO;
import com.green.Finemovie.domain.dto.PageRequestDTO;
import com.green.Finemovie.service.MovieIntroService;

@Controller
public class MovieIntroController {

	@Autowired
	MovieIntroService mService;

	@GetMapping("/movieintro")
	public String movieintro(Model model, PageRequestDTO mDTO) {
		model.addAttribute("page", mService.getList(mDTO));
		return "movieintro/movieintro";
	}

	@GetMapping("/movie-detail")
	public String moviedetail(@RequestParam("movieCode") String movieCode) {
		return "/movieintro/movie-detail";
	}

	@GetMapping("/movieintro-add")
	public String movieintroadd() {
		return "movieintro/movieintro-add";
	}

	@PostMapping("/movieintro-add")
	public String movieintroadd(MovieIntroDTO mDTO) {
		mService.save(mDTO);
		return "redirect:/movieintro";
	}

	@GetMapping("/movieintro-detail/{no}")
	public String movieintrodetail(@PathVariable("no") Long no, Model model) {
		mService.movieIntroDetail(no, model);
		mService.getNo(no);
		return "movieintro/movieintro-detail";
	}

	@PutMapping("/movieintro-detail/{no}")
	@ResponseBody
	public String editMovieIntro(@PathVariable(name = "no") long no,
			@RequestBody MovieIntroDTO mDTO) {
		mService.edit(no, mDTO);
		return "redirect:/movieintro";
	}
	
	@DeleteMapping("/movieintro-detail/{no}")
	@ResponseBody
	public String deleteMovieIntro(@PathVariable(name = "no") long no) {
		mService.deleteMovieIntro(no);
		return "redirect:/movieintro";
	}
}
