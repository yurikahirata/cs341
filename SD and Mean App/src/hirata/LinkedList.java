package hirata;

public class LinkedList {
	private Node head;
	private Node tail;
	public Double mean;
	public int length;
	
	public LinkedList() {
		head = null;
		tail = null;
		mean = 0.0;
		length = 0;
	}
	
	// Method to add node to LinkedList
	public void addNode(Double d) {
			Node temp = new Node(d);
			if (head == null) {
				head = temp;
				tail = temp;
			}
			else {
			tail.next = temp;
			tail = temp;
			}
			length++;
	}
	
	// Method to calculate the mean
	public String getMean() {
		// Mean of one number is the number itself
		if (head!= null && head==tail) {
			return head.value + "";
		} else if (head == null) {
			return "Empty file";
		}
		else {
			Node ptr = head;
			Double sum = 0.0;
			while (ptr != null) {
				sum += ptr.value;
				ptr = ptr.next;
			}
			mean = sum / length;
			return String.format("%.2f", mean);
		}
	}
	
	// Method to calculate the standard deviation
	public String getSD() {
		// Standard deviation of one number if 0
		if (head!= null && head==tail) {
			return "0";
		} else if (head == null) {
			return "Empty file";
		}
		else {
		Double result = 0.0;
		Double sq = 0.0;
		Double sd = 0.0;
		
		Node ptr = head;
		while (ptr != null) {
			sd += Math.pow((ptr.value - mean), 2);
			ptr = ptr.next;
		}
		
		sq = sd / length;
		result = Math.sqrt(sq);
		return String.format("%.2f", result);
		}
		
	}
}
