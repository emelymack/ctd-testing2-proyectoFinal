package com.Reports;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reports {
    public static ExtentReports getInstance() {
        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmm");
        String fechaText = formatter.format(fecha);
        String Path = ("src/test/resources/reportes/report"+fechaText+".html");

        ExtentReports extent = new ExtentReports(Path, false);

        return extent;
    }
}
