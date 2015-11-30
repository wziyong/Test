package datastructrue.list;

public class Node
{
	public String itemId = "";

	public double similarity = 0;

	public Node next = null;

	public Node(String itemId, double similarity)
	{
		this.itemId = itemId;
		this.similarity = similarity;
	}
}
