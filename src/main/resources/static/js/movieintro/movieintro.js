// 클라이언트 측 JavaScript 코드

$.ajax({
	method: "GET",
	url: "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
	data: {
		key: "1bfffe6c00227acd9ae65c8d7a0c3225",
		targetDt: "20240215",
		itemPerPage: "5"
	}
}).done(function(msg) {
	let resultContainer = $("#daily");
	for (let i = 0; i < 5; i++) {
		let short_url = msg.boxOfficeResult.dailyBoxOfficeList[i];
		let start = i + 1;
		let resultItem = "<b>" + 
//		start + 
		"</b>";
		if (short_url) {
//			resultItem += "<b> 영화 코드 : " + short_url.movieCd + "</b> <br>";
			resultItem += '<div><a href="/movie/detail?movieCode=' + short_url.movieCd + '" class="movie-link">' + short_url.movieNm + '</a><br>';
			resultItem += "<p> 영화 출시일 : " + short_url.openDt + "</p></div>";

			var tmdbApiKey = "b5148ad4d6f8b078977a761c7fb41764";
			// 수정된 부분: 서버 측 엔드포인트 호출
			$.ajax({
				method: "GET",
				url: "/api/getMoviePoster",
				data: {
					tmdbApiKey: tmdbApiKey,
					movieTitle: short_url.movieNm
				}
			}).done(function(response) {
				if (response && response.length > 0) {
					resultItem += '<img src="https://image.tmdb.org/t/p/w500/' + response[0].poster_path + '" alt="Movie Poster">';
				}
				resultContainer.append(resultItem);
			}).fail(function() {
				resultContainer.append(resultItem);
			});
		} else {
			resultItem += '<p>Movie data not available</p>';
			resultContainer.append(resultItem);
		}
	}
});

$(".movie-link").click(function(event) {
	// 기본 이벤트 동작 방지
	event.preventDefault();
	// 클릭한 링크의 href 속성값으로 페이지 이동
	window.location.href = $(this).attr('href');
});
