package com.zoe.weiya.util;

import com.zoe.weiya.comm.constant.CommonConstant;
import com.zoe.weiya.comm.properties.ZoeProperties;
import com.zoe.weiya.model.ZoeDate;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by chenghui on 2016/12/28.
 */
public class ZoeDateUtil {

    private static Calendar now(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c;
    }

    public static ZoeDate moment(){
        Calendar c = now();
        int day = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int second = c.get(Calendar.SECOND);
        ZoeDate zoeDate = new ZoeDate(year, month, day, hour, minute, second);
        return zoeDate;
    }


    public static String getTime(ZoeDate now){
        if( now.getHour() <= 12){
            return CommonConstant.MORNING;
        }else if(now.getHour() > 12 && now.getHour() <= 18){
            return CommonConstant.NOON;
        }else if(now.getHour() > 18){
            return CommonConstant.NIGHT;
        }
        return null;
    }

    public static String whichDay(ZoeDate now){
        ZoeDate startTime = ZoeProperties.getStartTime();
        String whichDay[] = {CommonConstant.FIRST_DAY,CommonConstant.SECOND_DAY,CommonConstant.THIRD_DAY};
        return whichDay[now.getDay()-startTime.getDay()];
    }
}
