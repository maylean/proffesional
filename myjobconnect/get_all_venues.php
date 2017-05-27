<?php
 
/*
 * Following code will list all the products
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// get all products from products table
$result = mysql_query("SELECT *FROM venues") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["venues"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $venue = array();
        $venue["venue_id"] = $row["venue_id"];
        $venue["name"] = $row["name"];
        $venue["location"] = $row["location"];
        $venue["capacity"] = $row["capacity"];
        $venue["amenities"] = $row["amenities"];
		$venue["telephone"] = $row["telephone"];
		$venue["email"] = $row["email"];
		$venue["website"] = $row["website"];
 
        // push single venue into final response array
        array_push($response["venues"], $venue);
    }
    // success
    $response["success"] = 1;
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No venues found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>