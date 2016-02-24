package hunreally.king.hunreallyhttpdemo.bean;

import java.util.List;

public class User {
	public List<Info> info;
	public String name;
	@Override
	public String toString() {
		return "User [info=" + info + ", name=" + name + "]";
	}
	
}
