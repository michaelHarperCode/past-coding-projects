#Michael Harper
#CodingBat - List2

# count_evens

def count_evens(nums):
  i = 0
  evenNums = 0
  while(i < len(nums)):
    if(nums[i] % 2 == 0):
      evenNums = evenNums + 1
    i = i + 1
  return evenNums

# big_diff

def big_diff(nums):
  i = 0
  lowest = 9999
  highest = -9999
  while(i < len(nums)):
    lowest = min(nums[i], lowest)
    highest = max(nums[i], highest)
    i = i + 1
  return highest - lowest

# centered_average

def centered_average(nums):
  i = 0
  total = 0
  smallest = 9999
  largest = -9999
  length = len(nums)
  while(i < length):
    total = total + nums[i]
    smallest = min(smallest, nums[i])
    largest = max(largest, nums[i])
    i = i + 1
  total = total - smallest - largest
  return total // (len(nums) - 2)

# sum13

def sum13(nums):
  i = 0
  sum = 0;
  while i < len(nums):
    if nums[i] == 13:
      i = i + 2
    else:
      sum = sum + nums[i]
      i = i + 1
  return sum

# sum67

def sum67(nums):
  i = 0
  sum = 0
  thereWasASix = False
  while i < len(nums):
    if (nums[i] != 6) and thereWasASix == False:
      sum = sum + nums[i]
    else:
      if(nums[i] == 6):
        thereWasASix = True
      elif(nums[i] == 7):
        thereWasASix = False
    i = i + 1
  return sum

# has22

def has22(nums):
  i = 0
  hasTwoTwos = False
  while i < len(nums) - 1:
    if nums[i] == 2 and nums[i+1] == 2:
      hasTwoTwos = True
      return hasTwoTwos
    i = i + 1
  return hasTwoTwos
