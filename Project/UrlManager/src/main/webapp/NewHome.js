let modal = $("#modal");
modal.addClass("none");

function getPatterns() {
	let url = "http://localhost:9090/UrlManager/get";
	$.get(url, function(response) {
		let json = JSON.parse(response);
		console.log(json);
		showPatterns(json);
	})
}

let count = 0;
let id1 = 0;
function showPatterns(json) {
	console.log("show")
	let i = 0;
	json.forEach(element => {
		let box_div = $("<div class='box' id=n" + i + "></div");
		let box_cont = $("<h3 class='box_url'></h3>").text(element);
		let status = $("<p class='box_status' id=y" + i + "></p>").text("none");
		let icon = $("<p class='icon'><i class='arrow'><i><p>");
		//let arrow = $("<i class='arrow'><i>");
		//icon.append(arrow);
		box_div.append(box_cont);
		box_div.append(icon);
		box_div.append(status);
		//Opening and closing
		box_div.on("click", function() {
			let id = $(this).attr("id");
			if (id1 != id) { count = 0 }
			if (count % 2 == 0) {
				$("#" + id).css("height", "140px");
			}
			else {
				$("#" + id).css("height", "40px");
			}
			id1 = id;
			count++;
		})
		$("#bigBox").append(box_div);
		i += 1;
	})
}

$(".add").click(function() {
	modal.removeClass("none");
	let div = $("<div id ='upload-box'>");
	let input = $("<input placeholder='url' id='url' autocomplete='off' />");
	let button = $("<button id='upload-button' class='call'>submit</button>");
	//ADD pattern
	button.on("click", function() {
		let sample = $("#url").val();
		console.log(sample);
		console.log("in");
		let url = "http://localhost:9090/UrlManager/add";
		let data = { url: sample }
		$.post(url, data, function(response) {
			let json = JSON.parse(response);
			console.log(json);
			addCheck(json);
		})
	})
	let p = $("<p id='error' class='error'></p>")
	div.append(input);
	div.append(button);
	div.append(p);
	modal.append(div);
})

function addCheck(json) {
	if (json.status == "success") {
		window.location.href = "home.html";
	}
	else {
		let box = $("#upload_box");
		$("#error").text(json.message);
		box.css("height", "160px");
	}
}

$(".cssbuttons-io-button").click(function() {
	let sample = $("#sampleUrl").val();
	console.log(sample);
	let data = { sampleUrl: sample };
	let url = "http://localhost:9090/UrlManager/check";
	$.post(url, data, function(response) {
		let json = JSON.parse(response);
		let i = 0;
		//Checking
		json.forEach(element => {
			console.log(element);
			let box_div = $("#n" + i);
			let status = $("#y" + i);
			status = status.attr("class", "box_status");
			if (element.matches == "yes") {
				box_div.css("color", "green");
				console.log(element.value);
				status.text(element.value);
			}
			else {
				box_div.css("color", "RGB(177, 34, 70)");
				status.text(element.message);
			}
			i += 1;
		})
	});
})





