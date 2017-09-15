package cn.ystk.pro.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * 功能:日期转换工具类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月7日
 * 修改日期: 2017年4月7日
 * 修改列表:
 */
public class DateUtil {
    private static final  SimpleDateFormat sdfyyyymmddhhmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final  SimpleDateFormat sdfyyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 
     * 功能：日期转化为字符串
     * @param date
     * @return
     * @throws ParseException
     */
    public static  String formatDateYYmmddHHmmss(Date date){
        return sdfyyyymmddhhmmss.format(date);
    }
    /**
     * 
     * 功能：字符串转化为日期
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date parseYYmmddHHmmss(String strDate){
        try {
			return sdfyyyymmddhhmmss.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null;
    }
    /**
     * 
     * 功能：日期转化为字符串
     * @param date
     * @return
     * @throws ParseException
     */
    public static  String formatDateYYmmdd(Date date){
        return sdfyyyymmdd.format(date);
    }
    /**
     * 
     * 功能：字符串转化为日期
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date parseYYmmdd(String strDate){
        try {
			return sdfyyyymmdd.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null;
    }
}