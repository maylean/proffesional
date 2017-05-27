<?php
 
/*
 * Following code will update a product information
 * A product is identified by product id (pid)
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['venue_id']) && isset($_POST['name']) && isset($_POST['location']) && isset($_POST['capacity'])&& isset($_POST['amenities'])&& isset($_POST['telephone'])&& isset($_POST['email'])&& isset($_POST['website'])) {
 
    $venue_id = $_POST['venue_id'];
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
 
    // mysql update row with matched pid
    $result = mysql_query("UPDATE venues SET name = '$name', location = '$location', capacity = '$capacity', amenities = '$amenities', telephone = '$telephone', email = '$email', website = '$website' WHERE venue_id = '$venue_id'");
 
    // check if row inserted or not
    if ($result) {
        // successfully updated
        $response["success"] = 1;
        $response["message"] = "venue successfully updated.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
 
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>