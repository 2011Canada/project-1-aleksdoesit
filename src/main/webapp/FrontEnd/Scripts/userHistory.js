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

      return `<li><p class='userReimbursementItem'>Type: ${userHistory.type}</p><p class='userReimbursementItem'>For: ${userHistory.description}.</p><p class='userReimbursementItem'>In amount: $${userHistory.amount}.</p><p class='userReimbursementItem'> Your unique reimbursement ID is: ${userHistory.reimbursementId}</p> <p class='userReimbursementItem'>Current status on this request is ${userHistory.status}.</p></li>`

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