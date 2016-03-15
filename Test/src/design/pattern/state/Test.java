package design.pattern.state;

public class Test
{

	public static void main(String[] args)
	{
		State state = new State();
		Context context = new Context(state);
		
		
		//设置第一种状态  
		state.setState("1");
		context.method();
		
		
		//设置第2种状态  
		state.setState("2");
		context.method();
	}

}
