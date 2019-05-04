package com.vivek.Dinningproblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	public static final int NUMBER_OF_PHILOSOPHER = 5 ;
	public static final int NUMBER_OF_FORK = 5 ;

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executors = null ;
		Philosopher[] Philosophers = null ;

		try {

			System.out.println("Starting ....... ");
			Philosophers = new Philosopher[NUMBER_OF_PHILOSOPHER] ;
			Fork[] fork = new Fork[NUMBER_OF_FORK] ;
			executors = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHER) ;

			for (int i =0 ; i<NUMBER_OF_FORK ; i++ )
			{
				fork[i] = new Fork(i) ;
			}
			for (int i =0 ; i<NUMBER_OF_PHILOSOPHER ; i++ )
			{
				Philosophers[i] = new Philosopher(i, fork[i], fork[(i +1) % NUMBER_OF_FORK ]) ;
				executors.execute(Philosophers[i]) ;
			}
			Thread.sleep(4000);

			for(Philosopher p : Philosophers)
			{
				p.setDone(true);
			}

		}catch(Exception e )
		{

		}finally {

			executors.shutdown();
			if(!executors.isTerminated()){
				Thread.sleep(4000);
			}

		}

	}

}
