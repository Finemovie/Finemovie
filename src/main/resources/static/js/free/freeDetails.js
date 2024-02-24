// textarea 높낮이 조절 로직
function autoResize() {
    const textarea = document.getElementById('content');
    
    // 최대 높이 설정
    const maxHeight = 640; // 최대 높이를 원하는 값으로 설정
    
    // 현재 높이 계산
    textarea.style.height = 'auto';
    const newHeight = textarea.scrollHeight;
    
    // 최대 높이를 넘지 않도록 설정
    textarea.style.height = (newHeight > maxHeight ? maxHeight : newHeight) + 'px';
}

// 페이지 로드 시 textarea 높이 초기화
document.addEventListener('DOMContentLoaded', function() {
    autoResize();
});

// textarea가 수정될 때마다 높이 조절
document.getElementById('content').addEventListener('input', autoResize);


// 취소 버튼 클릭 이벤트
function cancelEdit() {
    // 현재 페이지로 새로고침
    window.location.reload();
}

// 수정 모드 토글 함수
function toggleEditMode() {
    var form = document.getElementById("editForm");
    var titleInput = form.querySelector('input[name="title"]');
    var contentTextarea = form.querySelector('textarea[name="content"]');

    if (document.querySelector('.edit_button').innerText === "수정") {
        // 수정 모드 활성화
        // 현재 데이터를 보존
        originalData = {
            title: titleInput.value,
            content: contentTextarea.value
        };

        // 수정 버튼 및 취소 버튼 표시
        document.querySelector('.update_btn_box').style.display = "block";
        document.querySelector('.cancel_btn_box').style.display = "block";

        // 숨겨진 요소들 표시
        document.querySelector('.comment_area').style.display = "none";
        document.querySelector('.btn_place').style.display = "none";

        // 제목과 내용만 읽기 전용 해제
        titleInput.removeAttribute("readonly");
        contentTextarea.removeAttribute("readonly");

        // 수정 모드 클래스 추가
        document.body.classList.add('edit-mode');
    } else {
        // 수정 모드 비활성화
        // 수정 중인 데이터를 초기 상태로 복구
        titleInput.value = originalData.title;
        contentTextarea.value = originalData.content;

        // 수정 버튼 및 취소 버튼 숨김
        document.querySelector('.update_btn_box').style.display = "none";
        document.querySelector('.cancel_btn_box').style.display = "none";

        // 숨겨진 요소들 숨김 해제
        document.querySelector('.comment_area').style.display = "block";
        document.querySelector('.btn_place').style.display = "flex";

        // 제목과 내용만 읽기 전용 설정
        titleInput.setAttribute("readonly", true);
        contentTextarea.setAttribute("readonly", true);

        // 수정 모드 클래스 제거
        document.body.classList.remove('edit-mode');
    }
}

// 수정 저장 버튼 클릭 이벤트
document.querySelector('.update_box').addEventListener('click', function () {
    // 수정 내용을 서버로 전송
    saveChanges(form);
});

// 저장
function saveChanges(form) {
    console.log('saveChanges 함수 호출');
    
    // 수정할 게시글의 정보 추출
    var freeNo = form.querySelector('.freeNo').value;
    var title = form.querySelector('.title').value;
    var content = form.querySelector('.content').value;
    
    // 유효성 검사
    if (!validateInput(title, content)) {
        alert('수정 실패. 입력 정보를 다시 확인하세요.');
        return false;
    }

    // 서버로 전송할 데이터 준비
    var data = {
        freeNo: freeNo,
        title: title,
        content: content
    };

    // 서버로 데이터 전송
fetch('/freeSaveChanges', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
})
.then(response => response.json())
.then(data => {
    console.log('저장 완료:', data);
    if (data.redirect) {
        // 수정이 완료되면 리다이렉션
        window.location.href = data.redirect;
    } else {
        toggleEditMode();
        alert('게시글이 수정되었습니다.');
    }
})
.catch((error) => {
    console.error('저장 실패:', error);
    alert('수정 실패. 다시 시도하세요.');
});
}

// 입력값 유효성 검사
function validateInput(title, content) {
    if (!title || !content) {
        return false;
    }
    return true;
}

//게시글 삭제 로직
function confirmAndDelete() {
        if (confirm('게시글을 삭제하시겠습니까?')) {
            // 게시글 삭제를 위한 폼 선택
            var deleteForm = document.getElementById('deleteForm');
            
            // 폼을 서버로 제출
            deleteForm.submit();
        }
    }
	