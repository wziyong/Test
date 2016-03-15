package design.pattern.state;

/**
 * 状态类的核心类
 * 
 * @author wziyong
 *
 */
public class State
{

	private String state;

	public void method1()
	{
		System.out.println("method 1 execute....");
	}

	public void method2()
	{
		System.out.println("method 2 execute....");
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

}
