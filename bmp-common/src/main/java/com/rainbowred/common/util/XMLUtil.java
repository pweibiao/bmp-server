package com.rainbowred.common.util;

import com.rainbowred.common.util.aes.AesException;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Desc: XML工具
 * @Date: 2022/7/6 17:13
 * @Author: pengweibiao
 **/
public class XMLUtil {

    // 密文 字段名
    public static final String ENCRYPT_NAME = "Encrypt";

    // 密文 字段名
    public static final String SIGNATURE_NAME = "MsgSignature";

    /**
     * 提取出xml数据包中的加密消息
     * @param xml 待提取的xml字符串
     * @return 提取出的加密消息字符串
     * @throws Exception
     */
    public static Object[] getEncrypt(String xml) throws Exception{
        return getXMLValue(xml, ENCRYPT_NAME);
    }

    /**
     * 提取出xml数据包中的加密消息
     * @param xml 待提取的xml字符串
     * @return 提取出的加密消息字符串
     * @throws Exception
     */
    public static Object[] getSignatureAndEncrypt(String xml) throws Exception{
        return getXMLValue(xml, ENCRYPT_NAME);
    }

    /**
     * 根据提供的字段名 获取 xml中 对应字段的值
     * @param xml
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static Object[] getXMLValue(String xml, String fieldName) throws AesException {
        Object[] result = new Object[3];
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);
            Element root = document.getDocumentElement();
            NodeList nodelist1 = root.getElementsByTagName(fieldName);
            result[0] = 0;
            result[1] = nodelist1.item(0).getTextContent();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ParseXmlError);
        }
    }


    /**
     * 将String类型的xml转换成对象
     * @param clazz 类
     * @param xmlStr xml字符串
     * @return
     */
    public static Object convertXmlStrToObject(Class<?> clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshal = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshal.unmarshal(sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }


    /**
     * xml 转 object
     * @param clazz 类
     * @param xmlStr xml字符串
     * @return
     */
    public static Object paresObject(Class<?> clazz, String xmlStr) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        // 进行将Xml转成对象的核心接口
        Unmarshaller unmarshal = context.createUnmarshaller();
        StringReader sr = new StringReader(xmlStr);
        return unmarshal.unmarshal(sr);
    }

    /**
     * object 转 xml
     * @param t
     * @param clazz
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static<T> String toXMLString(T t, Class<?> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        StringWriter writer = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(t, writer);
        String xmlStr = writer.toString();
        xmlStr = StringUtils.replace(xmlStr, "&quot;", ";");
        return xmlStr;
    }

}
