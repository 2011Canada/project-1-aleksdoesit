let userName = JSON.parse(window.localStorage.getItem('currentUser'));

document.getElementsByTagName("h1")[0].innerHTML = `ERS System - Admin ${userName.name}, Employee ID: ${userName.userId}.`;

async function loadUserHistory(e) {

  try  {

    let res = await fetch("http://localhost:8080/ProjectOne/userLogin", {

      method: "GET",
      headers: {

        "Content-Type": "application/json"

      }

    })

    let userHistory = await res.json();

    console.log(userHistory);

    document.querySelector(".reimbursementHistory").innerHTML = '<ol>' + userHistory.map(function (userHistory) {

      return `<li>For: ${userHistory.description} - Employee: ${userHistory.employeeId} - Amount: ${userHistory.amount} - Unique reimbursement ID: ${userHistory.reimbursementId} - Current status: ${userHistory.status}.</li>`

    }).join('') + '</ul>';

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

window.onload = function() {

  loadUserHistory();

}

document.getElementById("logout").addEventListener('click', logoutSubmit)
document.getElementById("mainMenu").addEventListener('click', mainMenuSubmit)