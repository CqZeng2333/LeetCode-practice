import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 打开转盘锁
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:15:08
 */
public class _752 {
	
	public int openLock(String[] deadends, String target) {
		if (deadends == null || target == null) {
			return -1;
		}
		
		HashSet<String> isVisited = new HashSet<>();
		for (int i = 0; i < deadends.length; i++) {
			isVisited.add(deadends[i]);
		}
		String root = "0000";
		Queue<String> queue = new LinkedList<>();
		if (!isVisited.contains(root)) {
			queue.add(root);
		}
		int step = 0;
		
		while (!queue.isEmpty()) {
			int qz = queue.size();
			for (int i = 0; i < qz; i++) {
				String temp = queue.poll();
				if (temp.equals(target)) {
					return step;
				}
				
				for (int j = 0; j < 4; j++) {
					String up = this.addOne(temp, j);
					if (!isVisited.contains(up)) {
						queue.add(up);
						isVisited.add(up);
					}
					
					String down = this.minusOne(temp, j);
					if (!isVisited.contains(down)) {
						queue.add(down);
						isVisited.add(down);
					}
					
				}
			}
			step++;
		}
		return -1;
    }
	
	private String addOne(String s, int index) {
		char[] ch = s.toCharArray();
		int n = ch[index] - '0';
		ch[index] = (char) ((n + 1) % 10 + '0');
		return new String(ch);
	}
	
	private String minusOne(String s, int index) {
		char[] ch = s.toCharArray();
		int n = ch[index] - '0';
		ch[index] = (char) ((n + 9) % 10 + '0');
		return new String(ch);
	}
}
