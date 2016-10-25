package com.falco.views;

import com.falco.controller.TimeMonitorController;



public class TimeMonitorForLeads extends TimeMonitor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TimeMonitorForLeads(){
		TimeMonitorController ctrl=new TimeMonitorController();
		ctrl.populateGrid(true,getTimeTable());
	}
}
