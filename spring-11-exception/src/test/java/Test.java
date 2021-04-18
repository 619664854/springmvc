import java.io.*;

/**
 * @ClassName:Test
 * @Author Mr.guo
 * @Date 2021/4/15 20:53
 */
public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("F:\\mmm\\base2c.sql")));
        String msg = null;
        int num=0;
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("F:\\mmm\\data.sql"),true),"UTF-8");
        while ((msg = br.readLine()) != null){
            if(msg.startsWith("INSERT INTO")){
                osw.write(msg);
                osw.write("\r\n");
                num++;
            }
//            System.out.println(msg);
        }
        System.out.println(num);
    }
}
