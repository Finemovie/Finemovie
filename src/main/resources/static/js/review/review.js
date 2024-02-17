document.addEventListener("DOMContentLoaded", function() {
    let selected = 0;
    let lastIndex = document.querySelectorAll('.imgs li').length - 1;
    let interval;

    const setTransition = (value) => {
        document.querySelector('.imgs').style.transition = value;
    };

    const setTranslate = ({ index, reset = false }) => {
        const movePercentage = index * -25;
        const transformValue = reset ? '' : `translateX(${movePercentage}%)`;
        document.querySelector('.imgs').style.transform = transformValue;
    };

    const activePagination = (index) => {
        const bullets = document.querySelectorAll('.bullets label');
        bullets.forEach((bullet, bulletIndex) => {
            bullet.style.backgroundColor = index === bulletIndex ? '#fff' : 'rgba(0, 0, 0, 0.55)';
        });
    };

    const autoplayIterator = () => {
    selected++;
    setTransition('all 0.3s linear');

    if (selected > lastIndex) {
        const firstSlideClone = slides[0].cloneNode(true);
        document.querySelector('.imgs').appendChild(firstSlideClone);

        //  Modification : Skip instant reset, let the clone become fully visible  
        setTimeout(() => {
            // After the transition, THEN remove old slides and reset
            document.querySelector('.imgs li').remove(); // Remove ORIGINAL first slide
            selected = 0; // Reset selected index
            setTranslate({ index: selected }); 
        }, 300); // Adjust timeout based on transition duration
    } else { 
        setTranslate({ index: selected });
    }

    activePagination(selected);
};
    const autoplay = ({ duration }) => {
        interval = setInterval(autoplayIterator, duration);
    };

    autoplay({ duration: 5000 });
});
