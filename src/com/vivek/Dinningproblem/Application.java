package com.vivek.Dinningproblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	public static final int NUMBER_OF_PHILOSPHER = 5 ;
	public static final int NUMBER_OF_FORK = 5 ;

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executors = null ;
		Philospher[] philosphers = null ;

		try {

			System.out.println("Starting ....... ");
			philosphers = new Philospher[NUMBER_OF_PHILOSPHER] ;
			Fork[] fork = new Fork[NUMBER_OF_FORK] ;
			executors = Executors.newFixedThreadPool(NUMBER_OF_PHILOSPHER) ;

			for (int i =0 ; i<NUMBER_OF_FORK ; i++ )
			{
				fork[i] = new Fork(i) ;
			}
			for (int i =0 ; i<NUMBER_OF_PHILOSPHER ; i++ )
			{
				philosphers[i] = new Philospher(i, fork[i], fork[(i +1) % NUMBER_OF_FORK ]) ;
				executors.execute(philosphers[i]) ;
			}
			Thread.sleep(4000);

			for(Philospher p : philosphers)
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
