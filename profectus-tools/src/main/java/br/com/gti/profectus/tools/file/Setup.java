package br.com.gti.profectus.tools.file;

import java.io.Serializable;

/**
 * Generic Class to use for generics setup to the system.
 * @author tiago.canatelli
 */
public class Setup implements Serializable {

    private static final long serialVersionUID = -9086720545977377779L;

    private String destinationPath;

    /**
     * getDestinationPath().
     * @author claudio.cesar
     * @since 17/11/2014
     * @return
     */
    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }
}
