package Exe.EX3;

import java.awt.Color;
import java.util.Iterator;

/**
 * This class implements the Map2D interface.
 * You should change (implement) this class as part of Ex3. 
 * 
 * @author
 * ID1: 326648532
 * ID2: 
 * */
public class MyMap2D implements Map2D{
	private static final int WIDTH = 0;
	static Point2D FirstPoint;
	private int[][] _map;
	private String[] args;
	
	public MyMap2D(int w, int h) {init(w,h);}
	public MyMap2D(int size) {this(size,size);}
	
	public MyMap2D(int[][] data) { 
		this(data.length, data[0].length);
		init(data);
	}
	@Override
	public void init(int w, int h) {
		_map = new int[w][h];
		
	}
	@Override
	public void init(int[][] arr) {
		init(arr.length,arr[0].length);
		for(int x = 0;x<this.getWidth()&& x<arr.length;x++) {
			for(int y=0;y<this.getHeight()&& y<arr[0].length;y++) {
				this.setPixel(x, y, arr[x][y]);
			}
		}
	}
	@Override
	public int getWidth() {return _map.length;}
	@Override
	public int getHeight() {return _map[0].length;}
	@Override
	public int getPixel(int x, int y) { return _map[x][y];}
	@Override
	public int getPixel(Point2D p) { 
		return this.getPixel(p.ix(),p.iy());
	}
	
	public void setPixel(int x, int y, int v) {_map[x][y] = v;}
	public void setPixel(Point2D p, int v) { 
		setPixel(p.ix(), p.iy(), v);
	}
	
	public void drawSegmentLow(int x0,int y0,int x1, int y1, int v) {
		Point2D p1 = new Point2D(x0,y0);//Setting a new point
		Point2D p2 = new Point2D(x1,y1);//Setting a new point
		double dx=p2.ix()-p1.ix();//The X value at one point is less than the X value at a second point
		double dy=p2.iy()-p1.iy();//The Y value at one point is less than the Y value at a second point
		double yi = 1; // The Y value at place [i] is being 1
		
		if(dy<0) // if loop that means if the y value is under 0 will get into the loop
		{
			yi=-1; // placement
			dy=-dy; // placement
		}
		double D = 2*dy - dx; // variable definition
		int y=p1.iy(); // variable definition
		for(int x=p1.ix();x<p2.ix();x++) // for loop Starting from the X value of one point up to the X value at point I
		{
			this.setPixel(x,y,v); // Paints the point with a certain color
			if(D>0) { // if loop that check if the variable [D] bigger than 0
				y=(int)(y+yi); // variable definition and turns it into INT
				D = D+(2*(dy-dx)); // variable definition
			} else {D=D+2*dy;} // Defining a variable and another 2 times the Y value
		}
	}
	
	public void drawSegmentHigh(int x0,int y0,int x1, int y1, int v) {
		Point2D p1 = new Point2D(x0,y0); // variable definition
		Point2D p2 = new Point2D(x1,y1); // variable definition
		double dx=p2.ix()-p1.ix(); // The X value at one point minus the X value at a second point
		double dy=p2.iy()-p1.iy(); // The Y value at one point minus the Y value at a second point
		double xi = 1; //  variable definition
		
		if(dx<0) // IF loop that check if the value at x lowest then 0
		{
			xi=-1;//placement
			dx=-dx; // placement
		}
		double D = 2*dx - dy; // variable definition
		int x=p1.ix();  // variable definition
		for(int y=p1.iy();y<p2.iy();y++) // for loop that run from the Y value of one point to another point 
		{
			this.setPixel(x,y,v); // Draws a point on the map
			if(D>0) { // IF loop that check if D is bigger 0 
				x=(int)(x+xi); // variable definition
				D = D + (2*(dx-dy)); // variable definition
			}
			else {D=D+2*dx;} //Defining a variable and another 2 times the Y value
		}
	}
	
