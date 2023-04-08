document.forms['myForm'].addEventListener('submit', e => {
    const form_choice = {
        choice_1: document.getElementById("choice_1"),
        choice_2: document.getElementById("choice_2"),
        choice_3: document.getElementById("choice_3"),
        choice_4: document.getElementById("choice_4"),
        choice_5: document.getElementById("choice_5")
    }

    e.preventDefault();
    const prev = Object.keys(form_choice).reduce((prev, val) => {
        prev[form_choice[val].value] = (prev[form_choice[val].value] || 0) + 1;
        return prev;
    }, {});
    const submitOrNot = Object.values(prev).reduce((acc, val) => {
        if (val > 1) {
            return false;
        }
        return acc;
    }, true)
    if (submitOrNot) {
        document.forms['myForm'].submit();
    }
    else {
        alert("Please Choose all 5 different Subjects");
    }
})