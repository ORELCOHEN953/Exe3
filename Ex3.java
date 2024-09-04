package Exe.EX3;

import java.awt.Color;

/**
 * This class is a simple "inter-layer" connecting (aka simplifing) the
 * StdDraw_Ex3 with the Map2D interface.
 * Written for 101 java course it uses simple static functions to allow a 
 * "Singleton-like" implementation.
 * You should change this class!
 * 
 * @author
 * ID1: 326648532
 * ID2: 
 */
public class Ex3 {
	private static  Map2D _map = null;
	static Color _color = Color.blue;
	private static String _mode = "";
	public static final int WHITE = Color.WHITE.getRGB();
	public static final int BLACK = Color.BLACK.getRGB();
	static Point2D Prev_point;


	public static void main(String[] args) {
		int dim = 10;  // init matrix (map) 10*10
		init(dim);
	}
	private static void init(int x) {
		StdDraw_Ex3.clear();
		_map = new MyMap2D(x);
		StdDraw_Ex3.setScale(-0.5, _map.getHeight()-0.5);
		StdDraw_Ex3.enableDoubleBuffering();
		_map.fill(WHITE);
		drawArray(_map);		
	}
	
	 public static void drawGrid(Map2D map) {
		 int w = map.getWidth();
		 int h = map.getHeight();
		 for(int i=0;i<w;i++) {
			 StdDraw_Ex3.line(i, 0, i, h);
		 }
		 for(int i=0;i<h;i++) {
			 StdDraw_Ex3.line(0, i, w, i);
		 }
	}
	static public void drawArray(Map2D a) {
		StdDraw_Ex3.clear();
		StdDraw_Ex3.setPenColor(Color.gray);
		drawGrid(_map);
		for(int y=0;y<a.getWidth();y++) {
			for(int x=0;x<a.getHeight();x++) {
				int c = a.getPixel(x, y);
				StdDraw_Ex3.setPenColor(new Color(c));
				drawPixel(x,y);
			}
		}		
		StdDraw_Ex3.show();
	}
	public static void actionPerformed(String p) {
		_mode = p;
		if(p.equals("Blue")) {_color = Color.BLUE; }
		if(p.equals("White")) {_color = Color.WHITE; }
		if(p.equals("Black")) {_color = Color.BLACK; }
		if(p.equals("Red")) {_color = Color.RED; }
		if(p.equals("Yellow")) {_color = Color.YELLOW; }
		if(p.equals("Green")) {_color = Color.GREEN; }

		if(p.equals("Clear")) {	init(_map.getWidth());}
		if(p.equals("20x20")) {init(20);}
		if(p.equals("40x40")) {init(40);}
		if(p.equals("80x80")) {init(80);}
		if(p.equals("160x160")) {init(160);}

		drawArray(_map);
		
	}
 	// Defining a function that identifies the point based on the click in the system 
    // saves it  for  the performing  actions
	public static void mouseClicked(Point2D p) {
		System.out.println(p);//print the point 
		int col = _color.getRGB();//placement
		if(_mode.equals("Point")) { // if loop that check if the mode function is worth to the value point
			_map.setPixel(p,col );
		}
		
		if(_mode.equals("Segment")) {
			if(Prev_point==null) { // if loop that check if the last point is worth to noting
				Prev_point = p; // if turn in to the loop than put in the last point the value p
			_map.setPixel(p,col ); // placement
			}else {
				_map.setPixel(p,col );// placement
				_map.drawSegment(Prev_point,p,col);
				Prev_point = null;// placement last point to nothing
			}
		}
		
		if(_mode.equals("Rect")) {
			if(Prev_point==null) { //  if loop that check if the placement of last point is nothing
				_map.setPixel(p,col ); //placement
				Prev_point = p; //placement
		}else {
				_map.drawRect(Prev_point,p,col); //placement
				Prev_point = null; //placement the last point to noting
			}
		}
		
		if(_mode.equals("Circle")) {
			if(Prev_point==null) { // if loop check if the placement in the last point is noting
				Prev_point = p;//placement the last point to the value p 
			}else {
				_map.drawCircle(Prev_point,(int)Prev_point.distance(p),col); //placement
				Prev_point = null;//placement the last point to the value of noting
			}
		}
		
		if(_mode.equals("Fill")) { // if loop that check that the function mode is worth to fill
				MyMap2D.P=p;//placement
				System.out.println("the number of the Pixels are "+_map.fill(p,col));
				_mode = "none"; //placement the mode to the value of noting
			}
		
		if(_mode.equals("ShortestPath")) {
			if(Prev_point==null) { // if loop that check if the placement of the last point is the value of noting
				MyMap2D.PshortestPath=p;//placement
				Prev_point = p;	//placement		
		}else {
			MyMap2D.color=col; //placement
			int shortestPathDist =_map.shortestPathDist(Prev_point,p);
			if(shortestPathDist>0)  { // if loop that check if the short way is above than 0
			System.out.println("the length of the Shortest Path is "+shortestPathDist);
			}else {
				System.out.println("It is not possible to pass a road between these two points");
			}
			Prev_point = null;//placement the last point to the value noting
			_mode = "none";//placement
		}
		}
		if(_mode.equals("Gol")) {
			_map.nextGenGol();	
		}
		drawArray(_map);
	}
	
	static private void drawPixel(int x, int y) {
		StdDraw_Ex3.filledCircle(x, y, 0.3);
	}
}
