//package datastructrue.list;
//
//public class SingleLinkedList<T>
//{
//	private Node<T> head;
//
//	// 指向尾节点
//	private Node<T> tail;
//
//	private int size = 0;
//
//	// 链表最大容量，超过的则删除结尾元素
//	private int maxSize = 200;
//
//	/**
//	 * 判断链表是否为空
//	 */
//	public boolean isEmpty()
//	{
//		return head == null;
//	}
//
//	/**
//	 * 创建头指针，该方法只用一次！
//	 */
//	public void addToHead(T item)
//	{
//		head = new Node<T>(item);
//		if (tail == null)
//			tail = head;
//	}
//
//	public void printList()
//	{
//		if (isEmpty())
//		{
//			System.out.println("empty list");
//		}
//		else
//		{
//			for (Node<T> p = head; p != null; p = p.next)
//			{
//				System.out.println(p.nodeValue);
//			}
//		}
//	}
//
//	// 插入
//	public boolean insert(T item)
//	{
//		Node<T> prev = head;
//		Node<T> newNode = new Node<T>(item);
//
//		if (!isEmpty())
//		{
//			// 循环maxSize次
//			int i = 1;
//			for (Node<T> curr = head; curr != null && i < this.maxSize; curr = curr.next)
//			{
//				if(curr.getNodeValue() > newNode.nodeValue)
//				{
//					
//				}
//				
//			}
//
//			while ((curr != null) && (!appointedItem.equals(curr.nodeValue)))
//			{ // 两个判断条件不能换
//				prev = curr;
//				curr = curr.next;
//			}
//			
//			newNode.next = curr; // ②③④
//			prev.next = newNode;
//			return true;
//		}
//		else
//		{
//			head = new Node<T>(item);
//			if (tail == null)
//				tail = head;
//			size++;
//		}
//		return false; // ①
//	}
//
//}
