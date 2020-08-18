package dataStructure.linkedList;

public class SinglyLinkedList {

	SinglyNode header;
	
	public static class SinglyNode {
		int data;
		SinglyNode next = null;
	}
	
	public SinglyLinkedList() {
		header = new SinglyNode();
	}
	
	// 추가
	public void append(int data) {
		
		SinglyNode end = new SinglyNode();
		end.data = data;
		SinglyNode node = header;
		
		while(node.next != null) {
			node = node.next;
		}
		
		node.next = end;
	}
	
	// 삭제
	public void delete(int data) {
		
		SinglyNode node = header;
		
		while(node.next != null) {
			
			if(node.next.data == data) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
	}
	
	// 출력
	public void retrieve() {
		
		SinglyNode node = header.next;
		
		while(node.next != null) {
			System.out.print(node.data + " > ");
			node = node.next;
		}
		
		System.out.println(node.data);
	}
	
	// 중복 삭제
	//	버퍼를 사용한 경우 공간복잡도 -> O(N)
	//	버퍼를 사용한 경우 시간복잡도 -> O(N)
	//	버퍼를 사용하지 않은 경우(아래) 공간복잡도 -> O(1)
	//	버퍼를 사용하지 않은 경우(아래) 시간복잡도 -> O(N^2)
	public void removeDups() {
		
		SinglyNode n = header;
		
		while(n != null && n.next != null) {
			
			SinglyNode r = n;

			while(r.next != null) {
			
				if(n.data == r.next.data) {
					r.next = r.next.next;
				} else {
					r = r.next;
				}
			}
			
			n = n.next;
		}
	}
	
}
