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