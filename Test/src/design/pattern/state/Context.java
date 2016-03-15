package design.pattern.state;

/**
 * 状态模式的切换类
 */
public class Context
{

	private State state;

	public void method()
	{
		if (state.getState().equals("1"))
		{
			state.method1();
		}
		else if (state.getState().equals("2"))
		{
			state.method2();
		}
	}

	public Context(State state)
	{
		this.state = state;
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

}
