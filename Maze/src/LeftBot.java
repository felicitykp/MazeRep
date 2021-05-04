import java.awt.Color;

public class LeftBot extends Bot{
	
	boolean happy = true;
	
	int happyNum = 0;
	int turnNum = 0;
	boolean start = true;
	

	//constructor
	public LeftBot(MazeRunner mr, Color c) {
		super(mr, c);
	}
	
	public void move() {
		
		
		
		//if starting move
		if(start) {
			maze.move(this);
			start = false;	
		} 
		
		//if not start
		else {
			
			//if happy and hasnt turned
			if(happy == true && happyNum == 0) {
				maze.turnLeft(this);
				happyNum = 1;	
			} 
			
			//if happy and has turned
			else if (happy == true && happyNum == 1) {
				happyNum = 0; //reset value
				if(maze.move(this)) { //check move
					happy = true;
				} else {
					happy = false;
				}
				
			//if not happy
			} else {
				
				
				if(turnNum == 3) {
					
					if(maze.move(this)) {
						happy = true;
						turnNum = 0;
					} else {
						happy = false;
						turnNum = 0;
					}

				} else {
					maze.turnLeft(this);
					turnNum++;
				}
			}
			
			
		}
		
	
		
	}

	
	// 1 turn left
	// 2 try moving
	// if work repear
	//if not turn right
}
