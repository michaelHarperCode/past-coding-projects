#Kris Wuelfing, Sammy Gonzalez, Max Freudenburg, Michael Harper
#Final Project Part 2
#First code
# #This assignment asks your team to write a nontrivial program in the language you've chosen.
# Write a program that exercises the following features of your language:
# If/else statements or equivalent branching
# Loops, recursion, or vectorized computation
# Creating data structures such as arrays or elements


#function that returns the max and min of a vector of numbers
#a vector is an element type of a sequence of elements of the same type such as integer, character, string
function1MaxMin <- function(vector1){     #declare function; function takes in one variable
   max <- vector1[1]                   #declare the max to be the first element in vector
   min <- vector1[1]                   #declare the min to be the first element in vector
  for(i in 1:length(vector1)){         #for loop to iterate through the vector; 1:length(vector1) means run through whole vector
    if (vector1[i] >= max){            #compare the i item in vector to max using an if
      max <- vector1[i]                #if the element in the vector is greater than max, set max to that element
    } else if (vector1[i] <= min){     #compare the i element in vector to min using an if
      min <- vector1[i]                #if the element in the vector is smaller than min, set min to that element
    }
  }
  print("Max")
  print(max)                    #print the max
  print("Min")
  print(min)                    #print the min
}

#user creates a vector of numbers with a length of their choosing
vector1 <- as.double(unlist(strsplit(readline(prompt = "Enter a list of numbers, seperated by a space: "), " ")))

print(vector1)          #print the vectors
function1MaxMin(vector1)   #calls the function with the created vector
