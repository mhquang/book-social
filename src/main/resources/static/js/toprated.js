const changeDescription = () => {
    const descriptionElement = document.querySelector(".description");
    const maxLength = 300;

    if (descriptionElement.textContent.length > maxLength) {
        descriptionElement.textContent = descriptionElement.textContent.slice(0, maxLength) + " ...";
    }
}

document.addEventListener("DOMContentLoaded", changeDescription);
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

