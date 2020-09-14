package dataStructure.linkedList;

public class SinglyLinkedListEx {

	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();

		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(4);
		
		sll.retrieve();
		
		// SinglyLinkedList�� SinglyNode�� �ٸ��� header data�� ������ �� �ִ�.
		sll.delete(1);
		sll.delete(4);
		
		sll.retrieve();

		System.out.println("===== ===== ===== ===== =====");
		
		sll.append(2);
		sll.append(3);
		sll.append(4);
		sll.append(5);
		sll.retrieve();
		
		// �ߺ� ����
		sll.removeDups();
		sll.retrieve();

	}
	
}
