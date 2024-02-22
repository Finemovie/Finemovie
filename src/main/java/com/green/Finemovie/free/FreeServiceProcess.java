package com.green.Finemovie.free;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreeServiceProcess implements FreeService {
	
	@Autowired
	private FreeEntityRepository freeEntityRepository;

	@Override
	public void saveFree(FreeDTO dto) {
	    FreeEntity existingFree = null;

	    // dto.getFreeNo()가 0L이 아닌 경우에만 해당 FreeEntity를 찾습니다.
	    if (dto.getFreeNo() != 0L) {
	        existingFree = freeEntityRepository.findById(dto.getFreeNo()).orElse(null);
	    }

	    // existingFree가 null이면 새로운 엔터티를 생성합니다.
	    if (existingFree == null) {
	        existingFree = new FreeEntity();
	    }

	    // existingFree 엔터티에 값을 업데이트하거나 설정합니다.
	    existingFree.setWriter(dto.getWriter());
	    existingFree.setPassword(dto.getPassword());
	    existingFree.setTitle(dto.getTitle());
	    existingFree.setContent(dto.getContent());

	    // Save other properties from DTO to Entity
	    existingFree.setViewCount(dto.getViewCount());
	    existingFree.setCreatedDate(dto.getCreatedDate());
	    existingFree.setUpdatedDate(dto.getUpdatedDate());
	    // "N"을 setCancel 메서드를 통해 설정합니다.
	    existingFree.setCancel("N".charAt(0));

	    // 엔터티를 레포지토리에 저장합니다.
	    freeEntityRepository.save(existingFree);
	}
	
	public FreeDTO findFreeById(Long freeId) {
        // FreeEntity를 찾아서 FreeDTO로 변환하여 반환하는 메서드
        return freeEntityRepository.findById(freeId)
                .map(FreeEntity::toFreeDTO)
                .orElse(null);
    }

	@Override
	public List<FreeEntity> getAllFrees(Model model) {
		return freeEntityRepository.findAll();
	}

	@Override
	public void listFree(int page, Model model, String keyword) {
		int limit = 10;
		// PageRequest를 사용하여 페이징 정보를 생성
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "freeNo"));
        
        // Spring Data JPA에서 페이징 처리를 위한 메서드를 사용
        Page<FreeEntity> freeEntityPage;
        if (keyword != null && !keyword.isEmpty()) {
        	freeEntityPage = freeEntityRepository.findByFreeContainingIgnoreCase(keyword, pageable);
        } else {
        	freeEntityPage = freeEntityRepository.findAll(pageable);
        }

        List<FreeDTO> result = freeEntityPage.getContent().stream()
                .map(FreeEntity::toFreeDTO)
                .collect(Collectors.toList());
        model.addAttribute("list", result);

        int rowCount = (int) freeEntityPage.getTotalElements();
        model.addAttribute("pu", FreePageRequestDTO.create(page, limit, rowCount, 5));
	}
	
	@Override
	public FreeEntity getFreeById(long freeNo) {
	    return freeEntityRepository.findById(freeNo).orElse(null);
	}

	@Override
	public void deleteFreeDetails(long freeNo) {
		
	}
	
}
