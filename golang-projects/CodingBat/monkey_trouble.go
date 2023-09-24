// CodingBat: monkey_trouble

package main

import "fmt"

// Determines if we're in trouble based on monkey's behavior
// We're in trouble if both monkeys are smiling or not smiling
func monkey_trouble(a_smile, b_smile bool) bool {
	return (a_smile && b_smile) || (!a_smile && !b_smile)
}

func main() {
	result := monkey_trouble(true, true)
	fmt.Println(result)
	result = monkey_trouble(true, false)
	fmt.Println(result)
	result = monkey_trouble(false, true)
	fmt.Println(result)
	result = monkey_trouble(false, false)
	fmt.Println(result)
}
