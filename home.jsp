<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todoist</title>
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
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<style type="text/css">
.calendar-text {
	margin-top: .3em;
}

.tabs {
	font-size: 2px;
}
</style>
<script>
	function myfunc() {
		document.getElementById("dateTime").innerHTML = "Hello, World!";
	}
</script>
</head>
<body>

	<nav>
	<div class="nav-wrapper red">
		<a href="#" class="brand-logo">MyTodoist</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a class="waves-effect waves-light modal-trigger red"
				href="#notification"><i class="fa fa-bell" aria-hidden="true"></i></a></li>
			<li><a class="waves-effect waves-light modal-trigger red"
				href="#addTask"><i class="fa fa-plus-square" aria-hidden="true"></i></a></li>
			<li><a class="waves-effect waves-light modal-trigger red"
				href="#signup"><b><i class="fa fa-bars" aria-hidden="true"></i></b></a></li>
		</ul>
	</div>


	</nav>
	<ul id="nav-mobile" class="side-nav fixed"
		style="top: 10%; width: 30%;">
		<li><a class="waves-effect waves-light" href="inbox"><span
				class="fa-stack"> <i class="fa fa-inbox fa-stack-2x"></i> <strong
					class="fa-stack-1x calendar-text"></strong></span><b>&nbsp;Inbox</b> </a></li>
		<li><a class="waves-effect waves-light" href="daily"><span
				class="fa-stack"> <i class="fa fa-calendar-o fa-stack-2x"></i>
					<strong class="fa-stack-1x calendar-text"></strong>
			</span><b>&nbsp;Today</b> </a></li>
		<li><a class="waves-effect waves-light" href="weekly"><span
				class="fa-stack"> <i class="fa fa-calendar-o fa-stack-2x"></i>
					<strong class="fa-stack-1x calendar-text">+7</strong>
			</span><b>&nbsp;Next 7 days</b> </a></li>
		<div class="row">
			<div class="col s12">
				<ul class="tabs">
					<li class="tab col s3"><a href="#test1">Project</a></li>
					<li class="tab col s3"><a href="#test3">Filters</a></li>
				</ul>
			</div>
		</div>
		<div id="test1" class="col s12" style="padding-left: 10%;">
			<p>
				<i class="fa fa-circle" aria-hidden="true" style="color: red;"></i>&nbsp;&nbsp;Test
				1
			</p>
			<p>
				<i class="fa fa-circle" aria-hidden="true" style="color: green;"></i>&nbsp;&nbsp;Test
				2
			</p>
			<p>
				<i class="fa fa-circle" aria-hidden="true" style="color: blue;"></i>&nbsp;&nbsp;Test
				3
			</p>
			<p>
				<i class="fa fa-circle" aria-hidden="true" style="color: yellow;"></i>&nbsp;&nbsp;Test
				4
			</p>
			<p>
				<i class="fa fa-circle" aria-hidden="true" style="color: grey;"></i>&nbsp;&nbsp;Test
				5
			</p>
			<ul class="collapsible" data-collapsible="accordion"
				style="padding: 0px; margin: 0px;">
				<li>
					<div class="collapsible-header "
						style="margin-left: 0px; padding: 0px;">
						<span class="fa-stack"> <i class="fa fa-plus fa-stack-2x"></i>
							<strong class="fa-stack-1x calendar-text"></strong></span><b>&nbsp;Inbox</b>
					</div>
					<div class="collapsible-body">
						<form>
							<input type="text" />
							<button class="btn waves-effect red" type="submit" name="action">
								Add Project</button>
						</form>
					</div>
				</li>
			</ul>
		</div>

	</ul>
	<div class="main-content" style="padding-left: 35%;">
		<h3>TaskType</h3>
		<c:forEach items="${list}" var="task">
			<div class="section">
				<i class="fa fa-circle-thin fa-lg" aria-hidden="true"></i> <span><c:out
						value="${task.content}" /></span>
						
				<script>					
						document.getElementById("dateTime").innerHTML = <c:out value="${task.content}" />;
				</script>																
				<span id="dateTime" style="float: right; color: grey;"/><c:out value="${fn:substring(task.date,0,10)}" /></span>
			</div>
			<div class="divider"></div>
		</c:forEach>
		<h1></h1>

		<div class="section">
			<ul class="collapsible" data-collapsible="accordion"
				style="padding: 0px; margin: 0px;">
				<li>
					<div class="collapsible-header "
						style="margin-left: 0px; padding: 0px;">
						<span class="fa-stack"> <i class="fa fa-plus fa-stack-2x"></i>
							<strong class="fa-stack-1x calendar-text"></strong></span><b>&nbsp;Inbox</b>
					</div>
					<div class="collapsible-body">
						<form>
							<input type="text" />
							<button class="btn waves-effect red" type="submit" name="action">
								Add Project</button>
						</form>
					</div>
				</li>
			</ul>
		</div>

	</div>
	<div id="addTask" class="modal ">
		<div class="modal-content container center-align">
			<form action="addTask" method="post">
				<div class="row">
					<div class="input-field col s12">
						<input id="text" name="content" type="text" class="validate"
							required="" aria-required="true"> <label for="email">Enter
							the task</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="date" name="date" type="date" class="validate"
							required="" aria-required="true">
					</div>
				</div>
				<div class="row">
					<div class="input-field col">
						<select name="project" id="project">
							<option>Inbox</option>
							<option>Personal</option>
							<option>Shopping</option>
							<option>Errands</option>
							<option>Movies to watch</option>
						</select> <label for="category">Project</label>
					</div>
					<div class="input-field col">
						<select name="priority" id="priority">
							<option>Priority 1</option>
							<option>Priority 2</option>
							<option>Priority 3</option>
							<option>Priority 4</option>
						</select> <label for="priority">Priority</label>
					</div>
				</div>
				<button class="btn waves-effect center-align red" type="submit"
					name="action">Add Task</button>

			</form>
		</div>
	</div>



</body>
</html>
