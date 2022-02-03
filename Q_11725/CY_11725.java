package ex06.oop;

 class Point{
	private int x,y; // 멤버변수
	
	// 멤버 함수
	// getter | setter
	public int getX() {
		return x;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	// getter | setter
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	
	
	//user method : output
	public void display() {
		System.out.println(x + ", " + y);
		System.out.println(getX() + ", " + getY());
	}
}

public class MainEntry {
	public static void main(String[] args) {
		Point pt =	new Point();
		pt.display();
//		System.out.println(pt.getX() + ", " + pt.getY());
//		pt.x = 90;
//		pt.y = 80;
		pt.setX(90);
		pt.setY(80);
		pt.display();
//		System.out.println(pt.getX() + ", " + pt.getY());
		
	}
}
