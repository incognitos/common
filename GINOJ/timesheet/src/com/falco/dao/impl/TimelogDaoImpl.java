package com.falco.dao.impl;

import com.falco.dao.TimelogDao;

import com.falco.db.DBConnection;

import com.falco.model.TimeLog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class TimelogDaoImpl implements TimelogDao
{
	//~ Methods ----------------------------------
	/** @see  com.falco.dao.TimelogDao#getTimeLogs(java.lang.String, boolean) */
	@Override
	public String[][] getTimeLogs(String name, boolean isLead)
	{
		List<TimeLog> logs = new ArrayList<TimeLog>();

		StringBuilder sb = new StringBuilder();

		sb.append(" SELECT *");
		sb.append(" FROM");
		sb.append("  (SELECT convert(varchar,getdate(),101) AS date,");
		sb.append("          cardno,");
		sb.append("          name,");
		sb.append("     (SELECT min(trtime)");
		sb.append("      FROM tbltransaction");
		sb.append("      WHERE cardno=cdb.cardno");
		sb.append("        AND trdate>getDate()-1");
		sb.append("        AND trcode='C0') timein,");
		sb.append("     (SELECT max(trtime)");
		sb.append("      FROM tbltransaction");
		sb.append("      WHERE cardno=cdb.cardno");
		sb.append("        AND trdate>getDate()-1");
		sb.append("        AND trcode='CI')timeout");
		sb.append("   FROM carddb cdb");
		if (!isLead)
		{
			sb.append("   WHERE name=? ");
		}
		sb.append("	) tbl");
		sb.append(" WHERE timein IS NOT NULL");
		sb.append(" ORDER BY name;");

		try
		{
			DBConnection db = new DBConnection();
			PreparedStatement pst = db.getConnection().prepareStatement(
					sb.toString());
			if (!isLead)
			{
				final int paramIndex = 1;
				pst.setString(paramIndex, name);
			}
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				TimeLog log = new TimeLog();

				log.setDate(rs.getString("date"));
				log.setCardId(rs.getString("cardno"));
				log.setName(rs.getString("name"));
				log.setTimeIn(rs.getString("timein"));
				log.setTimeOut(rs.getString("timeout"));

				logs.add(log);
			}
			rs.close();
			pst.close();
			db.closeConnection();
		}
		catch (SQLException e)
		{
			// TO DO some handling here
			e.printStackTrace();
		}
		String[][] logArray = new String[logs.size()][5];
		for (int i = 0; i < logs.size(); i++)
		{
			logArray[i][0] = logs.get(i).getDate();
			logArray[i][1] = logs.get(i).getCardId();
			logArray[i][2] = logs.get(i).getName();
			logArray[i][3] = logs.get(i).getTimeIn();
			logArray[i][4] = logs.get(i).getTimeOut();
		}

		return logArray;
	}
}
