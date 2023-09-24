// Sleep-in problem from CodingBat, done in Golang.

package main

import "fmt"

// Determines if we sleep in or not
// We sleep in if its not a weekday or if its a vacation
func SleepIn(weekday bool, vacation bool) bool {
	return !weekday || vacation
}

func main() {
	result := SleepIn(true, true)
	fmt.Println(result)
	result2 := SleepIn(true, false)
	fmt.Println(result2)
	result3 := SleepIn(false, true)
	fmt.Println(result3)
	result4 := SleepIn(false, false)
	fmt.Println(result4)
}
