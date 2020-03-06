$(document).ready(function(){
	$('#signup_btn').click(function(){
		console.log("signup clicked!!!");
		
		var username = $('#signup_username').val();
		var password = $('#signup_password').val();
		
		if(!username || !password) {
			alert("This field is mandatory.");
			return;
		}
		
		var param = {
				username: username,
				password: password
		}
		
		$.ajax({
	        url: "/user",
	        method: "POST",
	        dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(param)
	    }).then(function(data) {
	    	console.log("s");
	    	alert("Sign up successful");
	    	window.location.href = '/login';
	    }, function(err) {
	    	console.log("f");
	    	alert("Username unavailable");
	    	window.location.reload();
	    });
		return false;
	});
});