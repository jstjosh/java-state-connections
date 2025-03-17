import java.util.List;

public class StateLinkedList {
    private Node head;

    public StateLinkedList() {
        head = null;
    }

    // Method to add a new state and its neighbors at the end of the list
    public void addState(String stateName, List<String> neighbors) {
        Node newNode = new Node(stateName, neighbors);
        if (head == null) {
            head = newNode; // Set head to newNode
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse the list
            }
            current.next = newNode; // Set current.next to newNode
        }
    }

    // Method to delete a state by its name
    public void deleteState(String stateName) {
        if (head == null) {
            return; // List is empty
        }
        if (head.stateName.equals(stateName)) {
            head = head.next; // Update head to head.next
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.stateName.equals(stateName)) {
                current.next = current.next.next; // Remove the node by linking current.next to current.next.next
                return;
            }
            current = current.next;
        }
    }

    // Method to print all states and their neighbors
    public void printStates() {
        Node current = head;
        while (current != null) {
            System.out.println("State: " + current.stateName + ", Neighbors: " + current.neighbors);
            current = current.next; // Move to the next node
        }
    }
}