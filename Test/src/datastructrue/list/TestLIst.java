package datastructrue.list;

public class TestLIst
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();

		Node node = null;
		Double xx = 0.0;
		for(int i=0;i<=12000000;i++)
		{
			xx = Math.random();
			node = new Node("item"+xx, xx);
			list.insert(node);
		}
		

		list.printList();
		
	}

}
