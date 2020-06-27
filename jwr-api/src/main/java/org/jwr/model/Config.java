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

    private int size;
    private int index;
    private int length;
    private String attr;
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
