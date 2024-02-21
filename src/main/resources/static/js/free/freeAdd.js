//유효성 검사
function validateAndSubmit() {
    var errorMessages = [];

    // 비밀번호가 8자리인지 확인
    var password = document.forms["freeAddForm"]["password"].value;
    if (password.trim() === '' || password.length < 8) {
        errorMessages.push("8자리 비밀번호를 입력해주세요.");
    }

    // 작성자, 제목, 내용이 모두 1글자 이상인지 확인
    var writer = document.forms["freeAddForm"]["writer"].value;
    var title = document.forms["freeAddForm"]["title"].value;
    var content = document.forms["freeAddForm"]["content"].value;

    if (writer.trim() === '') {
        errorMessages.push("작성자를 입력해주세요.");
    }

    if (title.trim() === '') {
        errorMessages.push("제목을 입력해주세요.");
    }

    if (content.trim() === '') {
        errorMessages.push("내용을 입력해주세요.");
    }

    // 2개 이상의 유효성 검사를 통과하지 못한 경우
    if (errorMessages.length >= 2) {
        alert("입력 정보를 다시 확인하세요.");
        return false;
    }

    // 에러 메세지 출력
    if (errorMessages.length > 0) {
        alert(errorMessages.join('\n'));
        return false;
    }

    return true;
}

