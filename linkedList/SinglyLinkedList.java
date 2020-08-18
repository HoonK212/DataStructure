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
	
	// �߰�
	public void append(int data) {
		
		SinglyNode end = new SinglyNode();
		end.data = data;
		SinglyNode node = header;
		
		while(node.next != null) {
			node = node.next;
		}
		
		node.next = end;
	}
	
	// ����
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
	
	// ���
	public void retrieve() {
		
		SinglyNode node = header.next;
		
		while(node.next != null) {
			System.out.print(node.data + " > ");
			node = node.next;
		}
		
		System.out.println(node.data);
	}
	
	// �ߺ� ����
	//	���۸� ����� ��� �������⵵ -> O(N)
	//	���۸� ����� ��� �ð����⵵ -> O(N)
	//	���۸� ������� ���� ���(�Ʒ�) �������⵵ -> O(1)
	//	���۸� ������� ���� ���(�Ʒ�) �ð����⵵ -> O(N^2)
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
