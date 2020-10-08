package dataStructure.linkedList;

import javax.xml.soap.Node;

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

		System.out.println("===== ===== ===== ===== =====");

		// Linked List Digit �ջ� �˰���
		SinglyNode l1 = new SinglyNode(9);
		l1.append(1);
		l1.append(4);
		l1.retrieve();
		
		SinglyNode l2 = new SinglyNode(6);
		l2.append(4);
		l2.retrieve();
		
		SinglyNode node = sumLists(l1, l2);
		
		System.out.println(" === Linked List Digit �ջ� �˰��� === ");
		while (node.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println(node.data);
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
	//		�������⵵ -> O(N)
	//		�ð����⵵ -> O(2N)
	//			��Oǥ��� -> O(N)
	public static class Reference {
		public int count = 0;
	}
	
	public static SinglyNode KthToLast2(SinglyNode n , int k, Reference r) {
		
		if(n == null) {
			return null;
		}
		
		SinglyNode found = KthToLast2(n.next, k, r);
		
		r.count++;
		
		if (r.count == k) {
			return n;
		}
		
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
	
	// Linked List Digit �ջ� �˰���
	//	���������� List ����
//	public static SinglyNode sumLists(SinglyNode l1, SinglyNode l2, int carry) {
//		
//		if (l1 == null & l2 == null && carry == 0) {
//			return null;
//		}
//		
//		SinglyNode result = new SinglyNode();
//		int value = carry;
//		
//		if (l1 != null) {
//			value += l1.data;
//		}
//		if (l2 != null) {
//			value += l2.data;
//		}
//		result.data = value % 10;
//		
//		if (l1 != null || l2 !=null) {
//			SinglyNode next = sumLists(l1 == null? null : l1.next, l2 == null? null : l2.next, value >= 10? 1 : 0);
//			result.next = next;
//		}
//		
//		return result;
//	}
	
	//	���������� List ����
	public static class Storage {
		
		int carry = 0;
		
		SinglyNode result = null;
	}
	
	public static int getListLength(SinglyNode node) {
		
		int total = 0;
		
		while( node != null) {
			total ++;
			node = node.next;
		}
		
		return total;
	}
	
	public static SinglyNode insertBefore (SinglyNode node, int data) {
	
		SinglyNode before = new SinglyNode(data);
		
		if(node != null) {
			before.next = node;
		}
		
		return before;
	}
	
	public static SinglyNode LPadList(SinglyNode node, int length) {
		
		SinglyNode head = node;
		
		for (int i = 0; i < length; i++) {
			head = insertBefore(head, 0);
		}
		
		return head;
	}
	
	public static Storage addLists(SinglyNode l1, SinglyNode l2) {
		
		if(l1 == null && l2 == null) {
			Storage storage = new Storage();
			return storage;
		}
		
		Storage storage = addLists(l1.next, l2.next);
		
		int value = storage.carry + l1.data + l2.data;
		int data = value % 10;
		
		storage.result = insertBefore(storage.result, data);
		storage.carry = value / 10;
		
		return storage;
	}
	
	public static SinglyNode sumLists(SinglyNode l1, SinglyNode l2) {
		
		int len1 = getListLength(l1);
		int len2 = getListLength(l2);
		
		if ( len1 < len2 ) {
			l1 = LPadList(l1, len2 - len1);
		} else {
			l2 = LPadList(l2, len1 - len2);
		}
		
		Storage storage = addLists(l1, l2);
		
		if (storage.carry != 0) {
			storage.result = insertBefore(storage.result, storage.carry);
		}
		
		return storage.result;
	}
	
	// ������ ã��
	public static SinglyNode getIntersection(SinglyNode l1, SinglyNode l2) {
		
		int len1 = getListLength(l1);
		int len2 = getListLength(l2);
		
		if (len1 > len2) {
			l1 = l1.get(len1 - len2);
		} else if (len1 < len2) {
			l2 = l2.get(len2 - len1);
		}
		
		while (l1 != null && l2 != null) {
			if(l1 == l2) {
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		
		return null;
	}
	
	// ���� ã��
	public static class Test {
		
		public static void main (String[] args) {
			SinglyNode n1 = new SinglyNode(1);
		}
		
		private static SinglyNode findLoop (SinglyNode head) {
			
			SinglyNode fast = head;
			SinglyNode slow = head;
			
			while (fast != null && fast.next != null) {
				
				slow = slow.next;
				fast = fast.next.next;
				
				if(fast == slow) {
					break;
				}
			}
			
			if (fast == null || fast.next == null) {
				return null;
			}
			
			slow = head;
			
			while (fast != slow) {
				slow = slow.next;
				fast = fast.next;
			}
			
			return fast;
		}
	}
	
}
