package jvmStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：cc
 * @date ：created in 2020/1/19 11:41 AM
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class OomStudy {

    static class oomObject {
    }

    public static void main(String[] args) {
        List<oomObject> list = new ArrayList<oomObject>();
        while (true) {
            list.add(new oomObject());
        }
    }
}
