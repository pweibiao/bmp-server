import com.rainbowred.common.util.XMLUtil;

/**
 * @Desc:
 * @Date: 2023/5/17 16:29
 * @Author: pengweibiao
 **/
public class TestUtil {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String xml = "<xml>\n" +
                "\t<msgId>326797113</msgId>\n" +
                "\t<tm>1684312067985</tm>\n" +
                "\t<staffStatus>1</staffStatus>\n" +
                "\t<staffId>15271</staffId>\n" +
                "\t<staffLogname><![CDATA[15112263532]]></staffLogname>\n" +
                "\t<staffName><![CDATA[彭玮标]]></staffName>\n" +
                "</xml>";
        Object[] msgIds = XMLUtil.getXMLValue(xml, "msgId");
        System.out.println(msgIds[1]);
    }


}
