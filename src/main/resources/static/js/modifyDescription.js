const changeDescription = () => {
    const descriptionElement = document.querySelector(".description");
    const maxLength = 300;

    if (descriptionElement.textContent.length > maxLength) {
        descriptionElement.textContent = descriptionElement.textContent.slice(0, maxLength) + " ...";
    }
}

document.addEventListener("DOMContentLoaded", changeDescription);