import java.util.LinkedList;
import java.util.List;

public class BallPool {
	private int maxTotalBalls = 0;
	private int currentCapacity = 0;
	
	static List<PooledBalls> free = new LinkedList<>();
	List<PooledBalls> used = new LinkedList<>();
	
	public static BallPool instance = null;
	
	public static BallPool getInstance() {
		synchronized (free) {
			if (instance == null) {
				instance = new BallPool();
			}
			else {
				System.out.println("This is singleton!");
			}
			return instance;
		}
	}
	
	public PooledBalls getBall() {
		synchronized (free) {
			if(free.isEmpty()) {
				PooledBalls pooledBalls = new PooledBalls();
				used.add(pooledBalls);
				return pooledBalls;
			} else {
				PooledBalls pooledBalls = free.get(0);
				used.add(pooledBalls);
				free.remove(pooledBalls);
				currentCapacity--;
				return pooledBalls;
			}
		}
	}
	
	public void returnBall(PooledBalls pooledBalls) {
		synchronized (free) {
			if (currentCapacity <= maxTotalBalls) {
				used.remove(pooledBalls);
				currentCapacity++;
				free.add(pooledBalls);
			}
			else {
				System.out.println("Too much balls.");
			}
		}
	}
	
	public int setMaxPoolSize(int poolSize) {
		maxTotalBalls = poolSize;
		return maxTotalBalls;
	}
}
