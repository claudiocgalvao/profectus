package br.com.gti.profectus.infra.xstream;

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
 * XStreamTranslator to XStream.
 * @author tiago.canatelli
 * @since 20/05/2015
 */
public final class XStreamTranslator {

  /** XStream to use XML Convert. **/
  private XStream xstream = null;

  /**
   * Constructor of class XStreamTranslator.java.
   */
  private XStreamTranslator() {
    this.xstream = new XStream();
    this.xstream.ignoreUnknownElements();
  }

  /**
   * Convert a any given Object to a XML String.
   * @param object
   * @return
   */
  public String toXMLString(Object object) {
    return this.xstream.toXML(object);
  }

  /**
   * Convert given XML to an Object.
   * @param xml
   * @return
   */
  public Object toObject(String xml) {
    return this.xstream.fromXML(xml);
  }

  /**
   * return this class instance.
   * @return
   */
  public static XStreamTranslator getInstance() {
    return new XStreamTranslator();
  }

  /**
   * convert to Object from given File.
   * @param xmlFile
   * @return
   * @throws IOException
   */
  public Object toObject(File xmlFile) throws IOException {
    return this.xstream.fromXML(new FileReader(xmlFile));
  }

  /**
   * create XML file from the given object with custom file name.
   * @param objTobeXMLTranslated
   * @param fileName
   * @throws IOException
   */
  public void toXMLFile(Object objTobeXMLTranslated, String fileName) throws IOException {
    FileWriter writer = new FileWriter(fileName);
    this.xstream.toXML(objTobeXMLTranslated, writer);
    writer.close();
  }

  /**
   * To XML File.
   * @author tiago.canatelli
   * @since 20/05/2015
   * @param objTobeXMLTranslated
   * @param fileName
   * @param omitFieldsRegXList
   * @throws IOException
   */
  public void
      toXMLFile(Object objTobeXMLTranslated, String fileName, List<String> omitFieldsRegXList) throws IOException {
    this.xstreamInitializeSettings(objTobeXMLTranslated, omitFieldsRegXList);
    this.toXMLFile(objTobeXMLTranslated, fileName);
  }

  /**
   * Initialize Settings.
   * @param objTobeXMLTranslated
   */
  public void xstreamInitializeSettings(final Object objTobeXMLTranslated, final List<String> omitFieldsRegXList) {
    if (omitFieldsRegXList != null && omitFieldsRegXList.size() > 0) {
      for (String omitEx : omitFieldsRegXList) {
        this.xstream.omitField(objTobeXMLTranslated.getClass(), omitEx);
      }
    }
  }

  /**
   * create XML file from the given object, file name is generated
   * automatically (class name).
   * @param objTobeXMLTranslated
   * @throws IOException
   */
  public void toXMLFile(final Object objTobeXMLTranslated) throws IOException {
    this.toXMLFile(objTobeXMLTranslated, objTobeXMLTranslated.getClass().getName() + ".xml");
  }

  /**
   * Create a Alias with shorter name to be used in XML elements.
   * @param nameTag
   * @param object
   * @author claudio.cesar
   */
  public void addAlias(String nameTag, Object object) {
    this.xstream.alias(nameTag, object.getClass());
  }

  /**
   * Create a Alias with shorter name to be used in XML elements.
   * @param nameTag
   * @param object
   */
  public void alias(String nameTag, Object object) {
    this.xstream.alias(nameTag, object.getClass());
  }

  /**
   * Create a Alias with shorter name to be used in XML elements.
   * @param nameTag
   * @param attributeName
   * @author tiago.canatelli
   */
  public void addAlias(String nameTag, String attributeName) {
    this.xstream.aliasAttribute(nameTag, attributeName);
  }

  /**
   * use attribute for.
   * @param nameClass
   * @param attributeName
   * @author tiago.canatelli
   */
  @SuppressWarnings("rawtypes")
  public void useAttributeFor(Class nameClass, String attributeName) {
    this.xstream.useAttributeFor(nameClass, attributeName);
  }

  /**
   * use attribute for.
   * @param nameClass
   * @param attributeName
   * @author tiago.canatelli
   */
  @SuppressWarnings("rawtypes")
  public void useAttributeFor(String attributeName, Class nameClass) {
    this.xstream.useAttributeFor(attributeName, nameClass);
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
    this.xstream.toXML(object, writer);
    return outputStream.toString(encoding);
  }
}
