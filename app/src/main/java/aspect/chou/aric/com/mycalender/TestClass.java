package aspect.chou.aric.com.mycalender;

import java.util.Calendar;

/**
 * aspect.chou.aric.com.mycalender
 * Created by Aric on 下午4:16.
 */

public class TestClass {

    public static void main(String... arg ){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);//将calendar变量设置为本月的第一天
        int dayInWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int realDayInWeek =dayInWeek-1==0?7:dayInWeek-1;
        int prevDays= realDayInWeek-1;

        calendar.add(Calendar.DAY_OF_MONTH,-prevDays);

        System.out.print(calendar.getTime());





    }
}
