const heartIcons = document.querySelectorAll('.fa-heart-o');
    heartIcons.forEach(icon => {
        icon.addEventListener('click', function () {
            if (icon.classList.contains('fa-heart')) {
                icon.classList.remove('fa-heart');
                icon.classList.add('fa-heart-o');
            } else {
                icon.classList.remove('fa-heart-o');
                icon.classList.add('fa-heart');
            }
        });
    });