	@Override
	public void drawSegment(Point2D p1, Point2D p2, int v) {
		if(Math.abs(p2.iy()- p1.iy())<Math.abs(p2.ix()- p1.ix())) { // IF loop Checks if in absolute value the X value at one point minus the second point is greater in absolute value 
			//the second point is greater in absolute value  then the Y value at one point minus the second
			if(p1.ix()>p2.ix()) { // IF loop that check if the X value of one point biggest than other point  
				drawSegmentLow(p2.ix(),p2.iy(),p1.ix(),p1.iy(),v); // Using a helper function
				} else{
					drawSegmentLow(p1.ix(),p1.iy(),p2.ix(),p2.iy(),v); //   else Using a helper function
				}
			
		} else if(p1.iy()>p2.iy()){ // else if the y value of one point is biggest than other point 
				drawSegmentHigh(p2.ix(),p2.iy(),p1.ix(),p1.iy(),v); // Using a helper function
			}else {
			drawSegmentHigh(p1.ix(),p1.iy(),p2.ix(),p2.iy(),v); //    else Using a helper function
			}
		this.setPixel(p1,v); // placement
		this.setPixel(p2,v); // placement
	}

	@Override
	public void drawRect(Point2D p1, Point2D p2, int col) {
		double xMax=Math.max(p1.ix(), p2.ix());//gets the maximum between the x-point of p1 and the x-point of p2
		double xMin=Math.min(p1.ix(), p2.ix());//gets the minimum between the x-point of p1 and the x-point of p2
		double yMax=Math.max(p1.iy(), p2.iy());//gets the maximum between the y-point of p1 and the y-point of p2
		double yMin=Math.min(p1.iy(), p2.iy());//gets the minimum between the x-point of p1 and the x-point of p2

		for(int x=0;x<this.getWidth();x++) // for loop that run from 0 to width of all map
		{
			for(int y=0;y<this.getHeight();y++) // for loop in for loop that run from 0 to high of all map
			{
				if(x>=xMin &&x<=xMax && y>=yMin && y<=yMax)// if loop that check
				{
					this.setPixel(x,y,col);
					//The loop goes through all the elements in the array and checks whether the x-point and the y-point are within the range. If so, it paints the pixel with the new color
				}
			}
		}
	}

	@Override
	// A function creates a circle after 2 clicks on the map
	public void drawCircle(Point2D p , double  rad, int col) {
	
			for (int x = 0; x < this.getWidth(); x++) { // for loop that runs from 0 to the width of all the map
				for (int y = 0; y < this.getHeight(); y++) { // for loop in for loop that runs from 0 to the high of all the map
					double t = Math.pow(p.ix()-x,2)+Math.pow(p.iy()-y,2);//
					if (Math.sqrt(t) <= rad) {// if loop that check if root of T is lowest and worth to the radius
						this.setPixel(x, y, col); // placement

					}
				}

			}
		}
	static Point2D P;// Sets P to be the first point
	@Override
	public int fill(Point2D p, int new_v) {
		int [][]map = new int[this.getWidth()][this.getHeight()];  
		int colorFill=this.getPixel(P);
		for(int x=0;x<this.getWidth();x++){//for loop that run from the value X to the width of all map and if so advances the variable
			for(int y=0;y<this.getHeight();y++) // for loop in for loop that runs from the value Y to the high of all map and if so advances the variable
			{
				if(this.getPixel(x,y)==colorFill)map[x][y]=-1; // if loop that check if the point in place of (x,y) is Worth to the color of point P will be the color white 
				if(this.getPixel(x,y)!=colorFill)map[x][y]=-2; // if loop that check if the point in place of (x,y) is not Worth to the color of point P will be the other color
			}
		}

		map[p.ix()][p.iy()]=0; // point in place of value X and value Y will be 0		
	while(radius<this.getWidth()*this.getHeight()) //the maximal path
	{
	for(int x=0;x<this.getWidth();x++)// for loop that runs from 0 to the width of all the map if run add one to value of X 
	{
		for(int y=0;y<this.getHeight();y++)// for loop in for loop that runs from 0 to the high of all the map if run add one to value of x 
		{
			if(map[x][y]==radius) { // if loop point that check if point in the place of value X and y  is worth to the radius
				if(x+1>=0 && x+1<this.getWidth() && y>=0 && y<this.getHeight()) {if(map[x+1][y]==-1) {map[x+1][y]=radius+1;}}
				//if loop point that check if point in the place of value X +1  and value of Y biggest or worth to 0 and will be in white color than add to the radius one
				if(x-1>=0 && x-1<this.getWidth() && y>=0 && y<this.getHeight()) {if(map[x-1][y]==-1 ) {map[x-1][y]=radius+1;}}
				//if loop point that check if point in the place of value X -1  and value of Y biggest or worth to 0 and will be in white color than add to the radius one
				if(x>=0 && x<this.getWidth() && y-1>=0 && y-1<this.getHeight()){if(map[x][y-1]==-1 ) {map[x][y-1]=radius+1;}}
				//if loop point that check if point in the place of value X worth or biggest to 0  and value of Y biggest or worth to 0 and will be in white color than add to the radius one
				if(x>=0 && x<this.getWidth() && y+1>=0 && y+1<this.getHeight()) {if(map[x][y+1]==-1) {map[x][y+1]=radius+1;}}
				//if loop point that check if point in the place of value X +1  and value of Y+1 biggest or worth to 0 and will be in white color than add to the radius one
			}
		}
	}
	radius++; // add to the radius one
	}	
	int count=0; // placement
	for(int x=0;x<this.getWidth();x++) // for loop that runs from 0 to all of width of all map
	{
		for(int y=0;y<this.getHeight();y++) // for loop in for loop that runs from 0 to the high of all the map
		{	
			if(map[x][y]>=0 && this.getPixel(x, y)==colorFill) { // if loop that check if the point in the value of X and Y bigger than 0 and worth to the color 
			this.setPixel(x,y,new_v); // placement 
			count++; // if run in the loop add to count one
			}
		}
	}
	radius=0;//placement
	return count; 
	}

