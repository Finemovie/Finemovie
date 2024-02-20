package com.green.Finemovie.service;

import java.util.List;

import org.springframework.ui.Model;

import com.green.Finemovie.domain.dto.notice.NoticeListDTO;
import com.green.Finemovie.domain.dto.notice.NoticeSaveDTO;

public interface NoticeService {

	String saveNotice(NoticeSaveDTO dto);
	
	List<NoticeListDTO> noticeList();
	
	void noticeList(Model model);

}
