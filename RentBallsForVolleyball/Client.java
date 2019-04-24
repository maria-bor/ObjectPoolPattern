import java.util.Random;

public class Client {
	PooledBalls ball;
	final int id;
	
	public Client(int id) {
		Random r = new Random(); 
		this.id = r.nextInt(10000);
		System.out.println("New Client will sleep "+ this.id + "sec. during playing");
	}
	public void rentBall(PooledBalls ball) {
		this.ball = ball;
		System.out.println("Client " + id + " rent a ball for a game.");
	}
	
	public void play() {
		try {
			Thread.sleep(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Client " + id + " is playing in volleyball...");
	}
	
	public PooledBalls returnBall() {
		System.out.println("Client " + id + " return rented ball to store.");
		return ball;
	}
}
