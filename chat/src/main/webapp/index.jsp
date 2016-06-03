<!DOCTYPE html>
<html>
<head>
<title>Zoom</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8 col-md-offset-2 text-center">
				<h1>Zoom Chat</h1>
			</div>
		</div>
		<div class="row" id="form">
			<div class="col-md-8 col-md-offset-2">
				<form class="form-horizontal" role="form" id="join-form">
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">Name:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" required placeholder="Enter Name">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="user-name">Username:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="user-name" required placeholder="Enter username">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Join</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row chat hideme" id="chat">
			<div class="col-md-3 text-center img-rounded user-bar" id="user-bar">
				<ul class="nav nav-pills nav-stacked">
					<li>
						<a href="#" class="active">Nimesh</a>
					</li>
					<li>
						<a href="#" title="Mishra">Mishra</a>
					</li>
					<li>
						<a href="#" title="coolnimesh">coolnimesh</a>
					</li>
				</ul>
			</div>
			<div class="col-md-8 text-left img-rounded chat-box" id="chat-box">
				<div class="row">
					<div class="col-md-12 messages" id="messages">hahaha hahaha hahaa</div>
				</div>
				<div class="row">
					<div class="col-md-12 img-rounded text-left msg-box" id="msg-box">
						<div class="row msg-row">
							<div class="col-md-11">
								<input type="text" id="msg" name="msg">
							</div>
							<div class="col-md-1 send-wrap">
								<button class="btn btn-default">
									<span class="glyphicon glyphicon-send" aria-hidden="true">Send</span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
