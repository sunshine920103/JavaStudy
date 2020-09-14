import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：cc
 * @date ：created in 2020/6/29 16:29
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class TestJava {
    private List<String> s = new ArrayList<String>();

    public List<String> getS() {
        return Collections.unmodifiableList(s);
    }

    @Test
    public void test2() throws Exception {
        try {
            File file =new File("aaa");

            FileWriter fileWriter= new FileWriter(file,true);
            fileWriter.write("aa");
            int a=10/0;
        }catch (Exception e){
//            System.out.println(1111);
            throw new Exception("111");
        }
        System.out.println("ccc");

    }

}
