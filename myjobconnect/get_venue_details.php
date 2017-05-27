<?php
 
/*
 * Following code will get single product details
 * A product is identified by product id (pid)
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// check for post data
if (isset($_GET["venue_id"])) {
    $venue_id = $_GET['venue_id'];
 
    // get a venue from venues table
    $result = mysql_query("SELECT *FROM venues WHERE venue_id = $venue_id");
 
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
 
            $result = mysql_fetch_array($result);
 
            $venue = array();
            $venue["venue_id"] = $result["venue_id"];
            $venue["name"] = $result["name"];
            $venue["location"] = $result["location"];
            $venue["capacity"] = $result["capacity"];
            $venue["amenities"] = $result["amenities"];
            $venue["telephone"] = $result["telephone"];
			$venue["email"] = $result["email"];
			$venue["website"] = $result["website"];
            // success
            $response["success"] = 1;
 
            // user node
            $response["venue"] = array();
 
            array_push($response["venue"], $venue);
 
            // echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No venue found";
 
            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No venue found";
 
        // echo no users JSON
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