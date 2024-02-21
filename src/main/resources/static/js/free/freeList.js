// 페이징 스크립트
var page = /*[[${param.page}]]*/ null;
var pageLimit = /*[[${pu.pageLimit}]]*/ null; //화면에 page개수
if (page == null) {
    page = "1";
}
var idx = (parseInt(page) - 1) % pageLimit; //idx = index //한 화면의 페이지개수
var elements = document.querySelectorAll(".btn-page");
elements[idx].classList.add("target");