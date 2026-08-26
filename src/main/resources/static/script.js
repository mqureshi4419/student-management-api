const form = document.getElementById("studentForm");
const studentResult = document.getElementById("studentResult");
const successMessage = document.getElementById("successMessage");
const loadStudentsButton = document.getElementById("loadStudentsButton");
const studentsList = document.getElementById("studentsList");


form.addEventListener("submit", function(event) {
    event.preventDefault();
    console.log("Form submitted");

    const name = document.getElementById("name").value;

    const age = document.getElementById("age").value;

    const major = document.getElementById("major").value;

    if (!name || !age || !major) {
        successMessage.textContent = "Please fill in all fields.";
        return;
    }

    if (age <= 1 || age >= 200) {
        successMessage.textContent = "Please enter a valid age.";
        return;
    }

    const url = "http://localhost:8080/api/createstudent?name=" + name + "&age=" + age + "&major=" + major;
    fetch(url, {
        method:"POST"
    }).then(function(response) {
        if (!response.ok) {
        return response.json().then(function(errorData) {
            console.log(errorData.message);
            throw new Error(errorData.message);
        });
        }
        return response.json();
    }).then(function(student) {
        successMessage.textContent = "Student created successfully!"
        studentResult.textContent = JSON.stringify(student, null, 2);
        form.reset();
    }).catch(function(error) {
        successMessage.textContent = error.message;
        console.log(error);
    })

});

loadStudentsButton.addEventListener("click", function() {
    const url = "http://localhost:8080/api/getstudent";
    fetch(url).then(function(response){
    return response.json();

    }).then(function(students) {
    console.log(students);
    successMessage.textContent = "Students loaded successfully!"
    studentsList.innerHTML = "";
    students.forEach(function(student){

        studentsList.innerHTML += "<p>" + student.name + " - Age: " + student.age + " - Major: " + student.major + "</p>";

    })
    })
});
