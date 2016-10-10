package org.jahia.initializers;

import org.apache.jackrabbit.value.StringValue;
import org.jahia.services.content.JCRNodeWrapper;
import org.jahia.services.content.JCRSessionFactory;
import org.jahia.services.content.decorator.JCRSiteNode;
import org.jahia.services.content.nodetypes.ExtendedPropertyDefinition;
import org.jahia.services.content.nodetypes.initializers.ChoiceListValue;
import org.jahia.services.content.nodetypes.initializers.ModuleChoiceListInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import java.util.*;

/**
 * Created by nikhilpatel on 12/8/15.
 */
public class DemoInitializer implements ModuleChoiceListInitializer {
    private transient static Logger logger = LoggerFactory.getLogger(DemoInitializer.class);
    private String key;

    private Properties demoProperties;

    private String serviceUrl;
    private String serviceUser;
    private String servicePassword;

    private String url;

    private String clientId;

    public List<ChoiceListValue> getChoiceListValues(ExtendedPropertyDefinition epd, String param,
                                                     List<ChoiceListValue> values, Locale locale,
                                                     Map<String, Object> context) {

        if (demoProperties == null) logger.error("demoProperties is null - something went wrong");

        logger.info("clientId is : " + demoProperties.getProperty("clientId"));
        List<ChoiceListValue> choiceListValues = new ArrayList<ChoiceListValue>();
        /* Here is where we would use the properties to call a service  */
        /* clientId retrieved from demoProperties because the service requires a special property */
        /* serverUrl, serverUser and serverPassword for the relevant properties for the endpoint */
        choiceListValues.add(new ChoiceListValue("value1", null, new StringValue("1")));
        choiceListValues.add(new ChoiceListValue("value2", null, new StringValue("2")));
        choiceListValues.add(new ChoiceListValue("value3", null, new StringValue("3")));
        return choiceListValues;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


    public void setUrl(String url) {
        logger.info("in setUrl - url is : " + url);
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setClientId(String clientId) {
        logger.info("**********************  in setClientId - clientId is : " + clientId);
        this.clientId = clientId;
    }

    public String getClientId(){
        return clientId;
    }


    public void setDemoProperties(Properties demoProperties) {

        this.demoProperties = demoProperties;
        if (demoProperties == null) logger.info("DEMO PROP NULL");
        logger.info("clientId is : " + demoProperties.getProperty("clientId"));
        logger.info("oauth.url is : " + demoProperties.getProperty("oauth.url"));
    }

    public Properties getDemoProperties(){
        return demoProperties;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        logger.info("serviceUrl is : " + serviceUrl);
        this.serviceUrl = serviceUrl;
    }

    public String getServiceUser() {
        return serviceUser;
    }

    public void setServiceUser(String serviceUser) {
        logger.info("serviceUser is : " + serviceUser);
        this.serviceUser = serviceUser;
    }

    public String getServicePassword() {
        return servicePassword;
    }

    public void setServicePassword(String servicePassword) {
        logger.info("servicePassword is : " + servicePassword);
        this.servicePassword = servicePassword;
    }

}