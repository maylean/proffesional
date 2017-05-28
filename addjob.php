<?php

/*
Our "config.inc.php" file connects to database every time we include or require
it within a php script.  Since we want this script to add a new user to our db,
we will be talking with our database, and therefore,
let's require the connection to happen:
*/
require("config.inc.php");

//if posted data is not empty
if (!empty($_POST)) {
   
    if (empty($_POST['job']) || empty($_POST['jobdescription'])|| empty($_POST['skills'])|| empty($_POST['amount'])) {
        
        
        // Create some data that will be the JSON response 
        $response["success"] = 0;
        $response["message"] = "Please fill all fields.";
        
        //die will kill the page and not execute any code below, it will also
        //display the parameter... in this case the JSON data our Android
        //app will parse
        die(json_encode($response));
    }
    
    //if the page hasn't died, we will check with our database to see if there is
    //already a user with the username specificed in the form.  ":user" is just
    //a blank variable that we will change before we execute the query.  We
    //do it this way to increase security, and defend against sql injections
   /*$query        = " SELECT 1 FROM jobs WHERE job = :job";
    //now lets update what :user should be
    $query_params = array(
        ':job' => $_POST['job']
    );
    
    //Now let's make run the query:
    try {
        // These two statements run the query against your database table. 
        $stmt   = $db->prepare($query);
        $result = $stmt->execute($query_params);
    }
    catch (PDOException $ex) {
        // For testing, you could use a die and message. 
        //die("Failed to run query: " . $ex->getMessage());
        
        //or just use this use this one to product JSON data:
        $response["success"] = 0;
        $response["message"] = "Database Error1. Please Try Again!";
        die(json_encode($response));
    }
    
    //fetch is an array of returned data.  If any data is returned,
    //we know that the username is already in use, so we murder our
    //page
    $row = $stmt->fetch();
   
   
   */
    //If we have made it here without dying, then we are in the clear to 
    //create a new user.  Let's setup our new query to create a user.  
    //Again, to protect against sql injects, user tokens such as :user and :pass
    $query = "INSERT INTO jobs ( job, jobdescription,skills,amount ) VALUES ( :job, :jobdescription,:skills,:amount) ";
    
    //Again, we need to update our tokens with the actual data:
    $query_params = array(
        ':job' => $_POST['job'],
        ':jobdescription' => $_POST['jobdescription'],
		':skills' => $_POST['skills'],
        ':amount' => $_POST['amount']
        
    );
    
    //time to run our query, and create the user
    try {
        $stmt   = $db->prepare($query);
        $result = $stmt->execute($query_params);
    }
    catch (PDOException $ex) {
        // For testing, you could use a die and message. 
        die("Failed to run query: " . $ex->getMessage());
        
        //or just use this use this one:
        $response["success"] = 0;
        $response["message"] = "Database Error2. Please Try Again!";
        die(json_encode($response));
    }
    
    //If we have made it this far without dying, we have successfully added
    //a new user to our database.  We could do a few things here, such as 
    //redirect to the login page.  Instead we are going to echo out some
    //json data that will be read by the Android application, which will login
    //the user (or redirect to a different activity, I'm not sure yet..)
    $response["success"] = 1;
    $response["message"] = "Account created";
    echo json_encode($response);
    
    //for a php webservice you could do a simple redirect and die.
    //header("Location: login.php"); 
    //die("Redirecting to login.php");
    
    
} else {
?>
	
	<h1>Register</h1> 
	<form action="addjob.php" method="post"> 
	    Job:<br /> 
	    <input type="text" name="job" value="" /> 
	    <br /><br /> 
	    Job description:<br /> 
	    <input type="text" name="jobdescription" value="" /> 
	    <br /><br /> 
	    
        skill:<br /> 
	    <input type="text" name="skills" value="" /> 
	    <br /><br /> 
	    Amount:<br /> 
	    <input type="number" name="amount" value="" /> 
	           
	    <br /><br /> 
	    
	    <input type="submit" value="ADD" /> 
	</form>
	<?php
}

?>
