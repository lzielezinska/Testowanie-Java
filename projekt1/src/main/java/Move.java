public class Move {
	private int xPos;
	private int yPos;
	private int id;
	private Sign sign;
	
	public Move(int xPos, int yPos, int id, Sign sign) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.id = id;
		this.sign = sign;
	}
	
	public int getxPos() {
		return xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
	
	public int getId() {
		return id;
	}
	
	public Sign getSign() {
		return sign;
	}
	

}
