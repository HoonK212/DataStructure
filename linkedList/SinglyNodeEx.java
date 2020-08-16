package dataStructure.linkedList;

public class SinglyNodeEx {
	public static void main(String[] args) {
		
		SinglyNode head = new SinglyNode(1);
		
		head.append(2);
		head.append(3);
		head.append(4);
		
		head.retrieve();
		
		head.delete(2);
		head.delete(3);
		
		head.retrieve();
	}
}
