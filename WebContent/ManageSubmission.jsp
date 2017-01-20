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
<title>Manage submission</title>
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

		<div id="modification">
			<br> <br> <span class="ttl">Manage submission</span><br>
			<br>


			<form action="SubmissionServlet?action=SaveManageSubmission"
				method="POST">
				<fieldset>
					<legend>General information</legend>
					<table width="70%">

						<tr>


							<td>Submission Title</td>
							<td>:</td>
							<td><input type="text" name="submissionTitle" size="30"
								value="<c:out value="${submission.submissionTitle}"/>"></td>
							<td><input type="text" name="submissionTitleHidden"
								style="display: none;" size="30"
								value="<c:out value="${submission.submissionTitle}"/>"></td>
						</tr>

					</table>
					<table width="70%">
						<tr>
							<td>Submission theme</td>
							<td>:</td>

							<td><select class="selectfilter filterSrch"
								name="submissionTheme" id="filtersh">
									<c:forEach items="${submissionThemes}" var="f">
										<c:if test="${f==submission.submissionTheme}">
											<option selected="selected">${f}</option>
										</c:if>
										<c:if test="${f!=submission.submissionTheme}">
											<option>${f}</option>
										</c:if>

									</c:forEach>
							</select></td>

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
								class="inpt" value="<c:out value="${submission.keywords}"/>"></td>
							<td><input type="text" name="keywordsHidden"
								style="display: none;" size="30"
								value="<c:out value="${submission.keywords}"/>"></td>
						</tr>
						<tr>
							<td>Abstract</td>
							<td>:</td>
							<td><input type="text" class="inpt"
								name="submissionAbstract" class="inpt"
								value="<c:out value="${submission.submissionAbstract}"/>"></td>
							<td><input type="text" name="submissionAbstractHidden"
								style="display: none;" size="30"
								value="<c:out value="${submission.submissionAbstract}"/>"></td>
						</tr>
						<tr>
							<td>File</td>
							<td>:</td>
							<td><input type="file" id="fichier" name="fichier" value="" /></td>
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
				</fieldset>
			</form>

		</div>
	</div>
</body>
</html>