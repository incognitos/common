package com.falco.views;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.falco.controller.TimeMonitorController;

public class TimeMonitorPersonal  extends TimeMonitor implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeMonitorPersonal(){
		TimeMonitorController ctrl=new TimeMonitorController();
		ctrl.populateGrid(false,getTimeTable());
	}
	@Override
	public Rectangle getTimeTableRecDim() {
		return new Rectangle(20, 20, 430, 40);//x,y,width,height
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
