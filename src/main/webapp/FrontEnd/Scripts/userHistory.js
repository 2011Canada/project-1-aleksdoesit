let userName = JSON.parse(window.localStorage.getItem('currentUser'));

document.getElementsByTagName("h1")[0].innerHTML = `Welcome back to Aleks' ERS System ${userName.name}! Your Employee ID is: ${userName.userId}`;

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

      return `<li>For: ${userHistory.description} in amount: $${userHistory.amount}. Your unique reimbursement ID is: ${userHistory.reimbursementId} and current status on this request is ${userHistory.status}.</li>`

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
  window.location = "userLogin.html";

}

window.onload = function() {

  loadUserHistory();

}

document.getElementById("logout").addEventListener('click', logoutSubmit)
document.getElementById("mainMenu").addEventListener('click', mainMenuSubmit)