	@Override
	public int fill(int x, int y, int new_v) {
		int [][]map = new int[this.getWidth()][this.getHeight()];
		int colorFill=this.getPixel(P);
		for(int x1=0;x1<this.getWidth();x1++)// for loop that run from 0 to the width of all the map
		{
			for(int y1=0;y1<this.getHeight();y1++) // for loop in for loop that runs from 0 to the high of all the map
			{
				if(this.getPixel(x1,y1)==colorFill)map[x1][y1]=-1;//if loop that check if the point in the value of X and Y bigger than 0 and worth to the  white color 
				if(this.getPixel(x1,y1)!=colorFill)map[x1][y1]=-2;//if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 
			}
		}
		map[x][y]=0;		
	while(radius<this.getWidth()*this.getHeight()) //the maximal path
	{
	for(int x1=0;x1<this.getWidth();x1++)// for loop that run from 0 to the width of all the map
	{
		for(int y1=0;y1<this.getHeight();y1++) // for loop in for loop that runs from 0 to the high of all the map
		{
			if(map[x1][y1]==radius) { // if loop that check if the point in the value of X and Y is worth to the radius
				if(x1+1>=0 && x1+1<this.getWidth() && y1>=0 && y1<this.getHeight()) {if(map[x1+1][y1]==-1) {map[x1+1][y1]=radius+1;}}
				//if loop point that check if point in the place of value X +1  and value of Y biggest or worth to 0 and will be in white color than add to the radius one

				if(x1-1>=0 && x1-1<this.getWidth() && y1>=0 && y1<this.getHeight()) {if(map[x1-1][y1]==-1 ) {map[x1-1][y1]=radius+1;}}
				//if loop point that check if point in the place of value X +1  and value of Y biggest or worth to 0 and will be in white color than add to the radius one

				if(x1>=0 && x1<this.getWidth() && y1-1>=0 && y1-1<this.getHeight()){if(map[x1][y1-1]==-1 ) {map[x1][y1-1]=radius+1;}}
				//if loop point that check if point in the place of value X +1  and value of Y biggest or worth to 0 and will be in white color than add to the radius one

				if(x1>=0 && x1<this.getWidth() && y1+1>=0 && y1+1<this.getHeight()) {if(map[x1][y1+1]==-1) {map[x1][y1+1]=radius+1;}}
				//if loop point that check if point in the place of value X +1  and value of Y biggest or worth to 0 and will be in white color than add to the radius one

			}
		}
	}
	radius++; // add to the radius one
	}
	int count=0; // placement
	for(int x1=0;x1<this.getWidth();x1++) // for loop that run from 0 to the width of all the map
	{
		for(int y1=0;y1<this.getHeight();y1++) // for loop in for loop that runs from 0 to the high of all the map
		{	
			if(map[x1][y1]>=0 && this.getPixel(x1, y1)==colorFill) { // if loop that check if the point in the value of X and Y bigger than 0 and worth to the color 
			this.setPixel(x1,y1,new_v); // placement
			count++;
			}
		}
	}
	radius=0; //placement
	return count;
	}
	
