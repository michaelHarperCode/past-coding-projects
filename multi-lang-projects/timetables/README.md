# Timetables (Frequency-finding)
### A way to find line frequencies, either in real life or in simulation

## Background
One of my most played games on the PC is Transport Fever 2. In the game, you run a transport company shipping goods and delivering people across
cities and industries. I play with a variety of custom mods, one of which being the [Timetables](https://steamcommunity.com/workshop/filedetails/?id=2408373260) mod by Celmi.
This mod allows the player to manually set arrival/departure times for logistics lines, as well as set unbunching times at each station. My play style
is geared to the latter, so I would calculate the journey times Timetables would find, perform the relevant conversions, then divide the time by the number
of vehicles on the line.

I would later trust OpenAI's ChatGPT to do this, but I discovered that sometimes the AI wouldn't calculate numbers correctly, or perform an incorrect action.
In response, this program was born.

## What it does
This one-file .php program consists of a simple HTML interface with PHP code. It asks for how many vehicles are on a line, followed by a list of transit times
between each station/stop. The lines can be delineated through either commas, spaces, or both. When the user presses submit, the PHP code will interpret each journey time
in the following ways:

### Performing time conversion
Given a time in mm:ss format, the time will first be converted into seconds. If no minute is given, it's assumed that there are zero minutes for that time.
This process is repeated until all the times have been converted, with the result being stored in the `$timeSeconds` variable.

### Getting frequency
Frequency is calculated by the following equation:
`$frequency = $timeSeconds / $vehNum`, or by dividing the total number of seconds by the number of vehicles. 
As an example: If the total trip time was 180 seconds and there were three vehicles on the line, the frequency would by 1 minute.

## What this is useful for
This program's primary purpose is to calculate route frequencies in Transport Fever 2, in conjunction with Celmi's Timetables mod. But this program may
also be used for other matters related to calculating route frequencies.
