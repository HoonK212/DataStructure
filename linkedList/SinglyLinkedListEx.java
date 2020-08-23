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

		System.out.println("===== ===== ===== ===== =====");
		
		sll.append(7);
		sll.append(4);
		sll.append(5);
		sll.append(6);
		sll.append(3);
		sll.retrieve();
		
		// �ں��� k��° ���
		int k = 5;

		// ��� 1
		SinglyNode kth = sll.KthToLast(sll, k);
		System.out.println("Last k(" + k + ")th data is " + kth.data);

	}
	
}
