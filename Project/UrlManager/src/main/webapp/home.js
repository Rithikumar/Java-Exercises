let modal = document.getElementById("modal");
modal.classList.add("none");

function getPatterns(){
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:9090/UrlManager/get"
	xhr.onload = function() {
		if(this.status === 200) {
			console.log(this.response);
			let json = JSON.parse(this.response);
			console.log(json);
			showPatterns(json);
		}
	}
	xhr.open('GET',url);
	xhr.setRequestHeader("Accept","application/json");
	xhr.send();
}

function showPatterns(json){
	let i = 0;
	json.forEach(element => {
		let box_div = document.createElement("div");
		box_div.setAttribute("class","box");
		box_div.setAttribute("id","n"+i);
		let box_cont = document.createElement("h3");
		box_cont.setAttribute("class","box_url");
		box_cont.innerText = element;
		let status = document.createElement("p");
		status.setAttribute("class","box_status");
		status.setAttribute("id","y"+i);
		status.innerText = "none";
		let icon = document.createElement("p");
		icon.setAttribute("class","icon");
		let arrow = document.createElement("i");
		arrow.setAttribute("class","arrow");
		icon.appendChild(arrow);
		box_div.appendChild(box_cont);
		box_div.appendChild(icon);
		box_div.appendChild(status);
		box_div.setAttribute("onclick","showStatus(this.id)");
		document.getElementById("bigBox").appendChild(box_div);
		i += 1;
	})
}

function addPattern() {
	modal.classList.remove("none");
	modal.innerHTML = `<div id="upload-box"><input placeholder="url" id="url" autocomplete="off"/><button id="upload-button" class="call" onclick="add()">submit</button><p id="error" class="error"></p>`;

}

/*function add(){
	let sample = document.getElementById("url").value;
	console.log("in");
		$.ajax({
			type: "POST",
			data: {
				url: sample
			},
			url: "http://localhost:9090/UrlManager/add",
			success: function(response) {
				let json = JSON.parse(response)
				console.log(json);
				addCheck(json);
			}
		});
}*/

function addCheck(json) {
	if(json.status == "success"){
		window.location.href = "home.html"
	}
	else{
		let box = document.getElementById("upload-box");
		let error = document.getElementById("error");
		error.innerHTML = json.message;
		box.style.height = "160px";
	}
}

$(document).ready(function() {
	console.log("open");
	$(".cssbuttons-io-button").click(function() {
		console.log("in");
		let sample = document.getElementById("sampleUrl").value;
		$.ajax({
			type: "POST",
			data: {
				sampleUrl: sample
			},
			url: "http://localhost:9090/UrlManager/check",
			success: function(response) {
				let json = JSON.parse(response)
				checking(json);
			}
		});
	});
});

/*function send(){
	let xhr = new XMLHttpRequest();
	let sample = document.getElementById("sampleUrl").value;
	let url = "http://localhost:9090/UrlManager/check?sampleUrl="+sample;
	xhr.onload = function() {
		if(this.status === 200) {
			console.log(this.response);
			let json = JSON.parse(this.response);
			console.log(json);
			checking(json);
		}
	}
	xhr.open('GET',url);
	xhr.setRequestHeader("Accept","application/json");
	xhr.send();
}*/

function checking(json){
	let i = 0;
	json.forEach(element => {
		let box_div = document.getElementById("n"+i);
		let status = document.getElementById("y"+i);
		status.setAttribute("class","box_status");
		if(element.matches == "yes"){
			box_div.style.color = "green";
			status.innerText = element.value;
		}
		else{
			box_div.style.color = "RGB(177, 34, 70)";
			status.innerText = element.message;
		}
		i+=1;
	});
}

let count = 0;
let id1 = 0;
function showStatus(id){
if(id1!=id){count=0;}
	if(count%2 == 0 ){
		document.getElementById(id).style.height = "140px";
	}
	else{
		document.getElementById(id).style.height = "40px";
	}
	id1 = id;
	count++
}