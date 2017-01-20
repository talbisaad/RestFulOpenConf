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


		<br> <br> <span class="ttl">Review submission</span><br> <br>
		<form  action="SubmissionServlet?action=SaveReview"
						method="POST">
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
									value="${submission.submissionTheme}"/></label></td>
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

			<fieldset >
				<legend>Review the submission</legend>
				<table>
					<tr>
						<td><input type="radio" name="droit" value="Accepted" />Accepted</td>
						<td><input type="radio" name="droit" value="to modify" />to modify</td>
						<td><input type="radio" name="droit" value="refused" />refused</td>
					</tr>
					<tr>
					<td>Comments</td>
					<td>:</td>
					<td><td><textarea class="inpt" name="Comments"
									rows="10" cols="50" class="inpt"></textarea></td>
									
					</tr>
					<tr>
					<td>Grad</td>
					<td>:</td>
					<td><select class="selectfilter filterSrch" name="Grad"
							id="filtersh">
						<c:forEach begin="0" end="${10}" step="1" varStatus="loopCounter" var="c">					 
							 <option><c:out value="${c}"/></option>
													 
						</c:forEach> 
      									 
						</select></td>
					</tr>
				</table>
			</fieldset>
		
		<table>
			<tr>
				<td>
					 
						<input type="submit" name="Modifier" value="Save Review"
							class="submit" />
				 
				</td>
				 
			</tr>
		</table>
		</form>
	</div>


</body>
</html>

