<html lang="en">
<head>
    <title>Update Timetable</title>
</head>
<body>
<h1>Update Timetable</h1>
<h2>Change the number of vehicles on the line.</h2>
<a href="index.php"><button>Home</button></a>

<br>
<form action="updateTimetable.php" method="post">
    <h3>Step 1: How many vehicles are currently on the route?</h3>
    Enter the number of vehicles that are currently on the route. <br>
    <label>Number of vehicles:
        <input type="number" id="vehNum" name="vehNum" required>
    </label>
    <h3>Step 2: What's the current frequency of the route?</h3>
    Enter the current unbunch time for the line. <br>
    <label>Unbunch time (in mm:ss format):
        <input type="text" id="unbunchTime" name="unbunchTime" multiple required>
    </label>
    <br>
    <h3>Step 3: How many vehicles will be on the route?</h3>
    Enter the future number of vehicles on the line. If increasing the number of vehicles, remember to include
    the current vehicle count in your total.<br>
    <label>Expected number of vehicles:
        <input type="number" id="futureVehNum" name="futureVehNum" required>
    </label>
    <br>
    <input type="submit" name="submit">
</form>
</body>
</html>
<?php
if(!empty($_POST)) {
    $timeSeconds = 0;
    $frequency = 0.0;
    $time = explode(':', $_POST['unbunchTime']);
    if(count($time) !== 2 || !is_numeric($time[0]) || !is_numeric($time[1])){
        echo "<b>Error on Step 2: </b> You entered more than one time or the time format was invalid.";
        exit;
    }
    $timeSeconds = ($time[0] * 60) + $time[1];
    $timeSeconds = $timeSeconds * $_POST['vehNum'];
    $frequency = $timeSeconds / $_POST['futureVehNum'];
    $frequencyMinutes = floor($frequency / 60.0);
    $frequencySeconds = round(fmod($frequency, 60.0));
    echo "Vehicles on this line should run every <b>" . number_format($frequencyMinutes) . " </b> minutes and <b>" . $frequencySeconds . " </b> seconds.";
} else {
    //wait until user submits form to continue
}
?>
