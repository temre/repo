package com.kavi.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kavi.entity.SalesEEn;
import com.kavi.entity.StockEEn;
import com.kavi.entity.user.LoginEn;

public class SetEntityObject {

	public SalesEEn setSalesEEn(HttpServletRequest request) throws ParseException {
		SalesEEn salesEn = new SalesEEn();
		HttpSession session = request.getSession();
		LoginEn loginEn = (LoginEn) session.getAttribute("loginEn");
		int noOfMsNozzle = loginEn.getNoOfMsNozzle();
		int noOfHsdNozzle = loginEn.getNoOfHsdNozzle();
		int noOfPowerNozzle = loginEn.getNoOfPowerNozzle();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = format.parse(request.getParameter("date"));
		System.out.println(d);
		salesEn.setDate(new Date(d.getTime()));

		String attrName; // from html table

		// ---------------------------------------- msMr
		// -----------------------------------------------

		int msMr[] = new int[noOfMsNozzle];
		attrName = "msMeterReading";

		for (int i = 0; i < noOfMsNozzle; i++) // no of nozzle the userid have
												// is in condition
		{

			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				msMr[i] = 0;
			else {

				msMr[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
			}

		}


		for (int i : msMr) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		salesEn.setMsMr(msMr);

		// ------------------------------------ msPt
		// ---------------------------------------------------

		int msPt[] = new int[noOfMsNozzle];
		attrName = "msPumpTesting"; // in html table

		for (int i = 0; i < noOfMsNozzle; i++) // no of nozzle the userid have
												// is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				msPt[i] = 0;
			else
				msPt[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}

		for (int i : msPt) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		salesEn.setMsPt(msPt);

		// ---------------------------------------- hsdMr
		// -----------------------------------------------

		int hsdMr[] = new int[noOfHsdNozzle];
		attrName = "hsdMeterReading"; // in html table

		for (int i = 0; i < noOfHsdNozzle; i++) // no of nozzle the userid have
												// is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				hsdMr[i] = 0;
			else
				hsdMr[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}

		for (int i : hsdMr) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		salesEn.setHsdMr(hsdMr);

		// ------------------------------------ hsdPt
		// ---------------------------------------------------

		int hsdPt[] = new int[noOfHsdNozzle];
		attrName = "hsdPumpTesting"; // in html table

		for (int i = 0; i < noOfHsdNozzle; i++) // no of nozzle the userid have
												// is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				hsdPt[i] = 0;
			else
				hsdPt[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}

		for (int i : hsdPt) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		salesEn.setHsdPt(hsdPt);

		// ---------------------------------------- pMr
		// -----------------------------------------------

		int pMr[] = new int[noOfPowerNozzle];
		attrName = "powerMeterReading";

		for (int i = 0; i < noOfPowerNozzle; i++) // no of nozzle the userid
													// have is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				pMr[i] = 0;
			else
				pMr[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}
		for (int i : pMr) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		salesEn.setpMr(pMr);

		// ------------------------------------ pPt
		// ---------------------------------------------------

		int pPt[] = new int[noOfPowerNozzle];
		attrName = "powerPumpTesting"; // in html table

		for (int i = 0; i < noOfPowerNozzle; i++) // no of nozzle the userid
													// have is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				pPt[i] = 0;
			else
				pPt[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}

		for (int i : pPt) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		
		salesEn.setpPt(pPt);
		salesEn.setUserId(loginEn.getUserId());
		return salesEn;
	}

	public StockEEn setStockEEn(HttpServletRequest request) throws ParseException {
		StockEEn stockEn = new StockEEn();
		HttpSession session = request.getSession();
		LoginEn loginEn = (LoginEn) session.getAttribute("loginEn");
		int noOfMsTank = loginEn.getNoOfMsTank();
		int noOfHsdTank = loginEn.getNoOfHsdTank();
		int noOfPowerTank = loginEn.getNoOfPowerTank();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = format.parse(request.getParameter("date"));
		System.out.println(d);
		stockEn.setDate(new Date(d.getTime()));

		String attrName; // from html table

		// ---------------------------------------- msReceipt
		// -----------------------------------------------

		int msRecipt[] = new int[noOfMsTank];
		attrName = "msReceipt";

		for (int i = 0; i < noOfMsTank; i++) // no of tank the userid have
												// is in condition
		{

			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				msRecipt[i] = 0;
			else {

				msRecipt[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
			}

		}


		for (int i : msRecipt) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		stockEn.setMsRecipt(msRecipt);

		// ------------------------------------ msOpeningStock
		// ---------------------------------------------------

		int msOpeningStock[] = new int[noOfMsTank];
		attrName = "msOpeningStock"; // in html table

		for (int i = 0; i < noOfMsTank; i++) // no of tank the userid have
												// is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				msOpeningStock[i] = 0;
			else
				msOpeningStock[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}

		for (int i : msOpeningStock) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		stockEn.setMsOpeningStock(msOpeningStock);

		// ---------------------------------------- hsdRecipt
		// -----------------------------------------------

		int hsdRecipt[] = new int[noOfHsdTank];
		attrName = "hsdReceipt"; // in html table

		for (int i = 0; i < noOfHsdTank; i++) // no of tank the userid have
												// is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				hsdRecipt[i] = 0;
			else
				hsdRecipt[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}

		for (int i : hsdRecipt) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		stockEn.setHsdRecipt(hsdRecipt);

		// ------------------------------------ hsdOpeningStock
		// ---------------------------------------------------

		int hsdOpeningStock[] = new int[noOfHsdTank];
		attrName = "hsdOpeningStock"; // in html table

		for (int i = 0; i < noOfHsdTank; i++) // no of tank the userid have
												// is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				hsdOpeningStock[i] = 0;
			else
				hsdOpeningStock[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}

		for (int i : hsdOpeningStock) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		stockEn.setHsdOpeningStock(hsdOpeningStock);

		// ---------------------------------------- powerReceipt
		// -----------------------------------------------

		int powerReceipt[] = new int[noOfPowerTank];
		attrName = "powerReceipt";

		for (int i = 0; i < noOfPowerTank; i++) // no of tank the userid
													// have is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				powerReceipt[i] = 0;
			else
				powerReceipt[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}
		for (int i : powerReceipt) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		stockEn.setpRecipt(powerReceipt);

		// ------------------------------------ powerOpeningStock
		// ---------------------------------------------------

		int powerOpeningStock[] = new int[noOfPowerTank];
		attrName = "powerOpeningStock"; // in html table

		for (int i = 0; i < noOfPowerTank; i++) // no of tank the userid
													// have is in condition
		{
			if (null == request.getParameter(attrName + (i + 1)) || "".equals(request.getParameter(attrName + (i + 1))))
				powerOpeningStock[i] = 0;
			else
				powerOpeningStock[i] = Integer.parseInt(request.getParameter(attrName + (i + 1)));
		}

		for (int i : powerOpeningStock) // checking for negative value
			if (i < 0)
				throw new ArithmeticException("Please enter only positive number");
		
		stockEn.setpOpeningStock(powerOpeningStock);
		stockEn.setUserId(loginEn.getUserId());
		return stockEn;

	}

}
