<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="fr.eilco.entities.FacadeClient" %>
 <%@ page import="fr.eilco.model.Cart" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@page import="java.text.DecimalFormat"%>
 <%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
FacadeClient client = (FacadeClient) session.getAttribute("client");
request.setAttribute("client", client);

%>

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
                        
                        
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/categories.do">Categories</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/panier.do">
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
                <h2>Confirmation</h2>
                
            </div>
        </div>
    </div>
</div>
<div class="row">
<div class="col">
        <a href="${pageContext.request.contextPath}/accueil.do" class="btn btn-block btn-primary">Annuler la commande</a>
    </div>
</div>

  <!-- Start Cart  -->
  <div class="cart-box-main">
  
    <div class="container">
      	 
		<!--  	<a href="${pageContext.request.contextPath}/confirmation.do?action=annuler" >Annuler la commande</button>
		-->
        <div class="row">
            <div class="col-sm-6 col-lg-6 mb-3">
                <div class="checkout-address">
                    <div class="title-left">
                        <h3>Adresse de Facturation</h3>
                    </div>
                    <form class="needs-validation" novalidate>
                        
                        <div class="mb-3">
                            <label for="username">Nom de l'Utilisateur *</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="username"  value="${client.getNom()}" disabled>
                              
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="email">Adresse Email *</label>
                            <input type="email" class="form-control" id="email" value="${client.getEmail()}" disabled>
                           
                        </div>
                        <div class="mb-3">
                            <label for="address">Address de livraison *</label>
                            <input type="text" class="form-control" id="address" value="${client.getAdresse()}" disabled>
                            
                        </div>
                       
                        <hr class="mb-4">
                        <div class="title"> <span>Payment</span> </div>
                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                                <label class="custom-control-label" for="credit">Credit card</label>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="cc-name">Name on card</label>
                                <input type="text" class="form-control" id="cc-name" value="${client.getNom()}" disabled> <small class="text-muted">Full name as displayed on card</small>
                                <div class="invalid-feedback"> Nom sur la carte</div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="cc-number">Numero de la carte</label>
                                <input type="text" class="form-control" id="cc-number" value="7253 3256 7895 1245" disabled>
                                <div class="invalid-feedback"> Credit card number is required </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 mb-3">
                                <label for="cc-expiration">Date d'expiration</label>
                                <input type="text" class="form-control" id="cc-expiration" value="11/50" disabled>
                                <div class="invalid-feedback"> Date d'expiration required </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="cc-expiration">CVV</label>
                                <input type="text" class="form-control" id="cc-cvv" value="545" disabled>
                                <div class="invalid-feedback"> Security code required </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <div class="payment-icon">
                                    <ul>
                                        <li><img class="img-fluid" src="images/payment-icon/1.png" alt=""></li>
                                        <li><img class="img-fluid" src="images/payment-icon/2.png" alt=""></li>
                                        <li><img class="img-fluid" src="images/payment-icon/3.png" alt=""></li>
                                        <li><img class="img-fluid" src="images/payment-icon/5.png" alt=""></li>
                                        <li><img class="img-fluid" src="images/payment-icon/7.png" alt=""></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <hr class="mb-1"> 
                         
                        </form>
                </div>
            </div>
            <div class="col-sm-6 col-lg-6 mb-3">
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <div class="shipping-method-box">
                            <div class="title-left">
                                <h3>Mode de livraison</h3>
                            </div>
                            <div class="mb-4">
                                <div class="custom-control custom-radio">
                                    <input id="shippingOption1" name="shipping-option" class="custom-control-input" checked="checked" type="radio">
                                    <label class="custom-control-label" for="shippingOption1">Livraison Standard</label> <span class="float-right font-weight-bold">FREE</span> </div>
                                <div class="ml-4 mb-2 small">(3-7  jours ouvrables)</div>
                                <div class="custom-control custom-radio">
                                    <input id="shippingOption2" name="shipping-option" class="custom-control-input" type="radio">
                                    <label class="custom-control-label" for="shippingOption2">Livraison express</label> <span class="float-right font-weight-bold">$10.00</span> </div>
                                <div class="ml-4 mb-2 small">(2-4  jours ouvrables)</div>
                                <div class="custom-control custom-radio">
                                    <input id="shippingOption3" name="shipping-option" class="custom-control-input" type="radio">
                                    <label class="custom-control-label" for="shippingOption3">Jour ouvrable suivant</label> <span class="float-right font-weight-bold">$20.00</span> </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 col-lg-12">
                        <div class="odr-box">
                            <div class="title-left">
                                <h3>Panier </h3>
                            </div>
                            <div class="rounded p-2 bg-light">
                            
                             <%
								if (session.getAttribute("cart")!= null) {
									
								%>
								
								<c:forEach items="${cart.getCart()}" var="panier" >
									 <div class="media mb-2 border-bottom">
	                                    <div class="media-body"> <a href="#"> ${panier.getProduitID().getNom()}</a>
	                                        <div class="small text-muted">Prix: ${panier.getProduitID().getPrix()}<span class="mx-2">|</span> Quantité: ${panier.getQuantite()} <span class="mx-2">|</span> Prixtotal: ${panier.getQuantite()*panier.getProduitID().getPrix()}</div>
	                                    </div>
                               		 </div>
                               	 </c:forEach>
								 <%}
							  %>
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 col-lg-12">
                        <div class="order-box">
                            <div class="title-left">
                                <h3>Ta commande</h3>
                            </div>
                            <div class="d-flex">
                                <div class="font-weight-bold">Produit</div>
                                <div class="ml-auto font-weight-bold">Total</div>
                            </div>
                            <hr class="my-1">
                            <div class="d-flex">
                                <h4>Prix des articles</h4>
                                <div class="ml-auto font-weight-bold"> $ ${(total>0)?dcf.format(total):0}  </div>
                            </div>
                            
                            <div class="d-flex">
                                <h4>Taxes</h4>
                                <div class="ml-auto font-weight-bold"> $ 2 </div>
                            </div>
                            <div class="d-flex">
                                <h4>Coût de livraison</h4>
                                <div class="ml-auto font-weight-bold" id="ship"> $ 0</div>
                            </div>
                            <hr>
                            <div class="d-flex gr-total">
                                <h5>Total</h5>
                                <div class="ml-auto h5" id="all_total"> $ ${(total>0)?dcf.format(total +2+ shipping):0}</div>
                            </div>
                            <hr> </div>
                    </div>
                    
                    <div class="col-12 d-flex shopping-box"> <a href="${pageContext.request.contextPath}/enregistrement.do" class="ml-auto btn hvr-hover">Passer la commande</a> </div>
                </div>
            </div>
        </div>

    </div>
	   
</div>
<!-- End Cart -->
<!-- End All Title Box -->

<script src="js/script.js"></script>
</body>
</html>