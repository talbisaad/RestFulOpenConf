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


			<form action="ServletClass?action=SaveClass" method="POST">
				<fieldset>
					<legend>General information</legend>
					<table width="70%">

						<tr>
							<td>Conference</td>
							<td>:</td>
							<td><input type="text" name="NomClasse" size="30"
								value="<c:out value="${classe.nomClasse}"/>"></td>
								

							<td><input type="text" name="NomClasseHidden"
								style="display: none;" size="30"
								value="<c:out value="${classe.nomClasse}"/>"></td>


							<td>Submission Title</td>
							<td>:</td>
							<td><input type="text" name="NomClasse" size="30"
								value="<c:out value="${classe.nomClasse}"/>"></td>
							<td><input type="text" name="filiereHidden"
								style="display: none;" size="30"
								value="<c:out value="${classe.filiere.nom}"/>"></td>
						</tr>
						<tr>
							<td>Email</td>
							<td>:</td>
							<td><input type="text" name="NomClasse" size="30"
								value="<c:out value="${classe.nomClasse}"/>"></td>

							<td><input type="text" name="niveauHidden"
								style="display: none;" size="30"
								value="<c:out value="${classe.niveau}"/>"></td>

						</tr>
						</table>
						<table width="70%">
						<tr>
							<td>Submission theme</td>
							<td>:</td>
							<td><input type="radio" name="droit" value="CD" />Programming</td>
							<td><input type="radio" name="droit" value="RF" />Classic
								papers</td>
							<td><input type="radio" name="droit" value="AD" />Networking</td>
							<td><input type="radio" name="droit" value="AD" />Computer
								science</td>
						</tr>
					</table>
				</fieldset>

	<!-- Faut ajouté les champs caché !!!!!!!!
	 -->			<fieldset>
					<legend>Contente</legend>
					<table width="70%">
						<tr>
							<td>Keywords</td>
							<td>:</td>
							<td><input type="text" name="NomClasse" size="30"
								class="inpt"></td>
						</tr>
						<tr>
							<td>Abstract</td>
							<td>:</td>
							<td><textarea class="inpt" name="NomClasse" rows="10"
									cols="50" class="inpt"></textarea></td>
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