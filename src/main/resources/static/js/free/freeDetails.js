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


// 수정 모드 토글 함수
function toggleEditMode(button) {
    var form = document.forms["freeDetailsForm"];
    var inputs = form.getElementsByTagName("input");
    var textarea = form.getElementsByTagName("textarea")[0];

    if (button.innerHTML === "수정") {
        // 수정 모드 활성화
        // 현재 데이터를 보존
        originalData = {
            title: form.elements["title"].value,
            writer: form.elements["writer"].value,
            content: form.elements["content"].value
            // 필요한 경우 다른 필드도 추가
        };

        // 수정 버튼 및 취소 버튼 표시
        $(".update_btn_box, .cancel_btn_box").show();

        // 숨겨진 요소들 표시
        $(".comment_area, .btn_place").hide();

        // 읽기 전용 해제
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].removeAttribute("readonly");
        }
        textarea.removeAttribute("readonly");

        // 수정 모드 클래스 추가
        document.body.classList.add('edit-mode');
    } else {
        // 수정 모드 비활성화
        // 수정 중인 데이터를 초기 상태로 복구
        form.elements["title"].value = originalData.title;
        form.elements["writer"].value = originalData.writer;
        form.elements["content"].value = originalData.content;
        // 필요한 경우 다른 필드도 복구

        // 수정 버튼 및 취소 버튼 숨김
        $(".update_btn_box, .cancel_btn_box").hide();

        // 숨겨진 요소들 숨김 해제
        $(".comment_area, .btn_place").show();

        // 읽기 전용 설정
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].setAttribute("readonly", true);
        }
        textarea.setAttribute("readonly", true);

        // 수정 모드 클래스 제거
        document.body.classList.remove('edit-mode');
    }
}

document.querySelector('.update_box').addEventListener('click', function() {
    // 수정 내용을 서버로 전송
    fetch('/editFree', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(Object.fromEntries(new FormData(document.forms["freeDetailsForm"]))),
    })
    .then(response => response.json())
    .then(data => {
        // 성공 시 필요한 동작 수행
        console.log(data);
        
        // 여기에 디테일 페이지 갱신 로직 추가
        // 예시: 디테일 페이지의 특정 부분을 업데이트
        document.querySelector('.title_name').innerText = data.title;
        document.querySelector('.writer').innerText = data.writer;
        document.querySelector('.content_text').innerText = data.content;
        
        // 수정 모드 비활성화
        toggleEditMode(document.querySelector('.update_box'));
    })
    .catch(error => {
        // 오류 처리
        console.error('Error:', error);
    });
});


// 취소 버튼 클릭 이벤트
function cancelEdit() {
    // 수정 중인 데이터를 초기 상태로 복구
    var form = document.forms["freeDetailsForm"];
    form.elements["title"].value = originalData.title;
    form.elements["writer"].value = originalData.writer;
    form.elements["content"].value = originalData.content;
    // 필요한 경우 다른 필드도 복구

    // 수정 버튼 및 취소 버튼 숨김
    $(".update_btn_box, .cancel_btn_box").hide();

    // 숨겨진 요소들 숨김 해제
    $(".comment_area, .btn_place").show();

    // 읽기 전용 설정
    var inputs = form.getElementsByTagName("input");
    var textarea = form.getElementsByTagName("textarea")[0];
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].setAttribute("readonly", true);
    }
    textarea.setAttribute("readonly", true);
    
    // 수정 모드 비활성화
    toggleEditMode(this);

    // 현재 페이지로 이동 (새로고침)
    window.location.reload();
}


