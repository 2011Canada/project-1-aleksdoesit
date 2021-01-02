let userName = JSON.parse(window.localStorage.getItem('currentUser'));

document.getElementsByTagName("h1")[0].innerHTML = `Welcome back to Aleks' ERS System ${userName.name}! Your Employee ID is: ${userName.userId}`;

function logoutSubmit(e) {

  e.preventDefault()
  window.location = "index.html";

}

function newSubmit(e) {

  e.preventDefault()
  window.location = "userReimbursement.html";

}

function historySubmit(e) {

  e.preventDefault()
  window.location = "userHistory.html";

}

document.getElementById("newReimbursement").addEventListener('click', newSubmit)
document.getElementById("reimbursementHistory").addEventListener('click', historySubmit)
document.getElementById("logout").addEventListener('click', logoutSubmit)