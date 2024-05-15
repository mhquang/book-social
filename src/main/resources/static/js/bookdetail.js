function showForm() {
    var form = document.getElementById("wantToReadForm");
    form.style.display = "block";
    document.getElementById("overlay").style.display = "block";
}

function closeForm() {
    var form = document.getElementById("wantToReadForm");
    form.style.display = "none";
    document.getElementById("overlay").style.display = "none";
}


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

// Get all img tags on the page
var images = document.getElementsByTagName('img');

// Loop through each img tag
for (var i = 0; i < images.length; i++) {
    // Get the value of the th:src attribute
    var srcValue = images[i].getAttribute('src');

    // Check if the th:src attribute starts with "/images/book"
    if (srcValue.startsWith('/book/images/book')) {
        console.log(srcValue)
        var newSrcValue = srcValue.replace('/book', '/images/book');
        // Redirect to the new URL
        images[i].setAttribute('th:src', 'http://localhost:8080' + newSrcValue);
    }
}
