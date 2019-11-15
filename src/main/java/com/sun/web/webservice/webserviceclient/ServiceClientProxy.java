package com.sun.web.webservice.webserviceclient;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

/**
 * @author ：suncj
 * @date ：2019/11/8 9:45
 */
public class ServiceClientProxy {
    public void test() {
        //动态调用webservice接口
        Object[] parameters={"QQYYMAS","201","193007sddx474f9bd752243295779a66",-1,"xxx"};
        invokeRemoteMethod("http://115.159.220.119:8098/iptv-sddx/soap/wthx","ResultNotify",parameters);
    }
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
