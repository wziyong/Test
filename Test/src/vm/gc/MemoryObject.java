package vm.gc;

public class MemoryObject
{

	private byte[] bytes;

	public MemoryObject(int objectSize)
	{
		this.bytes = new byte[objectSize];
	}

}
