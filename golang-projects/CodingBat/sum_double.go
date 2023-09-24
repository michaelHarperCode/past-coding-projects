// CodingBat: sum_double

package main

import "fmt"

// Return the sum of two numbers, or double the sum if the numbers are the same
func sum_double(a, b int) int {
	if a == b {
		return (a + b) * 2
	} else {
		return (a + b)
	}
}

// Tests here are the same as CodingBat's
func main() {
	result := sum_double(1, 2)
	fmt.Println(result)
	result = sum_double(3, 2)
	fmt.Println(result)
	result = sum_double(2, 2)
	fmt.Println(result)
	result = sum_double(-1, 0)
	fmt.Println(result)
	result = sum_double(3, 3)
	fmt.Println(result)
	result = sum_double(0, 0)
	fmt.Println(result)
	result = sum_double(0, 1)
	fmt.Println(result)
	result = sum_double(3, 4)
	fmt.Println(result)
}
