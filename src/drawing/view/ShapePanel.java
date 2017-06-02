package drawing.view;

import javax.imageio.ImageIO;
import  javax.swing.*;
import drawing.controller.DrawingController;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;

public class ShapePanel extends JPanel
{
	private DrawingController baseController;
	private ArrayList<Shape> rectangleList;
	private ArrayList<Shape> triangleList;
	private ArrayList<Shape> circleList;
	private ArrayList<Shape> ellipseList;
	private ArrayList<Shape> polygonList;
	private ArrayList<ArrayList <Shape>> shapes;
	
	
	public ShapePanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		rectangleList = new ArrayList<Shape>();
		circleList = new ArrayList<Shape>();
		ellipseList = new ArrayList<Shape>();
		triangleList = new ArrayList<Shape>();
		polygonList = new ArrayList<Shape>();
		shapes = new ArrayList<ArrayList <Shape>>();
		
		shapes.add(circleList);
		shapes.add(rectangleList);
		shapes.add(ellipseList);
		shapes.add(triangleList);
		shapes.add(polygonList);
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.cyan);
		this.setMinimumSize(new Dimension(250, 500));
	}
	
	private Color getRandomColor()
	{
		int alpha = (int) (Math.random() * 255);
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		
		return new Color(red, green, blue, alpha);
	}
	
	public void addRectangles()
	{
		for(int index = 0; index < 500; index++)
		{
			int width = (int) (Math.random() * 120) + 1;
			int height = (int) (Math.random() * 150) + 15;
			int xCorner = (int) (Math.random() * this.getWidth() - 15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			
			Rectangle currentRectangle = new Rectangle(xCorner, yCorner, width, height);
			rectangleList.add(currentRectangle);
		}
		this.repaint();
	}
	public void addCircles()
	{
		if(circleList.size() > 500)
		{
			circleList.clear();
		}
		for(int index = 0; index < 30; index++)
		{
			int radius = (int) (Math.random() * 25) + 2;
			int xCorner = (int) (Math.random() * this.getWidth() - 15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, radius, radius);
			circleList.add(current);
		}
	}
	public void addEllipses()
	{
		if(ellipseList.size() > 500)
		{
			ellipseList.clear();
		}
		for(int index = 0; index < 30; index++)
		{
			int xradius = (int) (Math.random() * 50) * 2 + 1;
			int yradius = (int) (Math.random() * 50) + 2;
			int xCorner = (int) (Math.random() * this.getWidth() - 15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, xradius, yradius);
			ellipseList.add(current);
		}
	}
	public void addTriangles()
	{
		if(triangleList.size() > 500)
		{
			triangleList.clear();
		}
		for(int index = 0; index < 30; index++)
		{
			int vertexCount = 3;
			int [] xVertices = new int [vertexCount];
			int [] yVertices = new int [vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner = (int) (Math.random() * this.getWidth());
				int yCorner = (int) (Math.random() * this.getHeight());
				xVertices[vertex] = xCorner;
				yVertices[vertex] = yCorner;
			}
			Polygon current = new Polygon(xVertices, yVertices, vertexCount);
			triangleList.add(current);
		}
		this.repaint();
	}
	public void addPolygon()
	{
		if(polygonList.size() > 500)
		{
			polygonList.clear();
		}
		for(int index = 0; index < 30; index++)
		{
			int vertexCount = (int) (Math.random() * 7) + 4;
			int [] xVertices = new int [vertexCount];
			int [] yVertices = new int [vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner = (int) (Math.random() * this.getWidth());
				int yCorner = (int) (Math.random() * this.getHeight());
				xVertices[vertex] = xCorner;
				yVertices[vertex] = yCorner;
			}
			Polygon current = new Polygon(xVertices, yVertices, vertexCount);
			polygonList.add(current);
		}
		this.repaint();
	}
	public void reset()
	{
		for(int index = 0; index < shapes.size(); index++)
		{
			shapes.get(index).clear();
		}
		this.setBackground(getRandomColor());
		this.repaint();
	}
	
	protected void paintComponent(Graphics graphics)
	{
		Graphics2D drawingGraphics = (Graphics2D) graphics;
		
		for(ArrayList<Shape> currentList : shapes)
			{
			drawShapes(currentList, drawingGraphics);
			}
//		//this.setBackground(getRandomColor()); SEZURE WARNING
//		Graphics2D drawingGraphics = (Graphics2D) graphics;
//		for(Rectangle currentRectangle : rectangleList)
//		{
//			drawingGraphics.setColor(getRandomColor());
//			int strokeWidth = (int) (Math.random() * 10) + 1;
//			drawingGraphics.setStroke(new BasicStroke(strokeWidth));
//			
//			int randomness = (int) (Math.random() * 35);
//			if(randomness % 5 == 0 || randomness % 7 == 0)
//			{
//				drawingGraphics.fill(currentRectangle);
//			}
//			else
//			{
//				drawingGraphics.draw(currentRectangle);
//			}
//		}
	}
	
	private void drawShapes(ArrayList<Shape> shapeList, Graphics2D graphics)
	{
		for(Shape currentShape : shapeList)
		{
			graphics.setColor(getRandomColor());
			int strokeWidth = (int) (Math.random() * 10) +1;
			graphics.setStroke(new BasicStroke(strokeWidth));
			
			int randomness = (int) (Math.random() * 35);
			
			if(randomness % 5 == 0 || randomness % 7 == 0)
			{
				graphics.fill(currentShape);
				graphics.setColor(getRandomColor());
				graphics.draw(currentShape);
			}
			else
			{
				graphics.draw(currentShape);
			}
		}
	}
	
	public void savePanel()
	{
		BufferedImage panelImage = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB);
		Graphics fileGraphics = panelImage.getGraphics();
		
		Color background = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue());
		fileGraphics.setColor(background);
		fileGraphics.fillRect(0, 0, this.getSize().width, this.getSize().height);
		this.printAll(fileGraphics);
		fileGraphics.dispose();
		
		try
		{
			ImageIO.write(panelImage, "png", new File("My Modern art " + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + ".png"));
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(this, "Save failed");
		}
	}

}
