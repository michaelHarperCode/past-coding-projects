// CodingBat: parrot_trouble

package main

import "fmt"

// Determines if we're in trouble based on the parrot's behavior.
// We're in trouble if the parrot's talking between 21:00 and 6:00 (inclusive, 7:00 and 20:00 are safe)
func parrot_trouble(talking bool, hour int) bool {
	return talking && (hour < 7 || hour > 20)
}

func main() {
	result := parrot_trouble(true, 6)
	fmt.Println(result)
	result = parrot_trouble(true, 7)
	fmt.Println(result)
	result = parrot_trouble(false, 6)
	fmt.Println(result)
	result = parrot_trouble(true, 23)
	fmt.Println(result)
	result = parrot_trouble(false, 3)
	fmt.Println(result)
}
