// Variables
let authHeaderValue = null;
let username = null;
let password = null;

// Login functions
function login() {
    // Grab variables
    username = document.getElementById("text_username").value;
    password = document.getElementById("text_password").value;
    authHeaderValue = "Basic " + btoa(username + ":" + password); // btoa turns it into base64 encoding

    // XMLHttpRequest to send base64 encoded user login information and then stores it in
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open('GET', '');
    xmlHttp.setRequestHeader('Authorization', authHeaderValue);
    xmlHttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            console.log("Login Successful!");
            document.getElementById("response_message").innerHTML = "Welcome, agent " + username;
            isUserLoggedIn(false);
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 401) { // When a 401 is returned, do this instead
            console.log("Login Unsuccessful!")
            document.getElementById("response_message").innerHTML = "Invalid username/password!";
            isUserLoggedIn(true);
        }
    }
    xmlHttp.send();
}

// Might remove depending on html, because this can mess up with aesthetics later
function isUserLoggedIn(isTrue) {
    // Flips visibility of certain elements depending on login state of user
    if (isTrue === true) {
        document.getElementById('login_form').style.visibility = 'visible';
        document.getElementById('container').style.visibility = 'hidden';
    } else {
        document.getElementById('login_form').style.visibility = 'hidden';
        document.getElementById('container').style.visibility = 'visible';
    }

    // Clear text fields for login
    text_username.value = "";
    text_password.value = "";
}

// API methods
/*
    - apiMethodName is the name of the method you're calling from the rest controller
    - requestMethod decides if it's a GET, POST, PUT, DELETE, etc.
    - apiURL is the mapping for said method from the rest controller
*/
function apiMethodNoAuth(apiMethodName, requestMethod, apiURL) {
    console.log(requestMethod + " " + apiMethodName);
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open(requestMethod, apiURL, true);
    xmlHttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            document.getElementById("response_message").innerHTML = this.responseText;
        }
    }
    xmlHttp.send();
}

/*
    - apiMethodName is the name of the method you're calling from the rest controller
    - requestMethod decides if it's a GET, POST, PUT, DELETE, etc.
    - apiURL is the mapping for said method from the rest controller
*/
function apiMethodAuth(apiMethodName, requestMethod, apiURL) {
    console.log(requestMethod + " " + apiMethodName)
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open(requestMethod, apiURL, true);
    xmlHttp.setRequestHeader('Authorization', authHeaderValue);
    xmlHttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            document.getElementById("response_message").innerHTML = this.responseText;
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 401) {
            document.getElementById("response_message").innerHTML = "You are not logged in and or are unauthorized for: " + apiMethodName;
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 403) {
            document.getElementById("response_message").innerHTML = "You do not have a role for: " + apiMethodName;
        }
    }
    xmlHttp.send();
}

// Page functions
function send_to_login() {
    document.getElementById("container").innerHTML =
    `
        
    `
}

