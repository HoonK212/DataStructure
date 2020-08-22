package dataStructure.linkedList;

public class SinglyNode {

	private int data;
	private SinglyNode next = null;
	
	public SinglyNode(int data) {
		this.data = data;
	}
	
	// 추가
	public void append(int data) {
		
		SinglyNode end = new SinglyNode(data);
		SinglyNode node = this; // this == head
		
		while(node.next != null) {
			node = node.next;
		}
		
		node.next = end;
	}
	
	// 삭제
	public void delete(int data) {
		
		SinglyNode node = this;
		
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
		
		SinglyNode node = this;
		
		while(node.next != null) {
			System.out.print(node.data + " > ");
			node = node.next;
		}
		
		System.out.println(node.data);
	}
	
	// 뒤부터 세기
	public SinglyNode KthToLast(SinglyNode first, int k) {
		
		SinglyNode n = first;
		int total = 1;
		
		while(n.next != null) {
			total++;
			n = n.next;
		}
		
		n = first;
		
		for(int i=1; i<total-k+1; i++) {
			n = n.next;
		}
		
		return n;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public SinglyNode getNext() {
		return next;
	}
	public void setNext(SinglyNode next) {
		this.next = next;
	}
	
}
