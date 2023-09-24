// CodingBat: diff21

package main

import (
	"fmt"
)

// Return the absolute difference between n and 21, or double the difference if n > 21.
// NOTE: This was done in the 'Try Go' section of go.dev, meaning imports other than "fmt" are not allowed.
// Ideally, you would use math.abs to avoid a repeat of the n-21 computation.
func diff21(n int) int {
	if n > 21 {
		return (n - 21) * 2
	} else {
		return 21 - n
	}
}

// Trunicated list of tests from CodingBat
func main() {
	result := diff21(19)
	fmt.Println(result)
	result = diff21(10)
	fmt.Println(result)
	result = diff21(21)
	fmt.Println(result)
	result = diff21(22)
	fmt.Println(result)
	result = diff21(25)
	fmt.Println(result)
}
