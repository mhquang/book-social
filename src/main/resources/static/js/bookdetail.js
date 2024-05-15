let likeClicked = false;
    let dislikeClicked = false;

    function handleClickLike(button) {
        if (!likeClicked && !dislikeClicked) {
            button.style.color = "#BFA054";
            likeClicked = true;
        } else if (likeClicked && !dislikeClicked) {
            button.style.color = "#2F2F2F";
            likeClicked = false;
        } else if (!likeClicked && dislikeClicked) {
            document.getElementById('dislikeButton').style.color = "#2F2F2F";
            button.style.color = "#BFA054";
            likeClicked = true;
            dislikeClicked = false;
        }
    }

    function handleClickDislike(button) {
        if (!dislikeClicked && !likeClicked) {
            button.style.color = "#BFA054";
            dislikeClicked = true;
        } else if (dislikeClicked && !likeClicked) {
            button.style.color = "#2F2F2F";
            dislikeClicked = false;
        } else if (!dislikeClicked && likeClicked) {
            // If like is already clicked, reset its color
            document.getElementById('likeButton').style.color = "#2F2F2F";
            button.style.color = "#BFA054";
            dislikeClicked = true;
            likeClicked = false;
        }
    }