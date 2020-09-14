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
		
		// 뒤부터 k번째 출력
		//	방법 1
		int k = 6;
		SinglyNode kth = KthToLast(head, k);
		System.out.println("Last k(" + k + ")th data is " + kth.data);
		
		//	방법 2
		k = 4;
		Reference r = new Reference();
		kth = KthToLast2(head, k, r);
		System.out.println("Last k(" + k + ")th_2 data is " + kth.data);
		
		// 방법 3
		k = 2;
		kth = KthToLast3(head, k);
		System.out.println("Last k(" + k + ")th_2 data is " + kth.data);
		
		System.out.println("===== ===== ===== ===== =====");
		
		// 중간 노드 삭제
		head.retrieve();
		deleteSinglyNode(KthToLast(head, 2)); // 뒤에서 2번째 노드 삭제
		head.retrieve();

	}
	
	// 뒤부터 k번째 출력
	//	방법 1
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
	
	//	방법 2 : 재귀호출
	public static class Reference {
		public int count = 0;
	}
	
	public static SinglyNode KthToLast2(SinglyNode n , int k, Reference r) {
		
		System.out.println();
		System.out.println(n + "\n");
		
		if(n == null) {
			System.out.println("return null 이전\n");
			return null;
		}
		
		SinglyNode found = KthToLast2(n.next, k, r);
		
		if(found==null) {
			System.out.println("found 데이터 null\n");
		} else {
			System.out.println("found 데이터 " + found.data + "\n");
		}
		
		r.count++;
		System.out.println("count++ 이후 " + r.count + "\n");
		
		if (r.count == k) {
			System.out.println("if 내부 *** *** *** " + n.data + "\n");
			return n;
		}
		
		System.out.println("if 이후 ### ### ###\n");
		return found;
	}
	
	// 방법 3 : 포인트
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
	
	// 중간 노드 삭제
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
