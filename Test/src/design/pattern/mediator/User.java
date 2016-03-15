package design.pattern.mediator;

public abstract class User
{
	private Mediator mediator;

	public abstract void work();

	public Mediator getMediator()
	{
		return mediator;
	}

	public User(Mediator mediator)
	{
		this.mediator = mediator;
	}

}
