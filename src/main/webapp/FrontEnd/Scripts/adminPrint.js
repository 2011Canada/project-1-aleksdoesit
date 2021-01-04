let userName = JSON.parse(window.localStorage.getItem('currentUser'));

document.getElementsByTagName("h1")[0].innerHTML = `ERS System - Admin ${userName.name}, Employee ID: ${userName.userId}.`;

let reimbursementId;

async function loadUserHistory(e) {

  try  {

    let res = await fetch("http://localhost:8080/ProjectOne/adminReject", {

      method: "GET",
      headers: {

        "Content-Type": "application/json"

      }

    })

    let userHistory = await res.json();

    console.log(userHistory);

    document.querySelector(".reimbursementHistory").innerHTML = '<ol>' + userHistory.map(function (userHistory) {

      return `<li>Type: ${userHistory.type} - For: ${userHistory.description} - Employee: ${userHistory.userId} - Amount: ${userHistory.amount} - Unique reimbursement ID: ${userHistory.reimbursementId} - Current status: <span id='requestStatus'>${userHistory.status}</span>.</li>`

    }).join('') + '</ol>';

    let switchElement = document.getElementById('requestStatus');

    switch(userHistory.status.value) {

      case "Approved":
        switchElement.classList.add('approvedGreen');
        break;
      
      case "Rejected":
        switchElement.classList.add('rejectedRed');
        break;
      
      case "Pending":
        switchElement.classList.add('pendingYellow');
        break;
    }


  } catch (e) {

    console.log(e);
  
  }

}

async function approveEmployeeReimbursement(e) {

  console.log(reimbursementId)

  let credentials = {

    reimbursementId

  }

  try {

    let res = await fetch("http://localhost:8080/ProjectOne/adminApprove", {

      method: "POST",
      body: JSON.stringify(credentials),
      headers: {

        "Content-Type": "application/json"

      }
    })

    loadUserHistory();

  } catch(e) {

    console.log(e);

  }

}

async function rejectEmployeeReimbursement(e) {

  console.log(reimbursementId)

  let credentials = {

    reimbursementId

  }

  try {

    let res = await fetch("http://localhost:8080/ProjectOne/adminReject", {

      method: "POST",
      body: JSON.stringify(credentials),
      headers: {

        "Content-Type": "application/json"

      }
    })

    loadUserHistory();

  } catch(e) {

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

function approveOrReject(e) {

  e.preventDefault()

  let resId = document.getElementById("inputReimbursementId").value

  reimbursementId = resId;

  console.log(reimbursementId)

  if(approvalStatus = document.getElementById("inputStatus").value == 'Approved') {
  
    approveEmployeeReimbursement()
  
  } else if(approvalStatus = document.getElementById("inputStatus").value == 'Rejected') {

    rejectEmployeeReimbursement()
  }
}

document.getElementById("logout").addEventListener('click', logoutSubmit)
document.getElementById("mainMenu").addEventListener('click', mainMenuSubmit)
document.getElementsByTagName("form")[0].addEventListener('submit', approveOrReject)