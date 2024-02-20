package com.green.Finemovie.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.Finemovie.domain.dto.notice.NoticeEditDTO;
import com.green.Finemovie.domain.dto.notice.NoticeListDTO;
import com.green.Finemovie.domain.dto.notice.NoticeSaveDTO;
import com.green.Finemovie.domain.entity.notice.NoticeEntity;
import com.green.Finemovie.domain.entity.notice.NoticeRepository;
import com.green.Finemovie.service.NoticeService;
import com.green.Finemovie.service.NoticeUpdateDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeProcess implements NoticeService {
	
	private final NoticeRepository noticeRepository;

	public String saveNotice(NoticeSaveDTO dto) {
		noticeRepository.save(dto.toEntity(noticeRepository));
		return "redirect:/notice";
	}

	@Override
	public List<NoticeListDTO> getnoticeList() {
		return noticeRepository.findAll().stream().map(NoticeEntity::toNoticeListDTO).collect(Collectors.toList());
	}

	@Override
	public void noticeList(Model model) {
		model.addAttribute("list",
				noticeRepository.findAll().stream().map(NoticeEntity::toNoticeListDTO).collect(Collectors.toList()));
	}

	@Override
	public void noticeedit(Long no, Model model) {
		
		NoticeEntity entity = noticeRepository.findById(no).orElse(null);
		
		if (entity != null) {
			NoticeEditDTO dto = entity.toNoticeEditDTO();
			model.addAttribute("noticeEditDTO", dto);
		}
	}

	@Override
	public void updateProcess(Long no, NoticeUpdateDTO dto) {
		// TODO Auto-generated method stub
		
	}

}