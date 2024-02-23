package com.green.Finemovie.service;

import java.util.List;

import org.springframework.ui.Model;

import com.green.Finemovie.domain.dto.notice.NoticeListDTO;
import com.green.Finemovie.domain.dto.notice.NoticeSaveDTO;

public interface NoticeService {
	
    String saveNotice(NoticeSaveDTO dto);
    
    List<NoticeListDTO> getnoticeList();
    
    void noticeList(Model model);
    
    void noticeedit(Long no, Model model);
    
    void updateProcess(Long no, NoticeUpdateDTO dto);
}