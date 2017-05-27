<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['name']) && isset($_POST['location']) && isset($_POST['capacity'])&& isset($_POST['amenities'])&& isset($_POST['telephone'])&& isset($_POST['email'])&& isset($_POST['website'])) {
 
    $name = $_POST['name'];
    $location = $_POST['location'];
	$capacity = $_POST['capacity'];
	$amenities = $_POST['amenities'];
	$telephone = $_POST['telephone'];
    $email = $_POST['email'];
	$website = $_POST['website'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO venues(name, location, capacity, amenities, telephone, email, website) VALUES('$name', '$location', '$capacity', '$amenities', '$telephone', '$email', '$website')");
 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "venue successfully created.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
 
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>