package drawing.view;

import drawing.controller.*;

public class DrawingFrame 
{
	private DrawingController baseController;
	private DrawingPanel appPanel;
	
	public DrawingFrame(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		//appPanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		
	}
}
