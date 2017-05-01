package br.com.gti.profectus.infra.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

import org.beanio.StreamFactory;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * AbstractFileReader class to process file to Read.
 * @author tiago.canatelli
 * @since 20/05/2015
 * @param <T>
 */
@Slf4j
public abstract class AbstractFileReader<T> {

    /** Stream Factory to use BeanIO. **/
    @Getter
    private StreamFactory factory;

    /**
     * Constructor of class AbstractFileReader.java.
     */
    public AbstractFileReader() {
    }

    /**
     * Constructor of class AbstractFileReader.java.
     * @param pathResource
     * @param bUseBeanIO
     */
    public AbstractFileReader(final String pathResource, final boolean bUseBeanIO) {

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

    }

    /**
     * Method to read file.
     * @author tiago.canatelli
     * @since 20/05/2015
     * @param path
     * @return
     * @throws IOException
     */
    public ByteBuffer readFile(String path) throws IOException {

        //Create ByteBuffer with null instance
        ByteBuffer buf = null;

        try {

            //Instance a RandomAccessFile to access the file with Read permission
            RandomAccessFile aFile = new RandomAccessFile(path, "r");
            //Create a FileChannel to manipulate this file
            FileChannel inChannel = aFile.getChannel();
            //Lock the file to this channel, to other process not access this file when this is processing.
            //inChannel.lock();

            //Create buffer with file size.
            buf = ByteBuffer.allocate((int) inChannel.size());
            //Read file to Buffer to return
            inChannel.read(buf);

            //Close file Channel
            inChannel.close();
            //Close file access
            aFile.close();

        } catch (Exception e) {
            log.error("ERROR: AbstractFileReader.readFile ", e);
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
    public abstract List<T> transformFileContentToListObject(InputStream inputStream, String streamName)
        throws Exception;

    /**
     * Method to convert file's content to a List<T>.
     * @author tiago.canatelli
     * @since 20/05/2015
     * @param streamName
     * @param inputStream
     * @return
     * @throws Exception
     */
    public abstract T transformFileContentToObject(InputStream inputStream, String streamName) throws Exception;

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
