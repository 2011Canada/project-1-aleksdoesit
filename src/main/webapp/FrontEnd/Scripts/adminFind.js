let userName = JSON.parse(window.localStorage.getItem('currentUser'));

document.getElementsByTagName("h1")[0].innerHTML = `ERS System - Admin ${userName.name}, Employee ID: ${userName.userId}.`;

async function getEmployeeHistory(e) {

  e.preventDefault()

  let userId = document.getElementById("inputUserId").value

  credentials = {

    userId

  }

  try {

    let res = await fetch("http://localhost:8080/ProjectOne/adminSearch", {

      method: "POST",
      body: JSON.stringify(credentials),
      headers: {

        "Content-Type": "application/json"

      }
    })

    let history = await res.json();

    document.querySelector(".reimbursementHistory").innerHTML = '<ol>' + history.map(function (history) {

      return `<li>Type: ${history.type} - For: ${history.description} - Employee: ${history.employeeId} - Amount: ${history.amount} - Unique reimbursement ID: ${history.reimbursementId} - Current status: ${history.status}.</li>`

    }).join('') + '</ol>';

  } catch (e) {

    console.log(e);
  
  }
}


function logoutSubmit(e) {

  e.preventDefault()
  window.location = "index.html";

}

function mainMenuSubmit(e) {

  e.preventDefault()
  window.location = "adminLogin.html";

}

document.getElementById("logout").addEventListener('click', logoutSubmit)
document.getElementById("mainMenu").addEventListener('click', mainMenuSubmit)

document.getElementsByTagName("form")[0].addEventListener('submit', getEmployeeHistory)