package datastructrue.list;

public class LinkedList
{
	private Node head;
	// 指向尾节点
	public Node tail;

	private int size = 0;

	// 链表最大容量，超过的则删除结尾元素
	private int maxSize = 10;

	/**
	 * 判断链表是否为空
	 */
	public boolean isEmpty()
	{
		return head == null;
	}

	/**
	 * 创建头指针，该方法只用一次！
	 */
	public void addToHead(Node node)
	{
		head = node;
		if (tail == null)
			tail = head;
	}

	public void printList()
	{
		if (isEmpty())
		{
			System.out.println("empty list");
		}
		else
		{
			int i = 1;
			for (Node p = head; p != null; p = p.next)
			{
				System.out.println(i + " " + p.similarity + " " + p.itemId);
				i++;
			}
		}
	}

	// 插入
	public boolean insert(Node node)
	{
		if (!isEmpty())
		{
			Node prev = head;
			Node curr = head.next;
			int i = 0;
			while ((curr != null) && (curr.similarity > node.similarity))
			{ // 两个判断条件不能换
				prev = curr;
				curr = curr.next;
				i++;
			}

			// 如果添加到结尾，而且添加后长度大于maxSize，则不添加了。
			if (curr == null && (size + 1 > maxSize))
			{
				return true;
			}

			node.next = curr;
			prev.next = node;
			size++;

			// cut
			if (size > maxSize)
			{
				while (i <= maxSize - 2)
				{
					prev = curr;
					curr = curr.next;
					i++;
				}
				prev.next = null;
				size--;
			}

			return true;

			//
			//
			//
			//
			// // 循环maxSize次
			// Node prev = head;
			// Node curr = null;
			//
			// for (curr = head.next; curr != null; prev = curr, curr = curr.next)
			// {
			// // 如果大于，则后移
			// if (curr.similarity > node.similarity)
			// {
			// continue;
			// }
			// else
			// {
			// node.next = curr;
			// prev.next = node;
			//
			// size++;
			// break;
			// }
			// }
			//
			// if (null == curr)
			// {
			// tail = node;
			// }

		}
		else
		{
			head = new Node("HEAD", 10.0);
			head.next = node;
			if (tail == null)
				tail = node;
			size++;
		}
		return false; // ①
	}

}
