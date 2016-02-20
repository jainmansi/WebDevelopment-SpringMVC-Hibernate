/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author user
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override

    public String getParameter(String parameter) {

        String value = super.getParameter(parameter);

        return stripXSS(value);

    }

    @Override

    public String[] getParameterValues(String parameter) {

        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = stripXSS(values[i]);
        }
        return encodedValues;

    }

    private String stripXSS(String value) {

        if (value != null) {
            value = value.replaceAll("[^\\dA-Za-z\\.]", "").replaceAll("\\s+", "\\s").trim();
        }        
        return value;
    }
}
