package org.jwr.model;

/**
 *
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Config {

    public enum Sort {
        asc,
        desc,
        none
    }
/**
 * Size Block Result
 */
    private int size;
    /**
     * Index 
     */
    private int index;
    /**
     * Max Length for index
     */
    private int length;
    /**
     * Sort Attribute
     */
    private String attr;
    /**
     * Sort Mode
     */
    private Sort sort;

    public Config() {
    }

    public Config(Config other) {
        size = other.size;
        index = other.index;
        length = other.length;
        attr = other.attr;
        sort = other.sort;
    }

   public boolean hasSort() {
      return sort != null && sort != Sort.none && attr != null && !attr.isEmpty();
   }

}
