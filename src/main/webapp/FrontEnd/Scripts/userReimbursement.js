let userName = JSON.parse(window.localStorage.getItem('currentUser'));

document.getElementsByTagName("h1")[0].innerHTML = `Welcome back to Aleks' ERS System ${userName.name}! Your Employee ID is: ${userName.userId}`;

async function submitRequest(e) {
  
  e.preventDefault()

  let type = document.getElementById("inputPurpose").value

  let amount = document.getElementById("inputAmount").value

  let description = document.getElementById("inputDescription").value

  let reimbursement = {

    description,
    amount,
    type


  }

  console.log(reimbursement)

  try {

  let res = await fetch("http://localhost:8080/ProjectOne/userLogin", {

      method: "POST",
      body: JSON.stringify(reimbursement),
      headers: {

        "Content-Type": "application/json"

      }

    })

    alert(`Request for ${reimbursement.description} in amount ${reimbursement.amount} sent successfully, status is 'PENDING'.`)


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

document.getElementsByTagName("form")[0].addEventListener('submit', submitRequest)
document.getElementById("logout").addEventListener('click', logoutSubmit)
document.getElementById("mainMenu").addEventListener('click', mainMenuSubmit)