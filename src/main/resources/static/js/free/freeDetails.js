//textarea 높낮이 조절 로직
function autoResize() {
            const textarea = document.getElementById('content');
            textarea.style.height = 'auto';
            textarea.style.height = (textarea.scrollHeight) + 'px';
        }