<html lang="EN">
<head>
    <title>
        Timetable Generator
    </title>
</head>
<body>
<h1>Timetable Generator</h1>
<h2>Determine route frequency given your point-to-point travel times</h2>
<a href="index.php"><button>Home</button></a>
<br>
<form action="createTimetable.php" method="post">
    <h3>Step 1: How many vehicles are on the route?</h3>
    Enter the number of vehicles that will be traveling on the route. <br>
    <label>Number of vehicles:
        <input type="number" id="vehNum" name="vehNum" required>
    </label>
    <h3>Step 2: Input the travel times between stops in mm:ss format.</h3>
    Enter the travel times between each stop in mm:ss format, starting and ending at the same stop. <br>
    <label>Travel times (in mm:ss format):
        <input type="text" id="times" name="times" multiple required>
    </label>
    <br>
    <h3>Step 3: Choose your separator method.</h3>
    Choose how you separated the travel times you gave in Step 2. <br>
    <input type="radio" id="comma" name="separator" value="," required>
    <label for="comma">Comma (,)</label>
    <input type="radio" id="commaSpace" name="separator" value=", ">
    <label for="commaSpace">Comma Space (, )</label>
    <input type="radio" id="space" name="separator" value=" ">
    <label for="space">Space ( )</label>
    <input type="radio" id="custom" name="separator" value="other">
    <label for="custom">Other
        <input type="text" name="custom_separator" placeholder="Choose custom separator..." id="custom-input">
    </label>
    <br><input type="submit" name="submit">
</form>
</body>
</html>
<?php
if(!empty($_POST)) {
    $timeSeconds = 0;
    $frequency = 0;
    if($_POST['separator'] == "other"){
        $times = explode($_POST['custom_separator'], $_POST['times']);
    } else {
        $times = explode($_POST['separator'], $_POST['times']);
    }
    foreach ($times as $time) {
        $time = explode(':', $time);
        if ($time[0] == ":"){
            $time[0] = 0;
        }
        $timeSeconds = $timeSeconds + ((int)$time[0] * 60) + $time[1];
    }
    $frequency = $timeSeconds / $_POST['vehNum'];
    //TODO: Get rid of the deprecated warning here
    $frequencyMinutes = $frequency / 60.0;
    $frequencyMinutes = floor($frequencyMinutes);
    $frequencySeconds = round(fmod($frequency, 60.0));
    echo "Vehicles on this line should run every <b>" . number_format($frequencyMinutes) . " </b> minutes and <b>" . $frequencySeconds . " </b> seconds.";
} else {
    //wait until user submits form to continue
}
?>

