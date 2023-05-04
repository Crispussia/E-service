<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="fr.eilco.model.Cart" %>
<%@ page import="fr.eilco.entities.FacadeClient" %>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@page import="java.text.DecimalFormat"%>
 <%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js" type="text/javascript"></script>
<script src="./js/pdf.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Validation</title>
<style>

#validation-message {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: green;
    color: white;
    padding: 20px;
    border-radius: 10px;
    display: none;
}
</style>
</head>
<body>
<%
FacadeClient client = (FacadeClient) session.getAttribute("client");
request.setAttribute("client", client);

%>
<!-- Start Main Top -->
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
    
     <!-- Start All Title Box -->
  <div class="all-title-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Enregistrement</h2>
                
            </div>
        </div>
    </div>
</div>
<!-- End All Title Box -->
<!-- Start Shop Page  -->
 <div class="shop-box-inner">
     <div class="container">
     <div class="alert alert-success" role="alert">
			 <p>Votre commande a été enregistrée avec succès !</p>
	</div>
	<div id="recap" class="row">
       
        <h2><b>Catalogue web </b> | Récapitulatif de commande</h2><br/>
	    <h3>Nom client : ${client.getNom()}</h3>
	    <br/>
	    <h3>Numéro commande : N°${NumConfirmation}</h3>
	    <br/>
	    <%
		// Récupère la date stockée dans la session
		Date date = (Date) session.getAttribute("dateCreation");
		
		// Formatte la date en utilisant le format "dd/MM/yyyy"
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(date);
		%>
		
	    <h3>Date commande :  <%= formattedDate %></h3>
	    <br/>
        <table class="table table-hover">
            <thead class="bg-info">
            <th scope="col">Nom</th>
            <th scope="col">Prix</th>
            <th scope="col">Quantité</th>
            <th scope="col">Prix total</th>
            </thead>
            <tbody>
           
	            <%
					if (session.getAttribute("previouscart")!= null) {
						
					%>
					
					<c:forEach items="${previouscart.getCart()}" var="panier" >
						 
						 <tr>
							<td>${panier.getProduitID().getNom()}</td>
							<td>${panier.getProduitID().getPrix()}</td>
							<td>${panier.getQuantite()}</td>
							<td>${panier.getQuantite()*panier.getProduitID().getPrix()}</td>
						</tr>
						
	                 </c:forEach>
					 <%}
				  %>
         
            </tbody>
           
        </table>
        <h3><b>Total :</b>${totalMontantTotal} $</h3>
    </div>
<div class="row">
    <div class="col">
        <button onclick="getPDF()" class="btn btn-block btn-success">Générer le PDF</button>
    </div>
    <div class="col">
        <a href="${pageContext.request.contextPath}/accueil.do" class="btn btn-block btn-primary">Retour à l'accueil</a>
    </div>
	</div>
		</div>
</div>
</body>
</html>