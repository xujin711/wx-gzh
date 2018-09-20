package msb.wxgzh.utils;

import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
/**
 *
 * @ClassName: DateUtil4Dis
 * @Description: 时间工具类
 * @author chengqiang
 * @date 2015-5-22 下午4:50:00
 *
 */
public class DateUtil4Dis {

    public static XMLGregorianCalendar getXMLDateTime(String dateStr) throws DatatypeConfigurationException{
        Date date = new  Date(Long.parseLong(dateStr));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DatatypeFactory dtf = DatatypeFactory.newInstance();
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();
        dateType.setYear(cal.get(Calendar.YEAR));
        //由于Calendar.MONTH取值范围为0~11,需要加1
        dateType.setMonth(cal.get(Calendar.MONTH)+1);
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));
        dateType.setMinute(cal.get(Calendar.MINUTE));
        dateType.setSecond(cal.get(Calendar.SECOND));
        return dateType;
    }


    /**
     * Description: 时间转换
     * @param thisDate :时间
     * @return XMLGregorianCalendar
     * @throws DatatypeConfigurationException 异常
     * @Author chengqiang
     * Create Date: 2013-11-27 下午12:06:02
     */
    public static XMLGregorianCalendar gainReservationDeductTime(Date thisDate) throws DatatypeConfigurationException{
        long time=(thisDate.getTime()/1000);
        Date date=new Date(time);
        date.setTime(time*1000);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DatatypeFactory dtf = DatatypeFactory.newInstance();
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();
        dateType.setYear(cal.get(Calendar.YEAR));
        //由于Calendar.MONTH取值范围为0~11,需要加1
        dateType.setMonth(cal.get(Calendar.MONTH)+1);
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));
        dateType.setMinute(cal.get(Calendar.MINUTE));
        dateType.setSecond(cal.get(Calendar.SECOND));
        return dateType;
    }


    /**
     * @Title: getDiffBetweenMonth
     * @Description: 获取两个日期之间相差的月份
     * @param @param interestAccrualCal
     * @param @param currentCal
     * @param @return    设定文件
     * @return int    返回类型
     * @throws
     * @author liuyang
     */
    @SuppressWarnings("unused")
    public static int getDiffBetweenMonth(Calendar startCal,
                                          Calendar endCal) {
        int betweenMonth = 0;
        int startYear = startCal.get(Calendar.YEAR);
        int endYear = endCal.get(Calendar.YEAR);
        int startMonth = startCal.get(Calendar.MONTH);
        int endMonth = endCal.get(Calendar.MONTH);
        betweenMonth = (endYear - startYear)*12+endMonth-startMonth;
        return betweenMonth;
    }

}
