package org.jwr.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for define a attribute as Filter Element
 *
 * @author Willyams Yujra
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterElement {

    /**
     * Names of attribute for where clause
     *
     * @return
     */
    public String[] name() default "#default";

    /**
     * Parameter name in the where clause
     *
     * @return
     */
    public String param() default "#default";
}
