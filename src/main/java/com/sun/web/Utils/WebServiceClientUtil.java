package com.sun.web.Utils;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @author ：suncj
 * @date ：2019/11/8 11:17
 */
public class WebServiceClientUtil {

    public static Object[] invokeRemoteMethod(String url, String method, Object[] parameters) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        if (!url.endsWith("wsdl")) {
            url += "?wsdl";
        }
        org.apache.cxf.endpoint.Client client = dcf.createClient(url);
        try {
            Object[] objects = client.invoke(method, parameters);
            return objects;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
