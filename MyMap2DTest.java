package Exe.EX3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MyMap2DTest{
	
	@Test
	public void DrawSegmentTest() {
		int[][] map1= new int[10][10]; //placement new array
		int[][] map2= new int[10][10]; //placement new array
		for(int x=0;x<10;x++) // for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++) // for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{	
				map1[x][y]=-1;//reset the array to white
				map2[x][y]=-1;//reset the array to white
			}
		}
		MyMap2D _map1= new MyMap2D(map1);//placement
		MyMap2D _map2 = new MyMap2D(map2);//placement
		
		Point2D p1 = new Point2D(8,9);//placement
		Point2D p2 = new Point2D(8,5);//placement
		_map1.drawSegment(p1, p2, MyMap2D.BLACK);//use of segment function in black color
		Point2D p3 = new Point2D(9,0);//placement
		Point2D p4 = new Point2D(9,4);//placement
		_map1.drawSegment(p3, p4, MyMap2D.BLACK);//use of segment function in black color
		_map2.drawSegment(p1, p3, MyMap2D.BLACK);//use of segment function in black color
		
		for(int x=0;x<10;x++) // for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++) // for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{
				assertEquals(_map1.getPixel(x,y),_map2.getPixel(x,y));
			}
		}
	}

	@Test
	public void drawRectAndDrawSegmentTest() {
		int[][] map1= new int[10][10]; //placement new array
		int[][] map2= new int[10][10]; //placement new array
		for(int x=0;x<10;x++) // for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)  // for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{	
				map1[x][y]=-1;//reset the array to white
				map2[x][y]=-1;//reset the array to white
			}
		}
		MyMap2D _map1= new MyMap2D(map1);//placement
		MyMap2D _map2 = new MyMap2D(map2);//placement
		Point2D p2;//placement
		Point2D p1;//placement
		for(int y=0;y<10;y++) // for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
		{
			p1 = new Point2D(0,y);//placement new point
			p2 = new Point2D(5,y);//placement new point
			_map1.drawSegment(p1,p2,MyMap2D.BLACK);//use of segment function in black color
		}
		p1 = new Point2D(0,0);//placement new point
		p2 = new Point2D(5,9);//placement new point
		_map2.drawRect(p1, p2, MyMap2D.BLACK);//use of segment function in black color
		
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{
				assertEquals(_map1.getPixel(x,y),_map2.getPixel(x,y));//tests the rect and the segment
			}
		}
	}
	
	@Test
	public void drawCircleTest() {
		int[][] map1= new int[10][10]; //placement new array
		int[][] map2= new int[10][10]; //placement new array
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{	
				map1[x][y]=-1;//reset the array to white
				map2[x][y]=-1;//reset the array to white
			}
		}
		MyMap2D _map1= new MyMap2D(map1);
		MyMap2D _map2 = new MyMap2D(map2);
		Point2D p1 = new Point2D(5,5);//placement new point
		double radius = 3; //placement
		_map1.drawCircle(p1,radius ,MyMap2D.BLACK);//use of  circle function in black color
		Point2D p3 = new Point2D(3,3);//placement new point
		Point2D p4 = new Point2D(7,7);//placement new point
		_map2.drawRect(p3, p4, MyMap2D.BLACK);
		_map2.setPixel(2,5, MyMap2D.BLACK);
		_map2.setPixel(5,2, MyMap2D.BLACK);
		_map2.setPixel(5,8, MyMap2D.BLACK);
		_map2.setPixel(8,5, MyMap2D.BLACK);
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{
				assertEquals(_map1.getPixel(x,y),_map2.getPixel(x,y));
			}
		}
	}
	
	@Test
	public void fillTest() {
		int[][] map1= new int[10][10];//placement new array
		int[][] map2= new int[10][10];//placement new array
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{	
				map1[x][y]=-1;//reset the array to white
				map2[x][y]=-1;//reset the array to white
			}
		}
		MyMap2D _map1= new MyMap2D(map1);
		MyMap2D _map2 = new MyMap2D(map2);
		Point2D p1 = new Point2D(5,1);//placement new point
		Point2D p2 = new Point2D(5,9);//placement new point
		_map1.drawSegment(p1,p2 ,MyMap2D.BLACK);//use of segment function in black color
		_map2.drawSegment(p1,p2 ,MyMap2D.BLACK);//use of segment function in black color
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{	
				if(_map1.getPixel(x,y)==MyMap2D.WHITE)_map1.setPixel(x,y,2);
			}
		}
		p1 = new Point2D(0,0);//placement new point
		MyMap2D.P=p1;
		_map2.fill(p1,2);
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{
				assertEquals(_map1.getPixel(x,y),_map2.getPixel(x,y));
			}
		}
	}
	
	@Test
	public void fill2Test() {
		int[][] map1= new int[10][10];//placement new array
		int[][] map2= new int[10][10];//placement new array
		for(int x=0;x<10;x++)
		{
			for(int y=0;y<10;y++)
			{	
				map1[x][y]=-1;//reset the array to white
				map2[x][y]=-1;//reset the array to white
			}
		}
		MyMap2D _map1= new MyMap2D(map1);
		MyMap2D _map2 = new MyMap2D(map2);
		Point2D p1 = new Point2D(5,1);//placement new point
		Point2D p2 = new Point2D(5,9);//placement new point
		_map1.drawSegment(p1,p2 ,MyMap2D.BLACK);//use of segment function in black color
		_map2.drawSegment(p1,p2 ,MyMap2D.BLACK);//use of segment function in black color
		for(int x=0;x<10;x++)
		{
			for(int y=0;y<10;y++)
			{	
				if(_map1.getPixel(x,y)==MyMap2D.WHITE)_map1.setPixel(x,y,2);
			}
		}
		p1 = new Point2D(0,0);//placement new point
		MyMap2D.P=p1;//placement new point
		_map2.fill(p1.ix(),p1.iy(),2);
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{
				assertEquals(_map1.getPixel(x,y),_map2.getPixel(x,y));
			}
		}
	}

	@Test
	public void shortestPathTest() {
		int[][] map1= new int[10][10];//placement new array
		int[][] map2= new int[10][10];//placement new array
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{	
				map1[x][y]=-1;//reset the array to white
				map2[x][y]=-1;//reset the array to white
			}
		}
		MyMap2D _map1= new MyMap2D(map1);
		MyMap2D _map2 = new MyMap2D(map2);
		
		Point2D p1 = new Point2D(3,2);//placement new point
		Point2D p2 = new Point2D(3,9);//placement new point
		_map1.drawSegment(p1,p2,MyMap2D.color);
		MyMap2D.PshortestPath=p1;
		_map2.shortestPathDist(p1,p2);
		
		
		
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop in for loop that runs from 0 to the value of 10 and than add one each time to the Y
			{
				assertEquals(_map1.getPixel(x,y),_map2.getPixel(x,y));
			}
		}
	}
	
	@Test
	public void GolTest() {
		int[][] map1= new int[10][10];//placement new array
		int[][] map2= new int[10][10];//placement new array
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
			{	
				map1[x][y]=-1;//reset the array to white
				map2[x][y]=-1;//reset the array to white
			}
		}
		MyMap2D _map1= new MyMap2D(map1);
		MyMap2D _map2 = new MyMap2D(map2);
		_map1.setPixel(5,5, MyMap2D.BLACK);
		_map1.setPixel(5,6, MyMap2D.BLACK);
		_map1.setPixel(5,7, MyMap2D.BLACK);
		_map2.setPixel(4,6, MyMap2D.BLACK);
		_map2.setPixel(5,6, MyMap2D.BLACK);
		_map2.setPixel(6,6, MyMap2D.BLACK);
		_map2.nextGenGol();
		for(int x=0;x<10;x++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
		{
			for(int y=0;y<10;y++)// for loop that runs from 0 to the value of 10 and than add one each time to the X
			{
				assertEquals(_map1.getPixel(x,y),_map2.getPixel(x,y));
			}
		}
	}
	
}


