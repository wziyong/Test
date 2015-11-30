package javalock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

public class Mutex
{

	private static class Sync extends AbstractQueuedSynchronizer
	{

		protected boolean isHeldExclusively()
		{
			return getState() == 1;
		}
		
		public boolean tryAcquire(int acquires)
		{
			if(compareAndSetState(0, 1))
			{
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		
		protected boolean tryRelease(int releases)
		{
			if(getState() == 0) throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		
		Condition newCondition()
		{
			return new ConditionObject();
		}

	}

}




























