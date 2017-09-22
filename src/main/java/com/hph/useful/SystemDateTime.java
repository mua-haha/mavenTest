package  com.hph.useful;

/**
 * 设置系统时间
 *
 * @author 陈飞飞    2015年9月29日 下午3:26:26
 */
public class SystemDateTime {

    /**
     * 设置系统时间
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   时（24h）
     * @param minute 分
     * @param second 秒
     */
    public static void setLocalDateTime(int year, int month, int day, int hour, int minute, int second) {
        String osName = System.getProperty("os.name");
        String cmd = "";
        try {
            if (osName.matches("^(?i)Windows.*$")) {// Window 系统
                // 格式 HH:mm:ss
                cmd = String.format("  cmd /c time %02d:%02d:%02d", hour, minute, second);
                Runtime.getRuntime().exec(cmd);
                // 格式：yyyy-MM-dd
                cmd = String.format(" cmd /c date %04d-%02d-%02d", year, month, day);
                Runtime.getRuntime().exec(cmd);
            } else {// Linux 系统
                // 格式：yyyyMMdd
                cmd = String.format("  date -s %04d%02d%02d", year, month, day);
                Runtime.getRuntime().exec(cmd);
                // 格式 HH:mm:ss
                cmd = String.format("  date -s %02d:%02d:%02d", hour, minute, second);
                Runtime.getRuntime().exec(cmd);
            }
        } catch (Exception e) {

        }
    }

}
