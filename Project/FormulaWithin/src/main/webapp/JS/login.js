$("#id").click(function() {
	let username = $("#name").value;
	let pwd = $("pwd").value;
	$.post("http://localhost9090/formulaWithin/login?username="+username+"&password="+pwd,function() {
		console.log("Success")
	})
})