let shippingOption1 = document.getElementById("shippingOption1");
let shippingOption2 = document.getElementById("shippingOption2");
let shippingOption3 = document.getElementById("shippingOption3");
let shipping = document.getElementById("all_total").textContent;
shippingOption1.addEventListener("change", function() {
    if(shippingOption1.checked){
       $.ajax({
		    type: "POST",
		    url: "http://localhost:8080/ShoppingCatalogue/confirmation.do",
		    data: { 
		        shippingOption:"shippingOption1"
		    },
		    success: function(response) {
		       let div = document.getElementById("ship");
		       var temp="$ "+ 0;
    			div.textContent = temp ;
    			let value =shipping.split(" ")[2].replace(",",".");
    			console.log(value);
    			console.log(value+1);
    			let currentShipping = parseFloat(value);
    			console.log(parseFloat(value));
    		
		        //let newShipping = currentShipping.valueOf();
		        let newShipping =Math.fround(currentShipping).toFixed(2)
		        console.log(newShipping)
		        document.getElementById("all_total").textContent = newShipping;
		    }
		});
    }
});

shippingOption2.addEventListener("change", function() {
    if(shippingOption2.checked){
        $.ajax({
		    type: "POST",
		    url: "http://localhost:8080/ShoppingCatalogue/confirmation.do",
		    data: { 
		        shippingOption:"shippingOption2"
		    },
		    success: function(response) {
		        let div = document.getElementById("ship");
		         var temp="$ "+10;
    			 div.textContent = temp ;
    			 let value =shipping.split(" ")[2].replace(",",".");
    			 console.log(value);
    			 
    			 let currentShipping = parseFloat(value);
    			 console.log(parseFloat(value));
		         //let newShipping = currentShipping.valueOf() + parseFloat(10).valueOf();
		          let newShipping =Math.fround(currentShipping + 10.0).toFixed(2);
		        console.log(newShipping)
		        document.getElementById("all_total").textContent = newShipping;
		        //shipping.textContent = newShipping;*/
		    }
		});
    }
});

shippingOption3.addEventListener("change", function() {
    if(shippingOption3.checked){
        $.ajax({
		    type: "POST",
		    url: "http://localhost:8080/ShoppingCatalogue/confirmation.do",
		    data: { 
		        shippingOption: "shippingOption3"
		    },
		    success: function(response) {
		         let div = document.getElementById("ship");
		         var temp="$ "+20;
    			 div.textContent = temp ;
    			 let value =shipping.split(" ")[2].replace(",",".");
    			 console.log(value);
    			
    			 let currentShipping = parseFloat(value);
    			 console.log(parseFloat(value));
		         //let newShipping = currentShipping.valueOf() + parseFloat(20.0).valueOf();
		         let newShipping =Math.fround(currentShipping + 20.0).toFixed(2);
		         console.log(newShipping)
		         document.getElementById("all_total").textContent = newShipping;
		        //shipping.textContent = newShipping;*/
		    }
		});
    }
});
