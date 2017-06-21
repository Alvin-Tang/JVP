window.onload = function() {
	$("#login_btn").on("click",doLogin);
	showSystemDateTime();
},


doLogin = function() {
	$("#login_form").submit();
},

showSystemDateTime = function() {
	$("#dt").html(new Date());
	setTimeout(showSystemDateTime, 1000);
}
