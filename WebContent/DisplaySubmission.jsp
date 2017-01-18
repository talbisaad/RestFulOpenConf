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
<title>Submission</title>
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
			<br> <br> <span class="ttl">Create submission</span><br>
			<br>


			<form action="SubmissionServlet?action=createSubmission"
				method="POST">

				<fieldset>
					<legend>General information</legend>
					<table width="70%">
						<tr>
							<td>Conference</td>
							<td>:</td>
							<td><select class="selectfilter filterSrch"
								name="conferenceSubject" id="filtersh">
									<c:forEach items="${conferencelist}" var="f">
										<option>${f.conferenceSubject}</option>
									</c:forEach>
							</select></td>

							<td>Submission Title</td>
							<td>:</td>
							<td><input type="text" name="submissionTitle" size="30"
								class="inpt"></td>
						</tr>

						<tr>
							<td>Email</td>
							<td>:</td>
							<td><input type="text" name="mail" size="30" class="inpt"></td>
						</tr>
					</table>
					<table>
						<tr>
							<td>Submission theme</td>
							<td>:</td>
							<td><input type="radio" name="submissionTheme"
								value="Programming" />Programming</td>
							<td><input type="radio" name="submissionTheme"
								value="Classic papers" />Classic papers</td>
							<td><input type="radio" name="submissionTheme"
								value="Networking" />Networking</td>
							<td><input type="radio" name="submissionTheme"
								value="Computer science" />Computer science</td>
						</tr>


						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>

					</table>
				</fieldset>

				<fieldset>
					<legend>Contente</legend>
					<table width="70%">
						<tr>
							<td>Keywords</td>
							<td>:</td>
							<td><input type="text" name="keywords" size="30"
								class="inpt"></td>
						</tr>
						<tr>
							<td>Abstract</td>
							<td>:</td>
							<td><textarea class="inpt" name="submissionAbstract"
									rows="10" cols="50" class="inpt"></textarea></td>
						</tr>
						<tr>
							<td>File</td>
							<td>:</td>
							<td><input type="file" id="fichier" name="fichier" value="" /></td>
						</tr>
						<tr id="lign">
							<td></td>
							<td></td>
							<td><input type="submit" name="valider" value="Valider"
								class="submit" /> <input type="reset" value="Réinitialiser"
								class="submit" name="renit" /></td>
						</tr>
					</table>
				</fieldset>
			</form>

		</div>
	</div>


	<!-- Affichage de la classe  -->


	<div class="inner" id="affichage" style="display: none">
		<br> <br> <span class="ttl">Submission</span><br> <br>
		<form action="Controle?act=ajouteremp" method="POST">
			<fieldset>
				<legend>General information</legend>
				<table width="70%">
					<tr>
						<td>Conference</td>
						<td>:</td>
						<td><label class="selectfilter filterSrch" id="filtersh"><c:out
									value="${submission.conference.conferenceSubject}" /></label></td>

						<td>Submission Title</td>
						<td>:</td>
						<td><label class="selectfilter filterSrch" id="filtersh"><c:out
									value="${submission.submissionTitle}" /></label></td>
					</tr>

					<tr>
						<td>Email</td>
						<td>:</td>
						<td><label class="selectfilter filterSrch" id="filtersh"><c:out
									value="${submission.user.mail}" /></label></td>
					</tr>

					<tr>
						<td>Submission theme</td>
						<td>:</td>
						<td><label class="selectfilter filterSrch" id="filtersh"><c:out
									value="${submission.submissionTheme}" /></label></td>
					</tr>


					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>


				</table>
			</fieldset>

			<fieldset>
				<legend>Contente</legend>
				<table width="70%">
					<tr>
						<td>Keywords</td>
						<td>:</td>
						<td><label class="selectfilter filterSrch" id="filtersh"><c:out
									value="${submission.keywords}" /></label></td>
					</tr>
					<tr>
						<td>Abstract</td>
						<td>:</td>
						<td><label class="selectfilter filterSrch" id="filtersh"><c:out
									value="${submission.submissionAbstract}" /></label></td>
					</tr>
					<tr>
						<td>File</td>
						<td>:</td>
						<td><input type="file" id="fichier" name="fichier" value="" /></td>
					</tr>

				</table>
			</fieldset>
		</form>
		<table>
			<tr>
				<td>
					<form action="SubmissionServlet?action=UpdateSubmission" method="POST">
						<input type="submit" name="Modifier" value="Modifier"
							class="submit" />
					</form>
				</td>
				<td>
					<form action="SubmissionServlet?action=Cancel" method="POST">
						<input type="submit" name="Annuler" value="Annuler" class="submit" />

					</form>
				</td>
			</tr>
		</table>
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

