package drawing.view;

import javax.swing.*;
import drawing.controller.DrawingController;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private SpringLayout baseLayout;
	private JButton rectangleButton;
	private JButton triangleButton;
	private JButton circleButton;
	private JButton ellipseButton;
	private JButton polygonButton;
	private JButton resetButton;
	private ShapePanel shapePanel;
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		shapePanel = new ShapePanel(baseController);
		rectangleButton = new JButton("Draw Rectangles");
		triangleButton = new JButton("Draw Triangles");
		circleButton = new JButton("Draw Circles");
		ellipseButton = new JButton("Draw Ellipses");
		polygonButton = new JButton("Draw Polygons");
		resetButton = new JButton("Reset");
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 6, SpringLayout.SOUTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 10, SpringLayout.WEST, polygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 6, SpringLayout.SOUTH, ellipseButton);
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, ellipseButton, 6, SpringLayout.SOUTH, circleButton);
		baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 4, SpringLayout.SOUTH, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, triangleButton, 6, SpringLayout.SOUTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 164, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.gray);
		this.setMinimumSize(new Dimension(600, 600));
		
		this.add(rectangleButton);
		this.add(triangleButton);
		this.add(circleButton);
		this.add(ellipseButton);
		this.add(polygonButton);
		this.add(resetButton);
		this.add(shapePanel);
	}
	private void setupLayout()
	{

		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 346, SpringLayout.NORTH, this);
	}
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
		});
		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangles();
			}
		});
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircles();
			}
		});
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipses();
			}
		});
		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
			}
		});
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.reset();
			}
		});
	}
	
//set 500x300
}
