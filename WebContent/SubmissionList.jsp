<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="CSS/style.css" />
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="JS/jquery-ui.js"></script>
<script type="text/javascript" src="JS/script.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>List of conferences</title>
</head>
<body>	

	 <div class="header">
		<ul>
			<li><a href="#" class="dcnx">Deconnexion</a></li>
		</ul>
	</div>
	<div class="inner">
	<div class="opr">
			<jsp:include page="menuAdmin.jsp"></jsp:include>
		</div>
		<br> <br> <span class="ttl">Search submission</span><br>
		<br>
	<fieldset>
			<legend>Search</legend>
			<form action="SubmissionServlet?action=SearchSubmission" method="POST">
				<div>

					<table width="70%">

						<tr>
							<td>E-mail</td>
							<td>:</td>
							<td><input type="text" class="inpt" name="mail"
								size="30"></td>

							 
						</tr>

						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td><input type="submit" class="submit" value="Rechercher" />
							</td>
						</tr>

					</table>
				</div>
			</form>
		</fieldset>
	
	
		
		<br> <br> <span class="ttl">List of conference</span><br>
		<br>
		<br>
		<div class="tables">
			<table cellpadding="0" cellspacing="0" class="tabs">
				<thead>
					<tr>
						<td>Submission Title</td>
						<td>Conference</td>
						<td>keyword</td>
						<td>Comments</td>
						<td>Status</td>
						<td>Modify</td>
						<td>Delete</td>  
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="0" end="${lengh}" step="1" varStatus="loopCounter" items="${submissionList}" var="c">
						<tr>

							<td ><c:out  value="${c.submissionTitle}"/></td>
							<td><c:out value="${c.conference.conferanceName}"/></td>
							<td><c:out value="${c.keywords}"/></td>
							<td><c:out value="${c.reviewComments}"/></td>
							<td><c:out value="${c.status}"/></td>
							<td><form action="SubmissionServlet?action=UpdateSubFromList" method="POST"><button style="border:0px solid black; background-color: transparent;" type="submit" name="Modifier"><img alt="modify" class="modifyicone"
								src="CSS/modify.png"></button>
								  <input type="hidden" name="idSubmission" value="${c.idSubmission}"/>  
								</form></td>
							<td><form action="SubmissionServlet?action=DeleteSubmission" method="POST"><button style="border:0px solid black; background-color: transparent;" type="submit" name="Modifier"> <img alt="delete" class="deleteicone"
								src="CSS/delete.png"></button>
							   <input type="hidden" name="idSubmission" value="${c.idSubmission}"/>  
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>