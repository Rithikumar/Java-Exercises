$(document).ready(function() {
	get();
	let Gson;
	let modal = $("#modal");
	let resModal = $("#result");
	modal.addClass("none");
	resModal.addClass("none");

	//Hide
	$(".result").click(function() {
		$(this).add("class","none");
	})
	
	//Adding new formula
	$("#add").click(function() {
		let formulaName = $("#formName").val();
		let formulaExp = $("#formExp").val();
		if (formulaName == "" || formulaExp == "") {
			alert("Formula name and experssion is needed");
		}
		else if (formulaName.startsWith(" ")) {
			alert("Give a valid name")
		}
		else {
			let url = "http://localhost:9090/FormulaWithin/add";
			let data = { formulaName: formulaName, formulaExpression: formulaExp }
			$.post(url, data, function(response) {
				let json = JSON.parse(response);
				console.log(json);
				printStatus(json);
				$("#formName").val("");
				$("#formExp").val("");
				get();
			})
		}
	})

	//Prints the status of the add,delete,updates
	function printStatus(json) {
		let box = $("#formula_box");
		box.html("");
		let p = $("<div class='smallest_box'></div>");
		let p2 = $("<p></p>").text(json.message);
		p.append(p2);
		box.append(p);
	}

	//Getting the formulas
	function get() {
		let url = "http://localhost:9090/FormulaWithin/get";
		$.get(url, function(response) {
			let json = JSON.parse(response);
			console.log(json);
			showFormula(json);
		})
	}

	//Show all formulas
	function showFormula(json) {
		Gson = json;
		let box = $("#formula_box");
		if (json.formulas != "undefined") {

			let div = $("<div class='small_box formula_content' id=i" + -1 + "></div>");
			let h3 = $("<h3 class='txt formula_name'></h3>").text("Formula Name");
			let p1 = $("<p class='formula_exp'></p>").text("Formula Expression");
			div.append(h3);
			div.append(p1);
			box.append(div);
			//Looping each formulas
			for (let i in json.formulas) {
				
				//Disables
				let div = $("<div class='small_box formula_content' id=i" + i + "></div>").on("click",function(){
					id = $(this).attr("id").substring(1);
					$("#e"+id).prop("disabled",false);
				});			
				
				let h3 = $("<h3 class='txt formula_name' id='n"+i+"'></h3>").text(json.formulas[i].formulaName);
				let p1 = $("<input class='formula_exp effect-2' disabled='true' id=e" + i + "></input>").val(json.formulas[i].formulaExpression);

				//UPDATES
				p1 = p1.on("keypress",function(event){
					id = $(this).attr("id").substring(1);
					if(event.key == "Enter"){
						let formulaName = $("#n"+id).text();
						let formulaExp = $("#e"+id).val();
						console.log(formulaName + ' ' + formulaExp)
						if(formulaName = "" || formulaExp == ""){
							alert("formula name and and formula expression needed")
						}
						else{
							let url = "http://localhost:9090/FormulaWithin/update"
							let data = {formulaName:formulaName,formulaExpression:formulaExp}
							$.post(url,data,function(response){
								let json = JSON.parse(response);
								console.log(json);
								printStatus(json);
								get();
							})
						}
					}
				})
				// DELETES function
				let d1 = $("<i class='dt fa fa-solid fa-trash' id=d" + i + "></i>").on("click", function() {
					i = $(this).attr("id").substring(1);
					let formulaName = Gson.formulas[i].formulaName;
					let formulaExp = Gson.formulas[i].formulaExpression;
					console.log("hello");
					let url = "http://localhost:9090/FormulaWithin/delete";
					let data = { formulaName: formulaName, formulaExpression: formulaExp };
					$.post(url, data, function(response) {
						let json = JSON.parse(response);
						console.log(json);
						printStatus(json);
						get();
					})
				});

				//appending
				div.append(h3);
				div.append(p1);
				div.append(d1);
				box.append(div);
			}
		}
		else {
			let p = $("<div class='smallest_box'></div>");
			let p2 = $("<p></p>").text("No formulas present");
			p.append(p2);
			box.append(p);
		}
	}

	//Check
	$(".check").click(function() {
		let url = "http://localhost:9090/FormulaWithin/check";
		$.get(url, function(response) {
			let json = JSON.parse(response);
			console.log(json);
			showResult(json);
			let box = $("#formula_box");
			box.html("");
			get();
		})
	})

	//Show Result
	function showResult(json) {
		resModal.removeAttr("class");
		resModal.html("");
		let div = $("<div class='upload-box'></div>");
		let p = $("<div class='res-title'></div>").text("Result");
		div.append(p);
		if (json.result.length != 0) {
			for (let i in json.result) {
				let p1 = $("<p class='res-exp'></p>").text(json.result[i].result);
				div.append(p1);
			}
		}
		else {
			let p1 = $("<p class='res-exp'></p>").text("No formila found");
			div.append(p1);
		}
		resModal.append(div);
	}

});

function none(id) {
	let rem = document.getElementById(id);
	rem.classList.add("none");
}

