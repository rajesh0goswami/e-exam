function validateForm(event) {
    event.preventDefault(); // this will prevent the submit event.
    if (document.loginform.username.value == "") {
        alert("User Name can not be left blank");
        document.loginform.username.focus();
        return false;
    } else {
        if (document.loginform.username.value.length > 25) {
            alert("User Name can should be within 25 charecters");
            document.loginform.username.focus();
            return false;
        } else {
            if (!document.loginform.username.value.match(/^[A-Za-z]+$/)) {
                alert("Name should only contain characters");
                document.loginform.username.focus();
                return false;
            }
        }

    }
    if (document.loginform.id.value == "") {
        alert("id can not be left blank");
        document.loginform.id.focus();
        return false;
    }
    if (document.loginform.email.value == "") {
        alert("email can not be left blank");
        document.loginform.id.focus();
        return false;
    }
    if (document.loginform.pass.value == "") {
        alert("password can not be left blank");
        document.loginform.pass.focus();
        return false;
    } else {
        if (document.loginform.pass.value.length < 8) {
            alert("Password Length should be > 8");
            document.loginform.pass.focus();
            return false;
        }
    }
    if (document.loginform.age.value == "") {
        alert("age can not be left blank");
        document.loginform.age.focus();
        return false;
    } else {
        if (parseInt(document.loginform.age.value) <= 18 || parseInt(document.loginform.age.value) >= 23) {
            alert("Age should be in the range of 18-23");
            document.loginform.age.focus();
            return false;

        }
    }
    if (!(document.getElementById("M").checked || document.getElementById("F").checked)) {
        alert("Select your Gender!!");
        return false;

    }
    if (document.loginform.addr.value == "") {
        alert("College address cannot be left blank!!");
        return false;
    }

    if (document.getElementById("branch").value == "") {
        alert("Select a Branch!");
        return false;
    }

    let skills = [];
    let tech = ["C", "JAVA", "PYTHON", "JSP"];
    let count = 0;
    tech.forEach(element => {
        if (document.getElementById(element).checked) {
            skills.push(element);
            count++;
        }
    });

    if (count < 2) {
        alert("Atleast two checkboxes should be checked")
        return false;
    }
    if (document.loginform.resume.value == "") {
        alert("Resume not uploded!!")
        return false;
    } else {
        document.loginform.submit(); // fire submit event
    }
}