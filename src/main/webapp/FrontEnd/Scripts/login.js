async function loginSubmit(e) {

  e.preventDefault()

  let username = document.getElementById("inputUsername").value

  let password = document.getElementById("inputPassword").value

  const credentials = {

    username,
    password

  }

  try {

    let res = await fetch("http://localhost:8080/ProjectOne/index", {

      method: "POST",
      body: JSON.stringify(credentials),
      headers: {

        "Content-Type": "application/json"

      }
    })

    let user = await res.json();
    let userString_serialized = JSON.stringify(user);

    console.log(userString_serialized);

    localStorage.setItem("currentUser", userString_serialized);

    if(user.userRole == "User") {

      window.location = "userLogin.html";

    } else if (user.userRole == "Admin") {

      window.location = "adminLogin.html";

    } else {

      alert("Please enter a valid Username and/or Password.");

    }

  } catch (e) {

    console.log(e);

  }
}

document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit)
