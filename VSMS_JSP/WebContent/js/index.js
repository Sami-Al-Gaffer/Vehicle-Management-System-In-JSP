 function validateForm() {
	        var em = document.registration.textEmail.value;
	        var pw = document.registration.password.value;
	        var email = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	        
	        if(em == "" || pw == ""){
	            alert("Please Enter Email and Passowrd...");
	            return false;
	        }
	        else if (!email.test(em)) {
	            alert('Please provide a valid email address');
	            em.focus;
	            return false;
	         }
	        else if ((pw.length < 4) || (pw.length > 8))
	        {
	        alert("Your Password must be 4 to 8 Character");
	        
	        return false;
	        }
	        else{
	        	return true;
	        }
	  }
 


