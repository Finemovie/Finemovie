

// 모달창에 값 불러오기
function editmodal() {
	var title = $('.title').text();
	var content = $('.contentarea div').text();
	var type = $('.spoiler').text().trim() === "스포일러有" ? "False" : "true";
	var writer = $('.writer').text();

	$('#modalTitleInput').val(title);
	$('#modalContentInput').val(content);
	$('#writerInput').val(writer);
	$('input[name="modalTypeInput"][value="' + type + '"]').prop('checked', true);

	$('.editmodal').css('display', 'block');
}

function closeModal() {
	$('#editModal').css('display', 'none');
}


function saveChanges() {
	var modifiedTitle = $('#modalTitleInput').val();
	var no = $('.no').val();
	var modifiedContent = $('#modalContentInput').val();
	var modifiedType = $('input[name="modalTypeInput"]:checked').val();
	var modifiedWriter = $('#writerInput').val();

	$.ajax({
		type: "PUT",
		url: "/movieintro-detail/" + no,
		contentType: "application/json",
		data: JSON.stringify({
			title: modifiedTitle,
			content: modifiedContent,
			type: modifiedType,
			writer: modifiedWriter
		}),
		success: function() {
			closeModal();
			location.reload();

			alert("수정이 완료되었습니다.");
		}
	});
}

function deleteModal(){
	var no = $('.no').val();
	$.ajax({
		type: "DELETE",
		url: "/movieintro-detail/" + no,
		success: function(){
			location.reload;
			alert("삭제가 완료되었습니다.");
		}
	});
}