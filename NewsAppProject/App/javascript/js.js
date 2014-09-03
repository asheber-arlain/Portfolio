var username; 
var password; 
var showname;

//saves username to local storage and redirects to the home page
function redirectAndSave() {
	username = document.getElementById('username').value;
	password = document.getElementById('password').value;
	
	if (username.trim() == "" || password == ""){
		alert("You must enter a username and/or password"); 
	}
	else{
		localStorage.setItem('user', username);
		window.location.href="sections.html";
	}
}

//grabs username from local storage to be displayed on pages after login
function displayUserName() {
	showname = document.getElementById('displayName');
	showname.innerHTML=localStorage.getItem('user'); 
}

//removes username from localstorage and redirects to the login page
function redirectAndRemove(){
	localStorage.removeItem('user');
	window.location.href="login.html";
}

// perform JavaScript after the document is scriptable.
$(function() {
    // setup ul.tabs to work as tabs for each div directly under div.panes
    $("ul.tabs").tabs("div.panes > div");
});