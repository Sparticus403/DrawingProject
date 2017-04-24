package drawing.view;

import drawing.controller.*;
import javax.swing.*;

public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private DrawingPanel appPanel;
	
	public DrawingFrame(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Something is here ritgh now");
		this.setResizable(true);
		this.setSize(400, 600);
		this.setVisible(true);
	}
}
