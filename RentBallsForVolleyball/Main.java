public class Main {
	static int j = 0;
	public static void main(String[] args) {
		
		for(j = 0; j < 5; j++) {
			Runnable task1 = new Runnable(){
				Client client = null;
			    @Override
			    public void run(){
			    	client = new Client(j);
					BallPool ballsPool = BallPool.getInstance();
					ballsPool.setMaxPoolSize(10);
					
					PooledBalls pooledBalls = ballsPool.getBall();
					client.rentBall(pooledBalls);
					
					client.play();
					
					ballsPool.returnBall(client.returnBall());
				}
			};

			Thread thread1 = new Thread(task1);
			thread1.start();	
		}		
	}
}