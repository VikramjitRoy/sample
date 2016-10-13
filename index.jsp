<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Todoist</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script>
	$(document).ready(function() {
		// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
		$('.modal-trigger').leanModal();
	});
</script>
<style type="text/css">
.hero-image {
	position: absolute;
	margin-top: 0px;
	background-image:
		url('http://platowebdesign.com/articles/wp-content/uploads/2014/10/picjumbo.com_IMG_78291-1024x682.jpg');
	width: 100%;
	height: 80%;
	/* background-position: center-top;
	background-size: contain; */
	background-repeat: no-repeat;
}

.goodtext {
	color: white;
	position: relative;
	top: 30%;
	left: 80px;
}
</style>
</head>
<body>

	<nav>
	<div class="nav-wrapper red">
		<a href="#" class="brand-logo">MyTodoist</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a class="waves-effect waves-light modal-trigger red"
				href="#login">Log In</a></li>
			<li><a class="waves-effect waves-light modal-trigger red"
				href="#signup"><b>Sign Up</b></a></li>

		</ul>
	</div>
	</nav>


	<div class="hero-image">
		<section class="goodtext">
		<h2 style="max-width: 50%;">Accomplish more, every day.</h2>
		<h5 style="max-width: 50%;">Millions of people rely on My Todoist
			to get things done</h5>
		</section>
	</div>


	<footer style="top:86%;position:absolute;width:100%;"
		class="page-footer grey">

	<div class="footer-copyright grey">
		<div class="center-align">
			Made with &nbsp;<i class="fa fa-heart fa-2x" aria-hidden="true"
				style="color: red;"></i>&nbsp; b y&nbsp;V i k r a m j i t&nbsp;R o y <i
				class="fa fa-thumbs-up" aria-hidden="true"></i>
		</div>
	</div>
	</footer>
	<div id="login" class="modal">
		<div class="modal-content">
			<form class="col s12" action="login" method="post">
				<div class="row">
					<div class="input-field col s12">
						<input id="email" type="email" name="loginEmail" class="validate" required="">
						<label for="email" data-error="wrong" data-success="right">Email</label>

					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="password" type="password" name="loginPassword" class="validate" required="">
						<label for="password" data-error="wrong" data-success="right">Password</label>
					</div>
				</div>


				<button class="btn waves-effect red" type="submit" name="action">
					Login</button>
			</form>
		</div>

	</div>



	<div id="signup" class="modal ">
		<div class="modal-content container center-align">
			<div class="section">
				<a class="waves-effect red btn ">Log in with Google Account.</a>
			</div>
			<div class="divider"></div>
			<div class="section">
				<form action="register" method="post">

					<div class="row">
						<div class="input-field col s12">
							<input type="text" name="username" class="validate" required="" aria-required="true"> <label
								for="username" data-error="wrong" data-success="right">username</label>
						</div>
					</div>

					<div class="row">
						<div class="input-field col s12">
							<input id="email" type="email" name="email" class="validate" required="" aria-required="true">
							<label for="email" data-error="wrong" data-success="right">Email</label>
						</div>
					</div>

					<div class="row">
						<div class="input-field col s12">
							<input id="password" type="password" name="password"
								class="validate" required="" aria-required="true"> <label for="password" data-error="wrong"
								data-success="right">password</label>
						</div>
					</div>

					<button class="btn waves-effect red" type="submit" name="action">
						Create account.</button>

				</form>

			</div>

		</div>

	</div>


</body>
</html>
