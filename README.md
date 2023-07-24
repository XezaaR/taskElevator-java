# Task 1: Elevator
## Description
In this task, we are implementing a program for the operation of an elevator in a 25-storey building. The program should read data from the console, specifically waiting for floor numbers to be entered. After each number (representing a floor) is entered, it should be added to the elevator's queue of movement. When the user inputs '0', the program should sequentially output a list of all floors where the elevator made stops, in the format: "floor 1 -> floor 22 -> floor 0". If a floor outside the range of 0-25 is entered, such data entry should be ignored. A structure based on the queue interface is suggested for storing user-entered floors.

## Program Functionality
1. Input of floor numbers.
2. Output of information about visited floors in the order of addition, formatted as: "floor 1 -> floor 22 -> floor 0".

### Example
Waiting for floor entry: (to finish enter 0)
5 <enter>
Waiting for floor entry: (enter 0 to complete)
12 <enter>
Waiting for floor entry: (enter 0 to complete)
38 <enter>
There is no such floor in the house
Waiting for floor entry: (enter 0 to complete)
0 <enter>
The elevator proceeded to the following floors:
floor 5 -> floor 12 -> floor 0
## Implementation Process
- In an infinite loop, read floor numbers until '0' (ground floor) is entered.
- Prior to each entry, prompt the user with "Waiting for floor entry: (enter 0 to complete)".
- Check if the entered floor is within the range of valid values (0-25); if not, display the message "There is no such floor in the house".
- If '0' is entered, exit the data reading loop.
- If a valid floor number is entered, add the value to the queue and request the next data entry.
- To display the information on the screen, sequentially read all values using the Queue poll interface method and display the information.

## Additional Task: Calculate Elevator Travel Time
After the zero floor is entered, the program should calculate the total elevator travel time, including stops. The elevator takes 5 seconds to move between floors, and 10 seconds for door operations (opening and closing). The program should output the time taken by the elevator to traverse the entered floors.

### Implementation Process
- Before the loop that outputs the elevator operation result, add several variables:
  - `int waitDoorsInSeconds = 10` - the time taken to open/close the doors.
  - `int waitMoveInSeconds = 5` - the time taken by the elevator to move between floors.
  - `int totalSeconds = 0` - the total time spent on movement and stops by the elevator.
  - `int previousFloor = -1` - a variable to store the previous stop.

- In the loop:
  - If `previousFloor` is not equal to -1, calculate the difference between the current floor and the previous one. Use `Math.abs` to find the absolute value (removing the sign), and multiply it by the time taken for movement: `totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveInSeconds`.
  - Add the time taken for door operations to `totalSeconds`: `totalSeconds += waitDoorsInSeconds`.

- After exiting the loop, print the value of `totalSeconds` to the screen: `System.out.println("Time spent by the elevator on the route =: " + totalSeconds + " s.");`.
