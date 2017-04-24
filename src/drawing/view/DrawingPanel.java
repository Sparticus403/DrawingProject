package drawing.view;

import javax.swing.*;
import drawing.controller.DrawingController;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.*;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private SpringLayout baseLayout;
	private JButton rectangleButton;
	private ShapePanel shapePanel;
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		shapePanel = new ShapePanel(baseController);
		rectangleButton = new JButton("Draw rectangles");
		baseLayout = new SpringLayout();
		
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
		this.add(shapePanel);
	}
	private void setupLayout()
	{

		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 6, SpringLayout.EAST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 290, SpringLayout.NORTH, this);
	}
	private void setupListeners()
	{
		
	}
	
//set 500x300
}
