package radarview.test;

import java.awt.Dimension;

import javax.swing.JFrame;

import radarview.RadarDetectObjct;
import radarview.RadarPanel;

public final class TestFrame extends JFrame 
{
	private final RadarPanel _radarPanel;
	
	public TestFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420, 430);
		this.setLayout(null);
		this.setTitle("Radar View - Alexevan");
		
		_radarPanel = new RadarPanel();
		_radarPanel.setBounds(0, 0, 400, 400);
		_radarPanel.setSize(new Dimension(400, 400));
		
		RadarDetectObjct rdo1 = new RadarDetectObjct(50, 150, 0.001f, 0.003f);
		_radarPanel.addRadarDetectObject(rdo1);
		RadarDetectObjct rdo2 = new RadarDetectObjct(90, 195, .001f, .00f);
		_radarPanel.addRadarDetectObject(rdo2);
		RadarDetectObjct rdo3 = new RadarDetectObjct(130, 415, 0.004f, -.001f);
		_radarPanel.addRadarDetectObject(rdo3);
		RadarDetectObjct rdo6 = new RadarDetectObjct(310, 95, -0.001f, .002f);
		_radarPanel.addRadarDetectObject(rdo6);
		RadarDetectObjct rdo7 = new RadarDetectObjct(90, 105, .001f, .002f);
		_radarPanel.addRadarDetectObject(rdo7);
		
		this.getContentPane().add(_radarPanel);
		
		this.setLocationRelativeTo(null);
		
		runRadar();
	}
	
	private void runRadar()
	{
		new Thread()
		{
			@Override
			public void run() 
			{
				while(true)
				{
					try
					{
						_radarPanel.radarScan();
						sleep(2);
					}
					catch(InterruptedException e)
					{					
					}
				}
			}
		}.start();
	}
	
	public static void main(String [] args)
	{
		TestFrame testFrame = new TestFrame();
		testFrame.setVisible(true);
	}
}