	public boolean distanceEqualOne(Point2D p1,Point2D p2) {
		if(p1.iy()== p2.iy() && Math.max(p1.ix(),p2.ix())-Math.min(p1.ix(),p2.ix())==1)return true;
		// if loop that check if the point in the value of X and Y bigger than 0 and worth to the color if yes return true
		if(p1.ix()== p2.ix() && Math.max(p1.iy(),p2.iy())-Math.min(p1.iy(),p2.iy())==1)return true;
		// if loop that check if the point in the value of X and Y bigger than 0 and worth to the color if yes return true

		return false; 
		// if not return false
	}
	
	static int radius=0;
	static Point2D PshortestPath;
	@Override
	public Point2D[] shortestPath(Point2D p1, Point2D p2) {
			if(p1.ix()==p2.ix()&&p1.iy()==p2.iy())
				// if loop that check if the point in the value of X and Y bigger than 0 and worth to the color if yes return true
{
				Point2D [] shortestPathArray1 = new Point2D[1]; // placement
				shortestPathArray1[0]=new Point2D(p2); // placement
				return shortestPathArray1; 
			}
		int [][]map = new int[this.getWidth()][this.getHeight()]; //placement
		int colorShortestPath=this.getPixel(PshortestPath); 
			for(int x=0;x<this.getWidth();x++)// for loop that run from 0 to the width of all the map
			{
				for(int y=0;y<this.getHeight();y++)// for loop in for loop that runs from 0 to the high of all the map
				{
					if(this.getPixel(x,y)==colorShortestPath)map[x][y]=-1;
					// if loop that check if the point in the value of X and Y bigger than 0 and worth to the  white color
					if(this.getPixel(x,y)!=colorShortestPath)map[x][y]=-2;
					// if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 
				}
			}
			map[p2.ix()][p2.iy()]=-1; // // if loop that check if the point in the value of X and Y bigger than 0 and worth to the white  color  
			map[p1.ix()][p1.iy()]=0; // if loop that check if the point in the value of X and Y bigger than 0 and worth to the other color 	
     		Point2D End = new Point2D(-1,-1); // placement
		while((End.ix()==p2.ix()&& End.iy()==p2.iy())==false)  //the maximal path
		{
		for(int x=0;x<this.getWidth();x++) // for loop that run from 0 to the width of all the map
		{
			for(int y=0;y<this.getHeight();y++) // for loop in for loop that runs from 0 to the high of all the map
			{
				End = new Point2D(x,y); // Setting up a new point
				if(map[x][y]==radius) { // if the point of value X Y is worth to the radius
					if(End.ix()==p2.ix()&& End.iy()==p2.iy()) {y=this.getHeight();x=this.getWidth();End=p2;}else {
						// if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 

					if(x+1>=0 && x+1<this.getWidth() && y>=0 && y<this.getHeight()) {if(map[x+1][y]==-1) {map[x+1][y]=radius+1;}}
					// if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 

					if(x-1>=0 && x-1<this.getWidth() && y>=0 && y<this.getHeight()) {if(map[x-1][y]==-1 ) {map[x-1][y]=radius+1;}}
					// if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 

					if(x>=0 && x<this.getWidth() && y-1>=0 && y-1<this.getHeight()){if(map[x][y-1]==-1 ) {map[x][y-1]=radius+1;}}
					// if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 

					if(x>=0 && x<this.getWidth() && y+1>=0 && y+1<this.getHeight()) {if(map[x][y+1]==-1) {map[x][y+1]=radius+1;}}
					// if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 

					}
				}
			}
		}
		if(radius>this.getWidth()*this.getHeight()) {;return null;}//return null if It is not possible to pass a road between these two points
		radius++;
		}
		Point2D [] shortestPathArray = new Point2D[radius]; //placement
		shortestPathArray[0]=new Point2D(p2); // placement
		for(int i=0;i<shortestPathArray.length;i++) // for loop that run from 0 to the length of short way if turn in than add to i one each time 
		{
			for(int x=0;x<this.getWidth();x++)  // for loop in for loop that runs from 0 to the width of all the map
			{
				for(int y=0;y<this.getHeight();y++) // for loop in for loop that runs from 0 to the high of all the map
				{
					Point2D a = new Point2D(x,y); // placement
					if(map[x][y]==(radius-2) && distanceEqualOne(shortestPathArray[i],a)) { // if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 
						shortestPathArray[i+1]=new Point2D(x,y); // placement
						if((radius-2)==0) {i=shortestPathArray.length;} // if loop that check if the point in the value of X and Y bigger than 0 and worth to the  other color 
						y=this.getHeight(); // placement
						x=this.getWidth(); // placement
					}
				}
			}
			radius--;
		}
		radius=0;
		return shortestPathArray;
	}
	static int color; 
	@Override
	public int shortestPathDist(Point2D p1, Point2D p2) {
		Point2D [] shortestPathArray = shortestPath(p1,p2);
		if(shortestPathArray==null)return 0;
		//return null if It is not possible to pass a road between these two points
		
		for(int i=0;i<shortestPathArray.length;i++) { //for loop that run from 0 to the length of short way if turn in than add to i one each time 
			this.setPixel(shortestPathArray[i],color); 
		}
		return shortestPathArray.length;
	}

