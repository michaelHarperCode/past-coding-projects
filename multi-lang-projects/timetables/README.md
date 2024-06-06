# Timetables (Frequency-finding)
### A way to find line frequencies, either in real life or in simulation

## Background
One of my most played games on PC is Transport Fever 2. In the game, you run a transport company shipping goods and delivering people across
cities and industries. I play with a variety of custom mods, one of which being the [Timetables](https://steamcommunity.com/workshop/filedetails/?id=2408373260) mod by Celmi.
This mod allows the player to manually set arrival/departure times for logistics lines, as well as set unbunching times at each station. My play style
is geared to the latter, so I would calculate the journey times Timetables would find, perform the relevant conversions, then divide the time by the number
of vehicles on the line.

I would later trust OpenAI's ChatGPT to do this, but I discovered that sometimes the AI wouldn't calculate numbers correctly, or perform an incorrect action.
In response, this program was born.

## What it does
Timetables is split across two main project files, createTimetable and updateTimetable.

### createTimetable
In createTimetable.php, the user inputs the number of vehicles on their transit route, the journey times (in mm:ss format) between stations on the line, and their chosen delineator method when inputing the aforementioned times. After submission, the PHP program will determine the unbunch time. Frequency is calculated by the following equation:
`$frequency = $timeSeconds / $vehNum`, or by dividing the total number of seconds by the number of vehicles. 
As an example: If the total trip time was 180 seconds and there were three vehicles on the line, the frequency would by 1 minute.

### updateTimetable
In updateTimetable.php, the user inputs the number of total vehicles on an already existing line, the frequency of that line, and the number of total vehicles that will be on the line in an updated timetable. After submission, the PHP program will take the line's existing frequency, and update it given the new number of vehicles. As a precaution, the program will return an error if more than one time is inputted.

## What this is useful for
This program's primary purpose is to calculate and update route frequencies in Transport Fever 2, in conjunction with Celmi's Timetables mod. But this program may
also be used for other matters related to calculating route frequencies.
