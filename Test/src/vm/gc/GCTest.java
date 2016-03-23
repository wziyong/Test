package vm.gc;

public class GCTest
{
	static int m = 1024 * 1024;

	public static void main(String[] args)
	{
		byte[] a1 = new byte[1 * m / 6];
		System.out.println("a1 ok");
		byte[] a2 = new byte[7 * m];
		System.out.println("a2 ok");
		byte[] a3 = new byte[3 * m]; // GC
		System.out.println("a3 ok");
	}

}