	@Override
	public void nextGenGol() {
		Point2D [] Add = new Point2D[8];
		Add[0] = new Point2D(-1,0);
		Add[1] = new Point2D(0,1);
		Add[2] = new Point2D(0,-1);
		Add[3] = new Point2D(1,1);
		Add[4] = new Point2D(1,0);
		Add[5] = new Point2D(1,-1);
		Add[6] = new Point2D(-1,-1);
		Add[7] = new Point2D(-1,1);
		int count=0;
		int [][]map = new int[getWidth()][getHeight()];
		for(int x=0;x<this.getWidth();x++) //for loop that run from 0 to the length of short way if turn in than add to i one each time 
		{
			for(int y=0;y<this.getHeight();y++)//for loop in for loop that run from 0 to the length of short way if turn in than add to i one each time 
			{
		map[x][y]=WHITE; // placement in value of X Y the color white
			}
		}
		for(int x=0;x<this.getWidth();x++) //for loop that run from 0 to the length of short way if turn in than add to i one each time 
		{
			for(int y=0;y<this.getHeight();y++) //for loop in for loop  that run from 0 to the length of short way if turn in than add to i one each time 
			{
				Point2D p = new Point2D(x,y); // placement
				for(int i=0;i<8;i++) //for loop that run from 0 to the length of short way if turn in than add to i one each time 
				{
					if(x+Add[i].ix()>=0 && x+Add[i].ix()<this.getWidth() && y+Add[i].iy()>=0 && y+Add[i].iy()<this.getHeight()) {
						//for loop that run from 0 to the length of short way if turn in than add to i one each time 
				Point2D pAdd = p.add(Add[i]); // placement
				if(this.getPixel(pAdd)==BLACK) {count++;}// if loop that check if  point in place is worth to the color black
					}
			    }
				if(this.getPixel(x,y)==WHITE && count==3) {map[x][y] = BLACK;}
				// if loop that check if  point in place of X AND y is worth to the color white and if count is worth to the number 3 than the point of place X and y than put the color black
				if(this.getPixel(x,y)==BLACK && (count==2 || count==3)) {map[x][y] = BLACK;}
				// if loop that check if  point in place of X AND y is worth to the color black and if count is worth to the number 3 than the point of place X and y than put the color black

				count=0;
			}
		}
		for(int x=0;x<this.getWidth();x++)// for loop that run from o to the width of all the map
		{
			for(int y=0;y<this.getHeight();y++)//for loop in for loop  that run from 0 to the length of high if turn in than add to y one each time 
			{
		_map[x][y]=map[x][y];//placement
			}
		}
	}
	
	@Override
	public void fill(int c) {
		for(int x = 0;x<this.getWidth();x++) {
			for(int y = 0;y<this.getHeight();y++) {
				this.setPixel(x, y, c);
			}
		}
		
	}
	}
