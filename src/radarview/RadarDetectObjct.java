package radarview;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public final class RadarDetectObjct 
{
	private final float GREEN_FIX = 1.0f;
	private Color _clrObject = new Color(0, GREEN_FIX, 0, 0.0f);
	
	private float _objectX;
	private float _objectY;
	
	private Rectangle _rdrDetectRect;
	
	private float _objOpacity = 0;
	
	private float _objSpeedX;
	private float _objSpeedY;
	
	public RadarDetectObjct(float objectX, float objectY, float objSpeedX, float objSpeedY)
	{
		this._objectX = objectX;
		this._objectY = objectY;
		this._objSpeedX = objSpeedX;
		this._objSpeedY = objSpeedY;
		
		_rdrDetectRect = new Rectangle(10,10);
		
	}
	
	public void radarBeamCollisionCheck(Shape testShape)
	{
		if(testShape == null)
			return;
		
		if(testShape.intersects(_rdrDetectRect.getBounds()) )
		{
			_objOpacity += 0.15;
			if(_objOpacity > GREEN_FIX)
				_objOpacity = GREEN_FIX;
			_clrObject = new Color(0.0f, GREEN_FIX, 0, _objOpacity);
		}
		else
		{
			_objOpacity -= 0.02;
			if(_objOpacity < 0)
				_objOpacity = 0;
			_clrObject = new Color(0.0f, GREEN_FIX, 0.0f, _objOpacity);
		}
	}
	
	public void drawObject(Graphics g)
	{
		_rdrDetectRect.setLocation((int)_objectX, (int)_objectY);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(_clrObject);

		g2d.fillOval(_rdrDetectRect.x, _rdrDetectRect.y, _rdrDetectRect.width, _rdrDetectRect.height);
	}

	public float getObjectX() 
	{
		return _objectX;
	}
	
	public void moveObject()
	{
		_objectX += _objSpeedX;
		_objectY += _objSpeedY;
	}
}
