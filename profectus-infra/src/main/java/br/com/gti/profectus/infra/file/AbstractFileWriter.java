package br.com.gti.profectus.infra.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

import org.beanio.StreamFactory;

import br.com.gti.profectus.infra.xstream.XStreamTranslator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * AbstractFileWriter class to process Objects/Strings to Write File.
 * @author tiago.canatelli
 * @since 20/05/2015
 * @param <T>
 */
@Slf4j
public abstract class AbstractFileWriter<T> {

    /** Stream Factory to use BeanIO. **/
    @Getter
    private StreamFactory factory;

    /** XStream to XML Transformation. **/
    @Getter
    private XStreamTranslator xstream;

    /**
     * Constructor of class AbstractFileWriter.java.
     */
    public AbstractFileWriter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor of class AbstractFileReader.java.
     * @param pathResource
     * @param bUseBeanIO
     */
    public AbstractFileWriter(final String pathResource, final boolean bUseBeanIO) {

        //Super constructor
        super();

        //Use beanIo to file transformation
        if (bUseBeanIO) {
            //Instance a new Factory from SreamFactory
            this.factory = StreamFactory.newInstance();

            try {
                //Path of resources BeanIo, example: factory.loadResource("layouts/beanio.xml");
                this.factory.loadResource(pathResource);

            } catch (Exception e) {
                log.error("ERROR: AbstractFileReader Constructor ");
                log.error("Error to load Beanio Resources in StreamFactory, details: ", e);
            }

        } else {

            //Not use beanIo to file transformation
            this.factory = null;
        }

        //Instance xStream
        this.xstream = XStreamTranslator.getInstance();
    }

    /**
     * Method to write file.
     * @author tiago.canatelli
     * @since 20/05/2015
     * @param path
     * @return
     * @throws IOException
     */
    public ByteBuffer writeFile(String path, StringBuilder sbContent) throws IOException {

        //Create ByteBuffer with null instance
        ByteBuffer buf = null;

        try {

            //Instance a RandomAccessFile to access path to create the file
            RandomAccessFile aFile = new RandomAccessFile(path, "rw");
            //Create a FileChannel to manipulate this file
            FileChannel inChannel = aFile.getChannel();
            //Lock the file to this channel to write, to other process not access this file in a same time
            inChannel.lock();
            //Create buffer with file size
            buf = ByteBuffer.wrap(sbContent.toString().getBytes());
            //Write file to Buffer to return
            inChannel.write(buf);
            //Close file Channel
            inChannel.close();
            //Close file access
            aFile.close();

        } catch (Exception e) {
            log.error("ERROR: AbstractFileReader.readFile ");
            log.error("Error to read file: " + path + ". Error details: ", e);
            throw new IOException(e);
        }

        return buf;
    }

    /**
     * Method to convert file's content to a List<T>.
     * @author tiago.canatelli
     * @since 20/05/2015
     * @param streamName
     * @param inputStream
     * @return
     * @throws Exception
     */
    public abstract void transformListObjectToFile(List<T> objectRecords, String streamName) throws Exception;

    /**
     * Method to convert file's content to a List<T>.
     * @author tiago.canatelli
     * @since 20/05/2015
     * @param streamName
     * @param inputStream
     * @return
     * @throws Exception
     */
    public abstract void transformObjectToFile(InputStream inputStream, String streamName) throws Exception;

    /**
     * Method to read file's content by a ImputStream and return a List of T object.
     * @author tiago.canatelli
     * @since 20/05/2015
     * @param streamName
     * @param inputStream
     * @return
     * @throws Exception
     */
    public abstract List<T> readFileContentToListObject(InputStream inputStream) throws Exception;

    /**
     * Method to read file's content by a ImputStream and return a T object.
     * @author tiago.canatelli
     * @since 20/05/2015
     * @param inputStream
     * @return
     * @throws Exception
     */
    public abstract T readFileContentToObject(InputStream inputStream) throws Exception;

}
