
public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }


    public void moveDown() {
        currentFloor = currentFloor <= minFloor ? currentFloor : currentFloor - 1;
    }


    public void moveUp() {
        currentFloor = currentFloor <= maxFloor ? currentFloor + 1 : currentFloor;
    }


    public void move(int floor) {
        if (floor < minFloor || floor > maxFloor || floor == 0) {
            System.out.println("Такого этажа нет");
        } else if (floor == currentFloor) {
            System.out.println("Указан текущий этаж");
        } else if (floor < currentFloor) {
            while (true) {
                moveDown();
                if (currentFloor != 0) {
                    System.out.println(currentFloor + " этаж");
                }
                if (floor == currentFloor) {
                    break;
                }
            }
        } else if (floor > currentFloor) {
            while (true) {
                moveUp();
                if (currentFloor != 0) {
                    System.out.println(currentFloor + " этаж");
                }
                if (floor == currentFloor) {
                    break;
                }
            }
        }
    }
}
