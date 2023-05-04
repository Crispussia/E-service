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
                    <a class="navbar-brand" href="accueil.do"><h2>MaBoutique</h2></a>
                </div>
                <!-- End Header Navigation -->

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                        <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/accueil.do">Accueil</a></li>
                        
                        
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
                             <!--  -->
                        </a></li>
                    </ul>
                </div>
                
             </div>  
               
        </nav>
        <!-- End Navigation -->
    </header>
  
<% 
if ((session.getAttribute("client")== null)) {%>
	


    <!-- Start Slider -->
    <div id="slides-shop" class="cover-slides">
        <ul class="slides-container">
            <li class="text-center">
                <img src="images/banner-01.jpg" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles<br> pointus et autres mordus de musique ou de jeux vidéo!</p>
                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
                        </div>
                    </div>
                </div>
            </li>
            <li class="text-center">
                <img src="images/banner-02.jpg" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles <br> pointus et autres mordus de musique ou de jeux vidéo!</p>
                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
                        </div>
                    </div>
                </div>
            </li>
            <li class="text-center">
                <img src="images/banner-03.jpg" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles <br>  pointus et autres mordus de musique ou de jeux vidéo!</p>
                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
        <div class="slides-navigation">
            <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
            <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
        </div>
    </div>
    <!-- End Slider -->

<%}else{
	
	if((session.getAttribute("cart")!=null)){
		Cart test = (Cart) session.getAttribute("cart");
		if(test.getCart().isEmpty()){%>
			
			
			    <!-- Start Slider -->
			    <div id="slides-shop" class="cover-slides">
			        <ul class="slides-container">
			            <li class="text-center">
			                <img src="images/banner-01.jpg" alt="">
			                <div class="container">
			                    <div class="row">
			                        <div class="col-md-12">
			                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
			                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles<br> pointus et autres mordus de musique ou de jeux vidéo!</p>
			                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
			                        </div>
			                    </div>
			                </div>
			            </li>
			            <li class="text-center">
			                <img src="images/banner-02.jpg" alt="">
			                <div class="container">
			                    <div class="row">
			                        <div class="col-md-12">
			                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
			                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles <br> pointus et autres mordus de musique ou de jeux vidéo!</p>
			                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
			                        </div>
			                    </div>
			                </div>
			            </li>
			            <li class="text-center">
			                <img src="images/banner-03.jpg" alt="">
			                <div class="container">
			                    <div class="row">
			                        <div class="col-md-12">
			                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
			                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles <br>  pointus et autres mordus de musique ou de jeux vidéo!</p>
			                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
			                        </div>
			                    </div>
			                </div>
			            </li>
			        </ul>
			        <div class="slides-navigation">
			            <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
			            <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
			        </div>
			    </div>
			    <!-- End Slider -->

		<%}
		else{%>
		
		
			
			    <!-- Start Slider -->
			    <div id="slides-shop" class="cover-slides">
			        <ul class="slides-container">
			            <li class="text-center">
			                <img src="images/banner-01.jpg" alt="">
			                <div class="container">
			                    <div class="row">
			                        <div class="col-md-12">
			                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
			                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles<br> pointus et autres mordus de musique ou de jeux vidéo!</p>
			                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a>
			                            <a class="btn hvr-hover" href="${pageContext.request.contextPath}/confirmation.do">  Terminer les achats</a>
			                            </p>
			                        </div>
			                    </div>
			                </div>
			            </li>
			            <li class="text-center">
			                <img src="images/banner-02.jpg" alt="">
			                <div class="container">
			                    <div class="row">
			                        <div class="col-md-12">
			                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
			                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles <br> pointus et autres mordus de musique ou de jeux vidéo!</p>
			                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Continuez l'achat</a>
			                            <a class="btn hvr-hover" href="${pageContext.request.contextPath}/confirmation.do">  Terminer les achats</a>
			                            </p>
			                        </div>
			                    </div>
			                </div>
			            </li>
			            <li class="text-center">
			                <img src="images/banner-03.jpg" alt="">
			                <div class="container">
			                    <div class="row">
			                        <div class="col-md-12">
			                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
			                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles <br>  pointus et autres mordus de musique ou de jeux vidéo!</p>
			                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Continuez l'achat</a></p>
			                            <a class="btn hvr-hover" href="${pageContext.request.contextPath}/confirmation.do">  Terminer les achats</a>
			                        </div>
			                    </div>
			                </div>
			            </li>
			        </ul>
			        <div class="slides-navigation">
			            <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
			            <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
			        </div>
			    </div>
			    <!-- End Slider -->
		
		<%} 
	}
	else{%>
		
	  
	
	    <!-- Start Slider -->
	    <div id="slides-shop" class="cover-slides">
	        <ul class="slides-container">
	            <li class="text-center">
	                <img src="images/banner-01.jpg" alt="">
	                <div class="container">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
	                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles<br> pointus et autres mordus de musique ou de jeux vidéo!</p>
	                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
	                        </div>
	                    </div>
	                </div>
	            </li>
	            <li class="text-center">
	                <img src="images/banner-02.jpg" alt="">
	                <div class="container">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
	                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles <br> pointus et autres mordus de musique ou de jeux vidéo!</p>
	                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
	                        </div>
	                    </div>
	                </div>
	            </li>
	            <li class="text-center">
	                <img src="images/banner-03.jpg" alt="">
	                <div class="container">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <h1 class="m-b-20"><strong>Bienvenue dans <br> Ma Boutique</strong></h1>
	                            <p class="m-b-40">Avec plus de quatre millions de références, notre sélection <br> a de quoi satisfaire les lecteurs les plus assidus, cinéphiles <br>  pointus et autres mordus de musique ou de jeux vidéo!</p>
	                            <p><a class="btn hvr-hover" href="${pageContext.request.contextPath}/categories.do">Commencez votre achat</a></p>
	                        </div>
	                    </div>
	                </div>
	            </li>
	        </ul>
	        <div class="slides-navigation">
	            <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
	            <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
	        </div>
	    </div>
	    <!-- End Slider -->

	
	<%} 

}%>
 
</body>
</html>