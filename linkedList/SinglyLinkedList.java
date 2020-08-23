package dataStructure.linkedList;

public class SinglyLinkedList {

	public SinglyNode header;
	
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
		
		SinglyNode node = header;
		
		while(node != null && node.next != null) {
		// node != null ������ �߰��� ����
		//	������ �����Ͱ� �ߺ��� ���
		//	node������ null�� ���� ������
		//	null.next��� �����Ͱ� �������� ����
			
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
	
	// �ں��� k��° ���
	//	��� 1
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
