package dataStructure.linkedList;

public class SinglyLinkedListEx {

	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();

		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(4);
		
		sll.retrieve();
		
		// SinglyLinkedList Ŭ������
		//	������ header ���� SinglyNode Ŭ������ ���α� ������
		//	header data�� ������ �� �ִ�.
		sll.delete(1);
		sll.delete(3);
		
		sll.retrieve();
	}
	
}
