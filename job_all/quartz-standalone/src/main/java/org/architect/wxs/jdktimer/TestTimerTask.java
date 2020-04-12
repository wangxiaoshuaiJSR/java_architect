package org.architect.wxs.jdktimer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class TestTimerTask extends TimerTask {
    public void run() {
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("任务执行了：" + dateStr);
    }
}
