package nju.util;

import org.bson.Document;

/**
 * @Author Arthur
 * @Date 2019/10/23 16:13
 */
public class Utils {

    public static String getString(Document doc, String key) {
        try {
            return (null == doc.getString(key)) || ("null".equals(doc.getString(key).toLowerCase())) ? "" : doc.getString(key);
        } catch (Exception e) {
            return "";
        }
    }

}
