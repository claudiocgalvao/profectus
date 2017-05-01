package br.com.gti.profectus.infra.logfile.filter;

import java.io.File;
import java.io.FilenameFilter;


public class FileNameFilter implements FilenameFilter {

  /** Filter name. */
  private final String filterName;

  /**
   * Constructor of class FileNameFilter.java.
   * @param filterName
   */
  public FileNameFilter(String filterName) {
    super();
    this.filterName = filterName;
  }

  public boolean accept(File dir, String name) {
    String lowercaseName = name.toLowerCase();
    if (this.filterName != null && !this.filterName.isEmpty()) {
      return (lowercaseName.endsWith(".txt") && lowercaseName.contains(this.filterName.toLowerCase()));
    } else {
      return (lowercaseName.endsWith(".txt"));
    }
  }



}
