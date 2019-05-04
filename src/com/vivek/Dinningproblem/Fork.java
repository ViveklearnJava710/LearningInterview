package com.vivek.Dinningproblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

	private int id ;
	private Lock lock ;

	public Fork(int id ){
		this.id = id ;
		lock = new ReentrantLock();
	}

	public boolean pickup(Philospher p , State state ) throws InterruptedException
	{
		if(lock.tryLock(10, TimeUnit.SECONDS))
		{
			System.out.println("Philospher " + p.getId() + "picked Up Fork " + state);
			return true ;
		}

		return false ;
	}

	public boolean putdown(Philospher p , State state )
	{
		lock.unlock();
		System.out.println("Philospher " +p.getId()+ "put down  Fork " + state);
		return true ;
	}


}
