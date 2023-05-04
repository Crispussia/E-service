<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="fr.eilco.model.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <header class="main-header">
        <!-- Start Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav" style="height: 60px">
            <div class="container">
                <!-- Start Header Navigation -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
<!--  <img src="images/logo.png" class="logo" alt="" >-->
                    <a class="navbar-brand" href="accueil.do"><h2>MaBoutique</h2></a>                </div>
                <!-- End Header Navigation -->

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                        <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/accueil.do">Accueil</a></li>
                        
                        
                        <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/categories.do">Categories</a></li>
                        <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/panier.do">
                          <%
							if (session.getAttribute("client")== null) {%>
		            			<%
								if (session.getAttribute("cart")!= null) {
										Cart test = (Cart) session.getAttribute("cart");
									%>
										Voir panier <span style="position: absolute;top: -10px;right: -10px;padding: 3px 30px;
                          			 ">(<%= test.getCart().size() %>)</span>
									
								<% }else{%>
								Voir panier<span style="position: absolute;top: -10px;right: -10px;padding: 3px 30px;
	                           ">(0)</span>
								
								<%
								}%>
		        		
		        		<%}else{%>
		        	
		        			<%
								if (session.getAttribute("cart")!= null) {
										Cart test = (Cart) session.getAttribute("cart");
									%>
										Mon panier <span style="position: absolute;top: -10px;right: -10px;padding: 3px 30px;
                           ">(<%= test.getCart().size() %>)</span>
									
							<% }else{%>
							Mon panier<span style="position: absolute;top: -10px;right: -10px;padding: 3px 30px;
                           ">(0)</span>
							
							<%
							}%>
		        	
		        	
		        		<%}%>
                        </a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->   
        </nav>
        <!-- End Navigation -->
    </header>
    
    <div class="card w-50 mx-auto my-5">
    <div class="card-header text-center">Créer compte</div>
			
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/connexion.do" method="POST" class="was-validated">
			        <div class="form-group">
			            <label for="name"><b>Nom</b></label>
			            <input type="text" class="form-control" id="name" placeholder="Votre nom" name="name" required>
			            
			        </div>
			        <div class="form-group">
			            <label for="email"><b>Adresse électronique</b></label>
			            <input type="email" class="form-control" id="email" placeholder="Votre email" name="email" required>
			            
			        </div>
			        <div class="form-group">
			            <label for="adress"><b>Adresse</b></label>
			            <input type="text" class="form-control" id="adress" placeholder="Votre adresse" name="adress" required>
			          
			        </div>
			        <div class="form-group">
			            <label for="phone"><b>Téléphone</b></label>
			            <input type="text" class="form-control" id="phone" placeholder="Votre numéro de téléphone" name="phone" pattern="[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}" required>
			           
			        </div>
			        <div class="form-row">
			            <div class="col-md-6 form-group">
			                <button type="submit" class="form-control btn btn-success">Créer compte</button>
			            </div>
			            <div class="col-md-6 form-group">
			                <a  class="form-control btn btn-info" href="${pageContext.request.contextPath}/accueil.do">Annuler</a>
			            </div>
			        </div>
					 <div>Tu as un compte ? <a href="${pageContext.request.contextPath}/connexion.do">Connectez-vous</a></div>
    			</form>
   
			</div>
			<div class="modal" tabindex="-1" id="errorModal"tabindex="-1"  role="dialog" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Erreur</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								<%
								String errorMessage = (String) session.getAttribute("errorMessage");
								if (errorMessage != null) {
								%>
								<p><%= errorMessage %></p>
								<% } %>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
							</div>
						</div>
					</div>
				</div>
			
		</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script>
  $(document).ready(function () {
    <%
      if (errorMessage != null) {
    %>
    $("#errorModal").modal("show");
    <% } %>
  });
</script>
</body>
</html>