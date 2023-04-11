const file = document.getElementById("file");
const maxSize = 2 * 1024 * 1024;

file.addEventListener("change", function (e) {
    const file_res = document.getElementById("file-result");
    if (this.files[0].size > maxSize) {
        file_res.innerText = "File is Larger then 2MB";
        file_res.classList.remove("hide-it");
        file_res.classList.add("alert-primary-red");
    }
    else {
        file_res.classList.add("hide-it");
    }
});
const form = document.forms['uploadingForm'];
form.addEventListener('submit', e => {
    e.preventDefault();
    const file_res = document.getElementById("file-result");
    if (document.getElementById('file').files[0].size > maxSize) {
        file_res.innerText = "File is Larger then 2MB";
        file_res.classList.remove("hide-it");
        file_res.classList.add("alert-primary-red");
    } else {
        form.submit();
    }
})

setTimeout(() => document.getElementById("file-result").classList.add("hide-it"), 7000);