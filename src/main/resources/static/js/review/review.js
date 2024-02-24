function Slider(target, type) {
		  // 상태
		  let index = 1;
		  let isMoved = true;
		  const speed = 3000; // ms
		
		  // 방향
		  const transform = "transform " + speed / 1000 + "s";
		  let translate = (i) => "translateX(-" + 100 * i + "%)";
		  if (type === "V") {
		    translate = (i) => "translateY(-" + 100 * i + "%)";
		  }
		
		  // 슬라이더
		  const slider = document.querySelector(target);
		  const sliderRects = slider.getClientRects()[0];
		  slider.style["overflow"] = "hidden";
		
		  // 슬라이더 화면 컨테이너
		  const container = document.createElement("div");
		  container.style["display"] = "flex";
		  container.style["flex-direction"] = type === "V" ? "column" : "row";
		  container.style["width"] = sliderRects.width + "px";
		  container.style["height"] = sliderRects.height + "px";
		  container.style["transform"] = translate(index);
		
		  // 슬라이더 화면 목록
		  let boxes = [].slice.call(slider.children);
		  boxes = [].concat(boxes[boxes.length - 1], boxes, boxes[0]);
		
		  // 슬라이더 화면 스타일
		  const size = boxes.length;
		  for (let i = 0; i < size; i++) {
		    const box = boxes[i];
		    box.style["flex"] = "none";
		    box.style["flex-wrap"] = "wrap";
		    box.style["height"] = "100%";
		    box.style["width"] = "100%";
		    container.appendChild(box.cloneNode(true));
		  }
		
		  // 처음/마지막 화면 눈속임 이벤트
		  container.addEventListener("transitionstart", function () {
		    isMoved = false;
		    setTimeout(() => {
		      isMoved = true;
		    }, speed);
		  });
		  container.addEventListener("transitionend", function () {
		    // 처음으로 순간이동
		    if (index === size - 1) {
		      index = 1;
		      container.style["transition"] = "none";
		      container.style["transform"] = translate(index);
		    }
		    // 끝으로 순간이동
		    if (index === 0) {
		      index = size - 2;
		      container.style["transition"] = "none";
		      container.style["transform"] = translate(index);
		    }
		  });
		
		  // 슬라이더 붙이기
		  slider.innerHTML = "";
		  slider.appendChild(container);
		
		  return {
		    move: function (i) {
		      if (isMoved === true) {
		        index = i;
		        container.style["transition"] = transform;
		        container.style["transform"] = translate(index);
		      }
		    },
		    next: function () {
		      if (isMoved === true) {
		        index = (index + 1) % size;
		        container.style["transition"] = transform;
		        container.style["transform"] = translate(index);
		      }
		    },
		    prev: function () {
		      if (isMoved === true) {
		        index = index === 0 ? index + size : index;
		        index = (index - 1) % size;
		        container.style["transition"] = transform;
		        container.style["transform"] = translate(index);
		      }
		    }
		  };
		}
		
		const s1 = new Slider("#slider1", "H");
		//const s2 = new Slider("#slider2", "V");
		
		setInterval(() => {
		  s1.next();
		  //s2.next();
		}, 1000)

		
		document.addEventListener("DOMContentLoaded", function() {
    const slider = document.querySelector("#slider1");
    const boxes = slider.querySelectorAll('.box');
    const totalBoxes = boxes.length;
    let index = 0;
    const speed = 3000; // Duration for the slide transition

    // Clone the first and last images for an infinite loop effect
    const firstBoxClone = boxes[0].cloneNode(true);
    const lastBoxClone = boxes[totalBoxes - 1].cloneNode(true);
    slider.insertBefore(lastBoxClone, boxes[0]);
    slider.appendChild(firstBoxClone);

    // Function to move slides
    const moveSlides = () => {
        if (index > totalBoxes) {
            index = 1; // Reset back to the first image
            slider.style.transition = "none"; // Disable transition for instant jump
            slider.style.transform = `translateX(-${index * 100}%)`;
        } else if (index < 0) {
            index = totalBoxes - 1;
            slider.style.transition = "none";
            slider.style.transform = `translateX(-${index * 100}%)`;
        } else {
            slider.style.transition = "transform 0.5s ease-in-out";
            slider.style.transform = `translateX(-${index * 100}%)`;
        }
    };

    // Auto-play functionality
    setInterval(() => {
        index++;
        moveSlides();
    }, speed);
});