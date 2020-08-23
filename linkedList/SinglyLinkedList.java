package dataStructure.linkedList;

public class SinglyLinkedList {

	public SinglyNode header;
	
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

	// 중복 제거
	//	버퍼를 사용한 경우 공간복잡도 -> O(N)
	//	버퍼를 사용한 경우 시간복잡도 -> O(N)
	//	버퍼를 사용하지 않은 경우(아래) 공간복잡도 -> O(1)
	//	버퍼를 사용하지 않은 경우(아래) 시간복잡도 -> O(N^2)
	public void removeDups() {
		
		SinglyNode node = header;
		
		while(node != null && node.next != null) {
		// node != null 조건이 추가된 이유
		//	마지막 데이터가 중복된 경우
		//	node변수에 null이 들어가기 때문에
		//	null.next라는 데이터가 존재하지 않음
			
			SinglyNode runner = node;

			while(runner.next != null) {
			
				if(node.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			
			node = node.next;
		}
	}
	
	// 뒤부터 k번째 출력
	//	방법 1
	public SinglyNode KthToLast(SinglyLinkedList sll , int k) {
		
		SinglyNode node = sll.header.next;
		int total = 1;
		
		while(node.next != null) {
			total++;
			node = node.next;
		}
		
		node = sll.header.next;
		
		for(int i=1; i<total-k+1; i++) {
			node = node.next;
		}
		
		return node;
	}
	
}
