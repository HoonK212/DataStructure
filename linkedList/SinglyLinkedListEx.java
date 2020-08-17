package dataStructure.linkedList;

public class SinglyLinkedListEx {

	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();

		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(4);
		
		sll.retrieve();
		
		// SinglyLinkedList 클래스가
		//	별도의 header 값과 SinglyNode 클래스를 감싸기 때문에
		//	header data를 삭제할 수 있다.
		sll.delete(1);
		sll.delete(3);
		
		sll.retrieve();
	}
	
}
