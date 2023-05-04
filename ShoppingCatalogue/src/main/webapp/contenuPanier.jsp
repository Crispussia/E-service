<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@page import="java.text.DecimalFormat"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="fr.eilco.model.Cart" %>
 <%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panier</title>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
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
                        <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/panier.do">
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
                <h2>Panier</h2>
                
            </div>
        </div>
    </div>
</div>
<!-- End All Title Box -->
  
  
 
<!-- Start Cart  -->
<div class="cart-box-main">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <%
				if (session.getAttribute("cart")!= null) {
						Cart test = (Cart) session.getAttribute("cart");
					if(test.getCart().isEmpty()){%>
						<div class="alert alert-danger" role="alert">
				        Panier vide !
						</div>
				 <%}else{%>
                
                <div class="table-main table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Images</th>
                                <th>Nom du produit</th>
                                <th>Categorie</th>
                                <th>Prix</th>
                                <th>Quantité</th>
                                <th>Total</th>
                                <th>Supprimer</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach items="${cart}" var="panier" >
		
                            <tr>
                                <td class="thumbnail-img">
	                                    <a href="#">
			                                <img src="${panier.getProduitID().getImage()}" class="img-fluid" alt="Image"  />
				                        </a>
	                             </td>
	                             <td class="name-pr">
	                                    <a href="#">
	                                ${panier.getProduitID().getNom()}
	                           		 </a>
                                </td>
                                <td>
									${panier.getProduitID().getCategorieID().getNom()}
                                </td>
                                <td class="price-pr">
                                    <p>${panier.getProduitID().getPrix()}</p>
                                </td>
                                <td >
									<a class="btn btn-sm btn-incre" href="${pageContext.request.contextPath}/panier.do?action=inc&nom_prod=${panier.getProduitID().getNom()}"><i class="fas fa-plus-square"></i></a>
										<input type="text" name="quantity" value="${panier.getQuantite()}" readonly > 		
								    <a class="btn btn-sm btn-decre" href="${pageContext.request.contextPath}/panier.do?action=dec&nom_prod=${panier.getProduitID().getNom()}"><i class="fas fa-minus-square"></i></a>
                                </td>
                                <td class="total-pr">
                                    <p>${panier.getProduitID().getPrix()*panier.getQuantite()}</p>
                                </td>
                                <td class="remove-pr">
                                    <a href="${pageContext.request.contextPath}/panier.do?action=remove&nom_prod=${panier.getProduitID().getNom()}">
                                <i class="fas fa-times"></i>
                            </a>
                                </td>
                            </tr>
                           </c:forEach>
                        </tbody>
                    </table>
                </div>
                  <div class="row my-5">
		            <div class="col-lg-6 col-sm-6">
		                <div class="coupon-box">
		                    <div class="input-group input-group-sm">
		                      
		                        <div class="input-group-append">
		                            <a class="ml-3 btn btn-lg " href="${pageContext.request.contextPath}/categories.do">Continuer l'achat</a>
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <div class="col-lg-6 col-sm-6">
		                <div class="input-group-append">
		                    <a class="ml-3 btn btn-lg " href="${pageContext.request.contextPath}/panier.do?action=vider">Vider le panier</a>
		                </div>
		            </div>
		        </div>
		        
		          <div class="row my-5">
		            <div class="col-lg-8 col-sm-12"></div>
		            <div class="col-lg-4 col-sm-12">
		                <div class="order-box">
		                    <h3>Resumé panier</h3>
		                    <div class="d-flex">
		                        <h4>Prix Total des articles</h4>
		                        <div class="ml-auto font-weight-bold"> Total Price: $ ${(total>0)?dcf.format(total):0}  </div>
		                    </div>
		                   
		                    <div class="d-flex">
		                        <h4>Taxe</h4>
		                        <div class="ml-auto font-weight-bold"> $ 2 </div>
		                    </div>
		                    <div class="d-flex">
		                        <h4>Coût de la livraison</h4>
		                        <div class="ml-auto font-weight-bold"> Free </div>
		                    </div>
		                    <hr>
		                    <div class="d-flex gr-total">
		                        <h5>Prix total</h5>
		                        <div class="ml-auto h5"> Total Price: $ ${(total>0)?dcf.format(total +2):0}  </div>
		                    </div>
		                    <hr> </div>
		            </div>
		            <div class="col-12 d-flex shopping-box">
		            <%
					if (session.getAttribute("client")== null) {%>
		            <a class="ml-auto btn hvr-hover" href="${pageContext.request.contextPath}/connexion.do">            
		                Terminer les achats
		            </a>
		        	<%}else{%>
		        	<a class="ml-auto btn hvr-hover" href="${pageContext.request.contextPath}/confirmation.do">            
		                Terminer les achats
		            </a><%}%>
		          
		            </div>
		        </div>
		        
               <%}
	
	
	
			}else{%>
				<div class="alert alert-danger" role="alert">
		                          Panier vide !
		        </div>
			<%}%> 
            </div>
        </div>
      
     
      
    </div>
</div>
<!-- End Cart -->
<script src="../assets/js/script.js"></script>
</body>
</html>
