package dataStructure.linkedList;

public class SinglyLinkedListEx {

	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();

		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(4);
		
		sll.retrieve();
		
		// SinglyLinkedList는 SinglyNode와 다르게 header data를 삭제할 수 있다.
		sll.delete(1);
		sll.delete(4);
		
		sll.retrieve();

		System.out.println("===== ===== ===== ===== =====");
		
		sll.append(2);
		sll.append(3);
		sll.append(4);
		sll.append(5);
		sll.retrieve();
		
		// 중복 제거
		sll.removeDups();
		sll.retrieve();

		System.out.println("===== ===== ===== ===== =====");
		
		sll.append(7);
		sll.append(4);
		sll.append(5);
		sll.append(6);
		sll.append(3);
		sll.retrieve();
		
		// 뒤부터 k번째 출력
		int k = 5;

		// 방법 1
		SinglyNode kth = sll.KthToLast(sll, k);
		System.out.println("Last k(" + k + ")th data is " + kth.data);

	}
	
}
