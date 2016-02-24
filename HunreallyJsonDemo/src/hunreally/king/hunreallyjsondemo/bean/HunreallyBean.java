package hunreally.king.hunreallyjsondemo.bean;

import java.util.List;


public class HunreallyBean {

	public String name;
	public int age;
	public int toal;
	public List<HunreallyAddress> address;
	@Override
	public String toString() {
		return "HunreallyBean [name=" + name + ", age=" + age + ", address="
				+ address + "]";
	}
	
}
