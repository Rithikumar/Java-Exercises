let Gjson;
let modal = document.getElementById("modal");
let resModal = document.getElementById("result");
modal.classList.add("none");
resModal.classList.add("none");

function none(id) {
	let rem = document.getElementById(id);
	rem.classList.add("none");
}

function printStatus(json) {
	let box = document.getElementById("formula_box");
	box.innerHTML = "";
	let p = document.createElement("div");
	p.setAttribute("class", "smallest_box");
	let p2 = document.createElement("p");
	p2.innerText = json.message;
	p.appendChild(p2);
	box.appendChild(p);
}

function get() {
	$.ajax({
		type: "POST",
		url: "http://localhost:9090/FormulaWithin/get",
		success: function(response) {
			let json = JSON.parse(response)
			console.log(json);
			showPatterns(json);
		}
	});
}

function check() {
	$.ajax({
		type: "POST",
		url: "http://localhost:9090/FormulaWithin/check",
		success: function(response) {
			let json = JSON.parse(response)
			console.log(json);
			showResult(json);
			let box = document.getElementById("formula_box");
			box.innerHTML = "";
			get();
		}
	});
}

function showResult(json) {
	resModal.classList.remove("none");
	resModal.innerHTML = "";
	let div = document.createElement("div");
	div.setAttribute("class", "upload-box")
	let p = document.createElement("h3");
	p.innerText = "Result";
	p.setAttribute("class","res-title");
	div.appendChild(p);
	if(json.result.length != 0){
	for (let i in json.result) {
		let p1 = document.createElement("p");
		p1.setAttribute("class", "res-exp");
		p1.innerText = json.result[i].formulaName + " = " + json.result[i].result
		div.appendChild(p1);
	}
	}
	else{
		let p1 = document.createElement("p");
		p1.setAttribute("class", "res-exp");
		p1.innerText = "No formula found";
		div.appendChild(p1);
	}
	resModal.appendChild(div);
}

function send() {
	let formulaName = document.getElementById("formName");
	let formulaExp = document.getElementById("formExp");
	if (formulaName.value === "" || formulaExp.value === "") {
		alert("formula name and formula expression needed");
	}
	else if (formulaName.value.startsWith(" ")){
		alert("Give a valid name")
	}
	
	else {
		$.ajax({
			type: "POST",
			data: {
				formulaName: formulaName.value,
				formulaExpression: formulaExp.value
			},
			url: "http://localhost:9090/FormulaWithin/add",
			success: function(response) {
				let json = JSON.parse(response)
				console.log(json);
				printStatus(json);
				formulaName.value = "";
				formulaExp.value = "";
				get();
			}
		});
	}
}

function deletes(id) {
	i = id.substring(1);
	let formulaName = Gjson.formulas[i].formulaName;
	let formulaExp = Gjson.formulas[i].formulaExpression;
	$.ajax({
		type: "POST",
		data: {
			formulaName: formulaName,
			formulaExpression: formulaExp
		},
		url: "http://localhost:9090/FormulaWithin/delete",
		success: function(response) {
			let json = JSON.parse(response)
			console.log(json);
			printStatus(json);
			get();
		}
	});

}

function updates(id, event) {
	i = id.substring(1);
	if (event.key == "Enter") {
		let formulaName = document.getElementById("n" + i);
		let formulaExp = document.getElementById(id);
		if (formulaName.value === "" || formulaExp.value === "") {
			alert("formula name and formula expression needed");
		}
		else {
			$.ajax({
				type: "POST",
				data: {
					formulaName: formulaName.innerText,
					formulaExpression: formulaExp.value
				},
				url: "http://localhost:9090/FormulaWithin/update",
				success: function(response) {
					let json = JSON.parse(response)
					console.log(json);
					printStatus(json);
					get();
				}
			});
		}
		modal.classList.add("none");
	}
}

function showPatterns(json) {
	Gjson = json;
	let box = document.getElementById("formula_box");
	if (json.formulas != "undefined") {

		//box.innerHTML = "";
		let div = document.createElement("div");
		div.setAttribute("class", "small_box formula_content")
		div.setAttribute("id", "i" + -1);
		let h3 = document.createElement("h3");
		h3.setAttribute("class", "txt formula_name");
		let p1 = document.createElement("p");
		p1.setAttribute("class", "formula_exp");
		h3.innerText = 'Formula Name';
		p1.innerText = "Formula Expression";
		div.appendChild(h3);
		div.appendChild(p1);
		box.appendChild(div);
		for (let i in json.formulas) {
			let div = document.createElement("div");
			div.setAttribute("class", "small_box formula_content")
			div.setAttribute("id", "i" + i);
			div.setAttribute("onclick", "dis(this.id)");
			let h3 = document.createElement("h3");
			h3.setAttribute("id", "n" + i);
			h3.setAttribute("class", "txt formula_name");
			let p1 = document.createElement("input");
			p1.setAttribute("id", "e" + i);
			p1.setAttribute("class", "formula_exp effect-2");
			p1.setAttribute("disabled", "true");
			p1.setAttribute("onkeypress", "updates(this.id,event)")
			let d1 = document.createElement("i");
			d1.setAttribute("class", "dt fa fa-solid fa-trash");
			d1.setAttribute("id", "d" + i);
			d1.setAttribute("onclick", "deletes(this.id)");
			h3.innerText = json.formulas[i].formulaName;
			p1.value = json.formulas[i].formulaExpression;
			div.appendChild(h3);
			div.appendChild(p1);
			div.appendChild(d1);
			box.appendChild(div);
		}
	}
	else {
		let p = document.createElement("div");
		p.setAttribute("class", "smallest_box");
		let p2 = document.createElement("p");
		p2.innerText = "No formulas present";
		p.appendChild(p2);
		box.appendChild(p);
	}

}

/*function dis(id) {
	i = id.substring(1);
	console.log('in');
	document.getElementById("e" + i).disabled = false;
}*/



