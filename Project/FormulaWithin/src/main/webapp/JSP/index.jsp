<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormulaE</title>
<link rel="stylesheet" href="CSS/login.css">
<!-- <link rel="icon" href="icon.png" type="image/icon type">-->
</head>
<body>
	<section class="navigation">
		<div class="nav-container">
			<div class="brand">
				<a href="#!">FormulaE</a>
			</div>
			<nav>
				<div class="nav-mobile">
					<a id="navbar-toggle" href="#!"><span></span></a>
				</div>

				<div class="divv">
					<ul class="nav-list">
						<li><a href="home.html">Home</a></li>
						<li><a href="#!">About</a></li>
						<li><a href="index.html">Login</a></li>
						<li><a href="#!">SignUp</a></li>
						<li><a href="#!">Contact</a></li>
					</ul>
				</div>


			</nav>
		</div>
	</section>
	<div class="card">
		<div class="card2">
			<div id="top">
				<h2 id="signup">Login</h2>
			</div>
			<form action="login" method="post">
				<div class="form__group field">
					<input type="text" class="form__field" placeholder="Name"
						name="username" id='name' maxlength='27' required
						autocomplete="off" /> <label for="name" class="form__label">Name</label>
				</div>
				<div class="form__group field">
					<input type="password" class="form__field" placeholder="Password"
						name="password" maxlength='30' id='pwd' required /> <label
						for="pwd" class="form__label">Password</label>
				</div>
				<div id="containButton">
					<button value="submit">Submit</button>
				</div>
			</form>

		</div>
	</div>

	<section class="footer">
		<p>Done by Rithik@2022</p>
	</section>
	<script src="JS/login.js"></script>
</body>
</html>