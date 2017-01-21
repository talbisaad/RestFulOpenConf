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
		<form action="ConferenceList" method="POST">
			<br> <br> <span class="ttl">List of conferences</span><br>
			<br> <br>
			<div class="tables">
				<table cellpadding="0" cellspacing="0" class="tabs">
					<thead>
						<tr>
							<td>Conference Name</td>
							<td>Subject</td>
							<td>Day</td>
							<td>Participants</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach begin="0" end="${lengh}" step="1"
							varStatus="loopCounter" items="${conferencelist}" var="c">
							<tr>

								<td><c:out value="${c.conferanceName}" /></td>
								<td><c:out value="${c.conferenceSubject}" /></td>
								<td><c:out value="${c.time}" /></td>
								<td><c:out value="${c.participantNumber}" /></td>


							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
	</div>
</body>
</html>