package com.green.Finemovie.free;

import java.util.List;

import org.springframework.ui.Model;


public interface FreeService {

	void saveFree(FreeDTO dto);
	
	List<FreeEntity> getAllFrees(Model model);

	void listFree(int page, Model model, String keyword);

	FreeEntity getFreeById(long freeNo);

	void deleteFree(long freeNo);

	void updateFree(FreeDTO freeDTO);

	void increaseViewCount(long freeNo);

}
