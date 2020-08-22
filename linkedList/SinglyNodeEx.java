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
		
		System.out.println("===== ===== ===== ===== =====");
		
		head.append(7);
		head.append(4);
		head.append(5);
		head.append(6);
		head.append(3);
		head.retrieve();
		
		int k = 2;
		SinglyNode kth = head.KthToLast(head, k);
		System.out.println("Last k(" + k + ")th data is " + kth.getData());
		
	}
	
}