/*
for(int x=0;x<10;x++)
		{			
			for(int y=0;y<10;y++)
			{	
				System.out.print(map1[x][y]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();

		for(int x=0;x<10;x++)
		{			
			for(int y=0;y<10;y++)
			{	
				System.out.print(map2[x][y]+" ");
			}
			System.out.println();
		}
		
System.out.println(_map1.getPixel(x,y)+" ,"+_map2.getPixel(x,y));
				System.out.println(x+" ,"+y);
				fail();
				
				
				
				
				
				p1 = new Point2D(2,2);
		p2 = new Point2D(2,9);
		_map2.drawSegment(p1,p2,MyMap2D.BLACK);
		p1 = new Point2D(4,2);
		p2 = new Point2D(4,9);
		_map2.drawSegment(p1,p2,MyMap2D.BLACK);
		_map2.setPixel(3,1,MyMap2D.BLACK);
		
		p1 = new Point2D(2,9);
		p2 = new Point2D(4,9);
		MyMap2D.color=MyMap2D.BLACK;
		MyMap2D.PshortestPath=p1;
		int shortestPath = _map1.shortestPathDist(p1,p2);
		//_map1.fill(p1,MyMap2D.BLACK);
		if(shortestPath<0)fail();
		
		for(int x=0;x<10;x++)
		{			
			for(int y=0;y<10;y++)
			{	
				System.out.print(_map1.getPixel(x,y)+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();

		for(int x=0;x<10;x++)
		{			
			for(int y=0;y<10;y++)
			{	
				System.out.print(_map2.getPixel(x,y)+" ");
			}
			System.out.println();
		}
		
		for(int x=0;x<10;x++)
		{
			for(int y=0;y<10;y++)
			{
				assertEquals(_map1.getPixel(x,y),_map2.getPixel(x,y));
			}
		}
			
		
*/