package app;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ElavatorAppl {
	private static final int WAIT_DOORS_IN_SECONDS = 10; 
    private static final int WAIT_MOVE_IN_SECONDS = 5;
    private static final int MIN_FLOOR = 0;
    private static final int MAX_FLOOR = 25;

    public static void main(String[] args) {
        Queue<Integer> floors = getFloorInput();
        calculateAndPrintElevatorRoute(floors);
    }

    private static Queue<Integer> getFloorInput() {
        Queue<Integer> floors = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Awaiting floor entry: (enter 0 to complete)");
            int floor = scanner.nextInt();

            if (floor < MIN_FLOOR || floor > MAX_FLOOR) {
                System.out.println("That floor is not in the house");
                continue;
            }

            if (floor == MIN_FLOOR) {
                break;
            }

            floors.add(floor);
        }

        return floors;
    }

    private static void calculateAndPrintElevatorRoute(Queue<Integer> floors) {
        int totalSeconds = 0; 
        int previousFloor = -1; 

        System.out.println("The elevator followed the next floors:");
        while (!floors.isEmpty()) {
            int currentFloor = floors.poll();
            System.out.print("floor " + currentFloor);
            if (!floors.isEmpty()) {
                System.out.print(" -> ");
            }

            if (previousFloor != -1) {
                totalSeconds += Math.abs(currentFloor - previousFloor) * WAIT_MOVE_IN_SECONDS;
            }
            totalSeconds += WAIT_DOORS_IN_SECONDS;

            previousFloor = currentFloor;
        }
        System.out.println("\nTime spent by elevator on the route: " + totalSeconds + " seconds");
    }
}

