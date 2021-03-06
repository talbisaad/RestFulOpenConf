<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="CSS/style.css" />
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="JS/jquery-ui.js"></script>
<script type="text/javascript" src="JS/script.js"></script>
<title>Create conference</title>
</head>

<body>
	<div class="header">
		<ul>
			<li><a href="#" class="dcnx">Deconnexion</a></li>
		</ul>
	</div>
	<div class="inner">
		<div class="opr" id="importFil">
			<jsp:include page="menuAdmin.jsp"></jsp:include>
	</div>

		<div id="creation">
			<br> <br> <span class="ttl">Create conference</span><br>
			<br>


			<form action="ConferenceServlet?action=CreateConference" method="POST">

				<table width="70%">

					<tr>
						<td>Conference Name</td>
						<td>:</td>
						<td><input type="text" name="conferanceName" size="30" class="inpt"></td>

						<td>Subject</td>
						<td>:</td>
						<td><input type="text" name="conferenceSubject" size="30" class="inpt"></td>
					</tr>
					<tr>
						<td>Day</td>
						<td>:</td>
						<td><input type="text" name="time" size="30" class="inpt"></td>
						 
					</tr>
					<tr>
						<td>Number of participants</td>
						<td>:</td>
						<td><input type="text" name="participantNumber" size="30" class="inpt"></td>
					</tr>

					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr id="lign">
						<td></td>
						<td></td>
						<td><input type="submit" name="valider" value="Valider"
							class="submit" /> <input type="reset" value="Réinitialiser"
							class="submit" name="renit" /></td>
					</tr>

				</table>
			</form>

		</div>
	</div>


	<!-- Affichage de la classe  -->


	<div class="inner" id="affichage" style="display: none">
		<br> <br> <span class="ttl">Conference</span><br> <br>
		<form action="ConferenceServlet?action=CreateConference" method="POST">

			<table width="70%">
				<tr>
					<td>Conference name</td>
					<td>:</td>
					<td><label  class="selectfilter filterSrch" id="filtersh" ><c:out
								value="${conference.conferanceName}" /></label></td>

					<td>Subject</td>
					<td>:</td>
					<td><label class="selectfilter filterSrch" id="filtersh"><c:out
								value="${conference.conferenceSubject}" /></label></td>
				</tr>
				<tr>
					<td>Day</td>
					<td>:</td>
					<td><label class="selectfilter filterSrch" id="filtersh"><c:out
								value="${conference.time}" /></label></td>
					 
				</tr>
				
				<tr>
					<td>Number of participants</td>
					<td>:</td>
					<td><label class="selectfilter filterSrch" id="filtersh"><c:out
								value="${conference.participantNumber}" /></label></td>
				</tr>

				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr id="lign">
					<td></td>
					<td></td>

				</tr>

			</table>
		</form>
		 
	</div>

	<script>
		<c:if test="${creation eq 'false'}">
		creation.style.display = "none";
		</c:if>
		<c:if test="${affichage eq 'true'}">
		affichage.style.display = "block";
		</c:if>
	</script>

</body>
</html>

