package main

// CodingBat: not_string

import (
	"fmt"
	"strings"
)

// Add "not" to the start of the string
// Leave the string as-is if "not" is already at the beginning
func not_string(input string) string {
	if strings.HasPrefix(input, "not") {
		return input
	} else {
		return "not " + input
	}
}

// Abridged testing list from CodingBat
func main() {
	result := not_string("candy")
	fmt.Println(result)
	result = not_string("x")
	fmt.Println(result)
	result = not_string("not bad")
	fmt.Println(result)
	result = not_string("is not")
	fmt.Println(result)
	result = not_string("not")
	fmt.Println(result)
}
