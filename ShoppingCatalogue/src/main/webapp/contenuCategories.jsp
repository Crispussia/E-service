<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.eilco.model.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
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
                        
                        
                        <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/categories.do">Categories</a></li>
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

<c:if test="${not empty param.cat}">
<%
String id = (String)request.getAttribute("cat");

if (id!= null && !id.equals("")) {
	String nom_cat = (String) request.getAttribute("cat_nom");	%>

	<div class="all-title-box">
	   <div class="container">
	       <div class="row">
	           <div class="col-lg-12">
	               <h2><%= nom_cat %>/Liste des Produits</h2>                    
	           </div>
	       </div>
	   </div>
	</div>
	
	<!-- Start Shop Page  -->
    <div class="shop-box-inner">
        <div class="container">
  
            <div class="row">
                <div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
                  <%

					if (session.getAttribute("produits") != null) {%>
  
						<c:if test="${empty produits}">  
						    Aucun produit n'a été trouvé pour cette catégorie.
					     </c:if>
   
					
                  
                    <div class="right-product-box">
                        <div class="product-item-filter row">
                            <div class="col-12 col-sm-8 text-center text-sm-left">
                              
                            </div>
                            <div class="col-12 col-sm-4 text-center text-sm-right">
                                <ul class="nav nav-tabs ml-auto">
                                    <li>
                                        <a class="nav-link active" href="#grid-view" data-toggle="tab"> <i class="fa fa-th"></i> </a>
                                    </li>
                                    <li>
                                        <a class="nav-link" href="#list-view" data-toggle="tab"> <i class="fa fa-list-ul"></i> </a>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div class="product-categorie-box">
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane fade show active" id="grid-view">
                                    <div class="row">
                                          
										<c:forEach items="${produits}" var="prod" >
										  <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
										      <div class="products-single fix">
										          <div class="box-img-hover">
										              <div class="type-lb">
										                  <p class="sale">Sale</p>
										              </div>
										              <img src=${prod.getImage()} class="img-fluid" alt="Image" style="height : 50vh;">
										              <div class="mask-icon">
										                
										                  <a class="cart" href="${pageContext.request.contextPath}/categories.do?cat=${prod.getCategorieID().getId()}&produit=${prod.getId()}">Add to Cart</a>
									
										              </div>
										          </div>
										          <div class="why-text">
										              <h4> ${prod.getNom()}</h4>
										              <h5> $ ${prod.getPrix()} </h5>
										          </div>
										      </div>
										  </div>
									
										    
										</c:forEach>
                                         
                                       
                                       
                                    </div>
                                </div>
                                <div role="tabpanel" class="tab-pane fade" id="list-view">
                                
                                
                                <c:forEach items="${produits}" var="prod" >
									<div class="list-view-box">
                                        <div class="row">
                                            <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                                <div class="products-single fix">
                                                    <div class="box-img-hover">
                                                        <div class="type-lb">
                                                            <p class="new">Sale</p>
                                                        </div>
                                                        <img src="${prod.getImage()}" class="img-fluid" alt="Image" style="height : 50vh;">
                                                       
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
                                                <div class="why-text full-width">
                                                    <h4>${prod.getNom()}</h4>
                                                    <h5> ${prod.getPrix()}</h5>
                                                    <p>${prod.getDescription()}</p>
                                                    <a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do?cat=${prod.getCategorieID().getId()}&produit=${prod.getId()}">Add to Cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
									
									
								</c:forEach>
                                   
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                    
                    
                </div>
				<div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
                    <div class="product-categori">
                        <div class="filter-sidebar-left">
                            <div class="title-left">
                                <h3>Categories</h3>
                            </div>
                            <div class="list-group list-group-collapse list-group-sm list-group-tree" id="list-group-men" data-children=".sub-men">
                            	<c:if test="${not empty categories}">
								  <c:forEach items="${categories}" var="cat">
								    <c:choose>
								      <c:when test="${cat.getNom() == nom_cat}">
								         <a href="${pageContext.request.contextPath}/categories.do?cat=${cat.getId()}"  style="font-weight: bold;">${cat.getNom()} </a>
								      </c:when>
								      <c:otherwise>
								        <a href="${pageContext.request.contextPath}/categories.do?cat=${cat.getId()}" >${cat.getNom()}</a>
								      </c:otherwise>
								    </c:choose>
								  </c:forEach>
								</c:if>
							                    
                               
                               
                            </div>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Shop Page -->
	
	
<% }

%>


</c:if>
<c:if test="${empty param.cat}">
  <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">s
            <div class="row">
                <div class="col-lg-12">
                    <h2>Catégories</h2>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box --> 
  <!-- Start Categories  -->
    <div class="categories-shop">
        <div class="container">
            <div class="row">
            	<c:if test="${not empty categories}">
				  <c:forEach items="${categories}" var="cat">
				    <c:if test="${cat.nom == 'Livres'}">
					     <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
		                    <div class="shop-cat-box">
		                        <img class="img-fluid" src="images/banner-03.jpg" alt="" style="height : 50vh;"/>
		                        <a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do?cat=${cat.getId()}">${cat.getNom()}</a>
		                    </div>
		                </div>
				    </c:if>
				    <c:if test="${cat.nom == 'DVDs'}">
					     <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
		                    <div class="shop-cat-box">
		                        <img class="img-fluid" src="images/banner-01.jpg" alt="" style="height : 50vh;"/>
		                        <a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do?cat=${cat.getId()}">${cat.getNom()}</a>
		                    </div>
		                </div>
				    </c:if>
				    <c:if test="${cat.nom == 'CDs'}">
					     <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
		                    <div class="shop-cat-box">
		                        <img class="img-fluid" src="images/cd.jpg" alt="" style="height : 50vh;"/>
		                        <a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do?cat=${cat.getId()}">${cat.getNom()}</a>
		                    </div>
		                </div>
				    </c:if>
				    
				  </c:forEach>
				</c:if>
            	
            </div>
        </div>
    </div>
      
    <!-- End Categories -->

</c:if> 

</body>
</html>