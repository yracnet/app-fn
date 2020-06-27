/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwr.model;

import java.util.ArrayList;
import java.util.List;
import org.jwr.model.Config;
import org.jwr.model.Filter;

/**
 *
 * @author yracnet
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class FilterQuery {

    static class Entry {

        final String param;
        final String[] names;
        final Filter value;

        Entry(String param, String names[], Filter value) {
            this.param = param;
            this.names = names;
            this.value = value;
        }
    }
    private String source;
    private Config config;
    private String alias = "o";
    private final List<Entry> entries = new ArrayList<>();

}
