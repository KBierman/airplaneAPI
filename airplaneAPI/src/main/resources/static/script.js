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

    // XMLHttpRequest to send base64 encoded user login information and then stores it in authHeaderValue
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open('GET', '');
    xmlHttp.setRequestHeader('Authorization', authHeaderValue);
    xmlHttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            document.getElementById("response_message").innerHTML = "Welcome, " + username;
            isUserLoggedIn(false);
            console.log("Login Successful!");
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 401) {
            document.getElementById("response_message").innerHTML = "Invalid username/password!";
            isUserLoggedIn(true);
            console.log("Login Unsuccessful!")
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
// Create
function createFlight() {
    console.log("Called createFlight()...");

    let flight_number = document.getElementById("").value;
    let origin = document.getElementById("").value;
    let destination = document.getElementById("").value;
    let arrival_time = document.getElementById("").value;
    let departure_time = document.getElementById("").value;
    let aircraft_type = document.getElementById("").value;
    // seats_empty and seats_full are both used to see how full the flight is
    let seats_empty = document.getElementById("").value;
    let seats_full = document.getElementById("").value;
    let fare = document.getElementById("").value; // fare is a double value
    let flight_date = document.getElementById("").value;
    // Statuses: delayed, on-time, cancelled, departed, in air, expected, recovery, landed, arrived
    let flight_status = document.getElementById("").value;
    let status_date = document.getElementById("").value; // When the status was last updated

    let flight =
        {
            "fltNo": flight_number,
            "origin": origin,
            "destination": destination,
            "arrTime": arrival_time,
            "depTime": departure_time,
            "aircraftType": aircraft_type,
            "seatsEmpty": seats_empty,
            "seatsFull": seats_full,
            "fare": fare,
            "flightDate": flight_date,
            "flightStatus": flight_status,
            "statusDT": status_date
        }

    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "/flight", true);
    xmlHttp.setRequestHeader('Authorization', authHeaderValue);
    xmlHttp.setRequestHeader("Content-Type", 'application/json');
    xmlHttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            document.getElementById("response_message").innerHTML = this.responseText;
            console.log("createFlight() was successful!");
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 401) { // These statements may not be required
            document.getElementById("response_message").innerHTML = "You are not logged in and or are unauthorized for creating flights!";
            console.log("createFlight() failed!");
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 403) {
            document.getElementById("response_message").innerHTML = "You do not have a role for creating flights!";
            console.log("createFlight() failed!");
        }
    }
    xmlHttp.send(JSON.stringify(flight));
}

// Read
function readAllCorrespondingFlights() {
    console.log("Called readAllCorrespondingFlights()...");

    let origin = document.getElementById("").value;
    let destination = document.getElementById("").value;
    let departure_date = document.getElementById("").value;

    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "/flight/" + origin + "/" + destination + "/" + departure_date, true);
    xmlHttp.setRequestHeader('Authorization', authHeaderValue);
    xmlHttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            document.getElementById("response_message").innerHTML = this.responseText;
            console.log("readAllCorrespondingFlights() was successful!");
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 401) {
            // might not be necessary
            document.getElementById("response_message").innerHTML = "Sorry, something went wrong! Try again later!";
            console.log("readAllCorrespondingFlights() failed!");
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 403) {
            // might not be necessary
            document.getElementById("response_message").innerHTML = "Sorry, something went wrong! Try again later!";
            console.log("readAllCorrespondingFlights() failed!");
        }
    }
    xmlHttp.send();
}

// Update

// Delete

// Page functions
// Will send user to login page
function send_to_login() {
    document.getElementById("container").innerHTML =
        `
        
    `
}

// Will send user to their 'purchased' tickets
function send_to_user_tickets() {
    document.getElementById("container").innerHTML =
        `
        
    `
}

// Will send user to the flight reservation page
function send_to_flight_res() {
    document.getElementById("container").innerHTML =
        `
        
    `
}

// Once user has reserved flight, will take them here to show their ticket details
function send_to_ticket_confirm() {
    document.getElementById("container").innerHTML =
        `
        
    `
}