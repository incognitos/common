package com.falco.controller;

import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.falco.constants.Const;
import com.falco.dao.SystemUserDao;
import com.falco.dao.impl.SystemUserDaoImpl;

public class MainWindowController {

	private Preferences userpref;
	private SystemUserDao dao = new SystemUserDaoImpl();

	/**
	 * Prompt for user/lead password info on first load
	 * 
	 */
	public void sessionSetting(JFrame mainFrame) {
		userpref = Preferences.userNodeForPackage(MainWindowController.class);
		String activeUser = userpref.get(Const.USER_PREF, "");
		if (activeUser.equals("")) {
			if(setUserReturnTrueIfOk(mainFrame)){
				leadpasswordSetting(mainFrame);
			}
		}
	}

	private boolean setUserReturnTrueIfOk(JFrame mainFrame) {
		boolean isSetupOk = false;
		String activeUser;
		activeUser = JOptionPane.showInputDialog("Initalize user Name", "");
		if (activeUser == null || activeUser.equals("")) {
			JOptionPane.showMessageDialog(mainFrame,
					"User must be declared!");
			mainFrame.dispatchEvent(new WindowEvent(mainFrame,
					WindowEvent.WINDOW_CLOSING));
		}
		else if(!dao.isValidUserEntry(activeUser)){
			JOptionPane.showMessageDialog(mainFrame,
					"User not found in DB!");
			mainFrame.dispatchEvent(new WindowEvent(mainFrame,
					WindowEvent.WINDOW_CLOSING));
		}
		else {
			userpref.put(Const.USER_PREF, activeUser);
			isSetupOk=true;
		}
		return isSetupOk;
	}

	private void leadpasswordSetting(JFrame mainFrame) {
		String leadPwd="";
		leadPwd = JOptionPane
				.showInputDialog("Lead Password (Optional)", "");
		final boolean isleadNotEmpy = leadPwd!=null&&!leadPwd.equals("");
		if (isleadNotEmpy && !dao.isValidLeadPassword(leadPwd)) {
			JOptionPane.showMessageDialog(mainFrame,
					"Not a valid Lead Password.\nLogging in as regular user.");
		} else if(isleadNotEmpy){
			userpref.put(Const.LEAD_PW, leadPwd);
		}
	}
}
