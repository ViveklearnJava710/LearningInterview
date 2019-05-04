package com.vivek.Dinningproblem;

public class Philospher implements Runnable {

	private int id ;
	private Fork leftFork ;
	private Fork rightFork ;
	private volatile Boolean isFull  = false  ;

	public Philospher(int id , Fork leftFork , Fork rightFork)
	{
		this.id = id ;
		this.leftFork = leftFork ;
		this.rightFork = rightFork ;
	}
	@Override
	public void run() {
		while (!isFull){

			think() ;

			try {
				if(leftFork.pickup(this , State.LEFT)){
					if(rightFork.pickup(this, State.RIGHT))
					{
						System.out.println(this.id + " = Eating Maggy ");
						eat() ;
						rightFork.putdown(this, State.RIGHT) ;
					}
					leftFork.putdown(this, State.LEFT) ;

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void  think()
	{
		delay(1000);
	}

	private void  eat()
	{
		delay(1000);
	}

	public void setDone(Boolean value )
	{
		this.isFull = value ;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public static void delay(long ms) {
	    try {
	      Thread.sleep(ms);
	    } catch (InterruptedException e) {
	      throw new RuntimeException(e);
	    }
	  }



}
