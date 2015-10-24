package multithread;

import java.util.concurrent.TimeUnit;

public class ThreadState
{
	public static void main(String[] args)
	{

		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(), "WaitingThread").start();
		//两个blocked线程，一个被阻塞，一个获取锁成功
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();
		
	}

	// 一直睡眠
	static class TimeWaiting implements Runnable
	{
		@Override
		public void run()
		{
			while (true)
			{
				try
				{
					TimeUnit.SECONDS.sleep(100);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

		}

	}

	// 该线程在Waiting.class 实例上等待
	static class Waiting implements Runnable
	{
		@Override
		public void run()
		{
			while (true)
			{
				synchronized (Waiting.class)
				{
					try
					{
						Waiting.class.wait();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}

	}

	static class Blocked implements Runnable
	{

		@Override
		public void run()
		{
			synchronized (Blocked.class)
			{
				while (true)
				{
					try
					{
						TimeUnit.SECONDS.sleep(100);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}

			}
		}

	}

}
