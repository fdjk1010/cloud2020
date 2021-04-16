import java.time.ZonedDateTime;

/**
 * @author lzy
 * @date 2021/4/16 15:54
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zbj=ZonedDateTime.now();//默认时区
        System.out.println(zbj);

        //2021-04-16T15:55:57.310+08:00[Asia/Shanghai]
    }
}
