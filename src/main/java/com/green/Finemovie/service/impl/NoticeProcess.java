package com.green.Finemovie.service.impl;

import java.util.List;
import java.util.Optional;
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
		// TODO: Implement the update process using noticeRepository
		NoticeEntity entity = noticeRepository.findById(no).orElse(null);
		if (entity != null) {
			entity.updateNotice(dto); // 예시: FranEntity에서 데이터 업데이트하는 메서드 필요
			noticeRepository.save(entity);
		}
	}

	@Override
	public void deleteNotice(long no) {
	    Optional<NoticeEntity> optionalEntity = noticeRepository.findById(no);
	    
	    if (optionalEntity.isPresent()) {
	        noticeRepository.delete(optionalEntity.get());
	    } else {
	        // 삭제하려는 엔터티가 존재하지 않는 경우에 대한 처리
	        // 예를 들어 예외를 던지거나, 로깅을 하는 등의 작업을 수행할 수 있습니다.
	        // 여기서는 단순히 로그만 찍어보겠습니다.
	        System.out.println("삭제하려는 공지사항이 존재하지 않습니다. ID: " + no);
	    }
	}

}