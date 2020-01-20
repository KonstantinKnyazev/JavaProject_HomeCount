/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.model;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Konstantin_Knyazev
 */
public class Filter {

    public static final int STEP_DAY = 0;
    public static final int STEP_MONTH = 1;
    public static final int STEP_YEAR = 2;

    private int step;
    private Date from;
    private Date to;

    public Filter() {
        this(STEP_MONTH);
    }

    public Filter(int step) {
        this.step = step;
        setFromTo(new GregorianCalendar());
    }

    public int getStep() {
        return step;
    }

//    public void setStep(int step) {
//        this.step = step;
//        setFromTo(new GregorianCalendar());
//    }
    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void next() {
        offset(1);
    }

    public void prev() {
        offset(-1);
    }

    public void nextPeriod() {
        step += 1;
        if (step > STEP_YEAR) {
            step = STEP_DAY;
        }
        setFromTo(new GregorianCalendar());
    }

    public boolean check(Date date) {

//          System.out.println("personalfinance.model.Filter.check() date  = " + date+"    long date = " + date.getTime());
//          the value 0 if the argument Date is equal to this Date; 
//          a value less than 0 if this Date is before the Date argument; 
//          and a value greater than 0 if this Date is after the Date argument
        boolean r1 = (date.compareTo(from) >= 0);
//        System.out.println("personalfinance.model.Filter.check() r1  = " + r1);
//        System.out.println("personalfinance.model.Filter.check() date  = " + date);
//        System.out.println("personalfinance.model.Filter.check() from  = " + from + "   date.compareTo(from) = " + date.compareTo(from) + "    long from = " + from.getTime() + "  >   long date = " + date.getTime());

        boolean r2 = (date.compareTo(to) <= 0);
//        System.out.println("personalfinance.model.Filter.check() r2  = " + r2);
//        System.out.println("personalfinance.model.Filter.check() date  = " + date);
//        System.out.println("personalfinance.model.Filter.check() to  = " + to + "   date.compareTo(to) = " + date.compareTo(to) + "    long to = " + to.getTime() + " <   long date = " + date.getTime());

        boolean result = r1 && r2;
//        System.out.println("personalfinance.model.Filter.check() r1 = " + r1 + "&& r2 = " + r2 + " result  = " + result);

//        return (date.compareTo(from) > 0) && (date.compareTo(to) < 0);
        return result;
    }

    private void setFromTo(Calendar calendar) {
        switch (step) {
            case STEP_DAY:
                this.from = new GregorianCalendar(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        0, 0, 0).getTime();
                this.to = new GregorianCalendar(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        23, 59, 59).getTime();
                break;

            case STEP_MONTH:
                YearMonth yearMonth = YearMonth.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
                this.from = new GregorianCalendar(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        1, //first day of month
                        0, 0, 0).getTime();
                this.to = new GregorianCalendar(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        yearMonth.lengthOfMonth(), //last day of month
                        23, 59, 59).getTime();
                break;

            case STEP_YEAR:
                this.from = new GregorianCalendar(
                        calendar.get(Calendar.YEAR),
                        0, // count jo months begin from 0 january
                        1, //first day of month
                        0, 0, 0).getTime();
                this.to = new GregorianCalendar(
                        calendar.get(Calendar.YEAR),
                        11, //december
                        31, //last day of month december
                        23, 59, 59).getTime();
//                break;

        }

    }

    private void offset(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);

        switch (step) {
            case STEP_DAY:
                calendar.add(Calendar.DAY_OF_MONTH, i);
                break;
            case STEP_MONTH:
                calendar.add(Calendar.MONTH, i);
                break;
            case STEP_YEAR:
                calendar.add(Calendar.YEAR, i);
                break;
        }
        setFromTo(calendar);
    }

}//class
