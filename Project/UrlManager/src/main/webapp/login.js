function send(){
	let username = $("#value").val();
	let pwd = $("#pwd").val();
	let url = "http://localhost:9090/UrlManager/login?username="+username+"&password="+pwd;
	$.get(url, function(response){
		console.log("response"+"in");
	})
}