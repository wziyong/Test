package datastructrue.list.priorityqueue;

public class Bean
{
	public Bean(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}

	private String name = "";

	private int age = 0;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

}
