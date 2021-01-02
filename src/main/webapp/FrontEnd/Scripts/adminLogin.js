let userName = JSON.parse(window.localStorage.getItem('currentUser'));

document.getElementsByTagName("h1")[0].innerHTML = `ERS System - Admin ${userName.name}, Employee ID: ${userName.userId}.`;



function approveSubmit(e) {

  e.preventDefault()
  window.location = "adminApprove.html";

}

function findSubmit(e) {

  e.preventDefault()
  window.location = "adminFind.html";

}

function printSubmit(e) {

  e.preventDefault()
  window.location = "adminPrint.html";

}

function logoutSubmit(e) {

  e.preventDefault()
  window.location = "index.html";

}


document.getElementById("approveReimbursement").addEventListener('click', approveSubmit)
document.getElementById("findUser").addEventListener('click', findSubmit)
document.getElementById("printAll").addEventListener('click', printSubmit)
document.getElementById("logout").addEventListener('click', logoutSubmit)