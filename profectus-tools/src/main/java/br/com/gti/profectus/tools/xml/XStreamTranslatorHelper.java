package br.com.gti.profectus.tools.xml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import com.thoughtworks.xstream.XStream;

/**
 * Helper class To XML Treatments.
 */
public final class XStreamTranslatorHelper {

    private XStream xstream = null;

    /**
     * Constructor XStreamTranslator.
     */
    private XStreamTranslatorHelper() {
        xstream = new XStream();
        xstream.ignoreUnknownElements();
    }

    /**
     * Convert a any given Object to a XML String.
     * @param object
     * @return
     */
    public String toXMLString(Object object) {
        return xstream.toXML(object);
    }

    /**
     * Convert given XML to an Object.
     * @param xml
     * @return
     */
    public Object toObject(String xml) {
        return xstream.fromXML(xml);
    }

    /**
     * Return this class instance.
     * @return
     */
    public static XStreamTranslatorHelper getInstance() {
        return new XStreamTranslatorHelper();
    }

    /**
     * Convert to Object from given File.
     * @param xmlFile
     * @return
     * @throws IOException
     */
    public Object toObject(File xmlFile) throws IOException {
        return xstream.fromXML(new FileReader(xmlFile));
    }

    /**
     * Create XML file from the given object with custom file name.
     * @param objTobeXMLTranslated
     * @param fileName
     * @throws IOException
     */
    public void toXMLFile(Object objTobeXMLTranslated, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        xstream.toXML(objTobeXMLTranslated, writer);
        writer.close();
    }

    /**
     * Method to convert XML to File.
     * @param obj
     * @param fileName
     * @param omit
     * @throws IOException
     */
    public void toXMLFile(Object obj, String fileName, List<String> omit) throws IOException {
        xstreamInitializeSettings(obj, omit);
        toXMLFile(obj, fileName);
    }

    /**
     * Initialize Settings.
     * @param obj
     */
    public void xstreamInitializeSettings(final Object obj, final List<String> omit) throws IOException {
        if (omit != null && omit.size() > 0) {
            for (String omitEx : omit) {
                xstream.omitField(obj.getClass(), omitEx);
            }
        }
    }

    /**
     * create XML file from the given object, file name is generated automatically (class name).
     * @param objTobeXMLTranslated
     * @throws IOException
     */
    public void toXMLFile(final Object objTobeXMLTranslated) throws IOException {
        toXMLFile(objTobeXMLTranslated, objTobeXMLTranslated.getClass().getName() + ".xml");
    }

    /**
     * Create a Alias with shorter name to be used in XML elements.
     * @param nameTag
     * @param object
     * @author claudio.cesar
     */
    public void addAlias(String nameTag, Object object) {
        xstream.alias(nameTag, object.getClass());
    }

    /**
     * Create a Alias with shorter name to be used in XML elements.
     * @param nameTag
     * @param object
     */
    public void alias(String nameTag, Object object) {
        xstream.alias(nameTag, object.getClass());
    }

    /**
     * Create a Alias with shorter name to be used in XML elements.
     * @param nameTag
     * @param attributeName
     * @author tiago.canatelli
     */
    public void addAlias(String nameTag, String attributeName) {
        xstream.aliasAttribute(nameTag, attributeName);
    }

    /**
     * Use attribute for.
     * @param nameClass
     * @param attributeName
     * @author tiago.canatelli
     */
    public void useAttributeFor(Class<?> nameClass, String attributeName) {
        xstream.useAttributeFor(nameClass, attributeName);
    }

    /**
     * Use attribute for.
     * @param nameClass
     * @param attributeName
     * @author tiago.canatelli
     */
    public void useAttributeFor(String attributeName, Class<?> nameClass) {
        xstream.useAttributeFor(attributeName, nameClass);
    }

    /**
     * Create XML With Header.
     * @param object
     * @param version
     * @param encoding
     * @return String XML
     * @throws Exception
     * @author claudio.cesar
     */
    public String createXmlWithHeader(Object object, String version, String encoding) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(outputStream, encoding);
        writer.write("<?xml version=\'" + version + "\' encoding=\'" + encoding + "\' ?>\r");
        xstream.toXML(object, writer);
        return outputStream.toString(encoding);
    }
}
