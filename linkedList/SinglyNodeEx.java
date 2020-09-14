package dataStructure.linkedList;

public class SinglyNodeEx {
	public static void main(String[] args) {
		
		SinglyNode head = new SinglyNode(1);
		
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		
		head.delete(2);
		head.delete(3);
		head.retrieve();
		
		System.out.println("===== ===== ===== ===== =====");

		head.append(7);
		head.append(4);
		head.append(5);
		head.append(6);
		head.append(3);
		head.retrieve();
		
		// �ں��� k��° ���
		//	��� 1
		int k = 6;
		SinglyNode kth = KthToLast(head, k);
		System.out.println("Last k(" + k + ")th data is " + kth.data);
		
		//	��� 2
		k = 4;
		Reference r = new Reference();
		kth = KthToLast2(head, k, r);
		System.out.println("Last k(" + k + ")th_2 data is " + kth.data);
		
		// ��� 3
		k = 2;
		kth = KthToLast3(head, k);
		System.out.println("Last k(" + k + ")th_2 data is " + kth.data);
		
		System.out.println("===== ===== ===== ===== =====");
		
		// �߰� ��� ����
		head.retrieve();
		deleteSinglyNode(KthToLast(head, 2)); // �ڿ��� 2��° ��� ����
		head.retrieve();

	}
	
	// �ں��� k��° ���
	//	��� 1
	public static SinglyNode KthToLast(SinglyNode n , int k) {
		
		SinglyNode node = n;
		int total = 1;
		
		while(node.next != null) {
			total++;
			node = node.next;
		}
		
		node = n;
		
		for(int i=1; i<total-k+1; i++) {
			node = node.next;
		}
		
		return node;
	}
	
	//	��� 2 : ���ȣ��
	public static class Reference {
		public int count = 0;
	}
	
	public static SinglyNode KthToLast2(SinglyNode n , int k, Reference r) {
		
		System.out.println();
		System.out.println(n + "\n");
		
		if(n == null) {
			System.out.println("return null ����\n");
			return null;
		}
		
		SinglyNode found = KthToLast2(n.next, k, r);
		
		if(found==null) {
			System.out.println("found ������ null\n");
		} else {
			System.out.println("found ������ " + found.data + "\n");
		}
		
		r.count++;
		System.out.println("count++ ���� " + r.count + "\n");
		
		if (r.count == k) {
			System.out.println("if ���� *** *** *** " + n.data + "\n");
			return n;
		}
		
		System.out.println("if ���� ### ### ###\n");
		return found;
	}
	
	// ��� 3 : ����Ʈ
	public static SinglyNode KthToLast3(SinglyNode n , int k) {
		
		SinglyNode p1 = n;
		SinglyNode p2 = n;
		
		for(int i=0; i < k; i++) {
			
			if(p1 == null) {
				return null;
			}
			
			p1 = p1.next;
		}
		
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
	// �߰� ��� ����
	public static boolean deleteSinglyNode(SinglyNode n) {
		
		if (n == null || n.next == null) {
			return false;
		}
		
		SinglyNode next = n.next;
		
		n.data = next.data;
		n.next = next.next;
		
		return true;
	}
}
