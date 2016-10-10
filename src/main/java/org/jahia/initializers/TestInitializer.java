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
public class TestInitializer implements ModuleChoiceListInitializer {
    private transient static Logger logger = LoggerFactory.getLogger(TestInitializer.class);
    private String key;

    public List<ChoiceListValue> getChoiceListValues(ExtendedPropertyDefinition epd, String param,
                                                     List<ChoiceListValue> values, Locale locale,
                                                     Map<String, Object> context) {

        JCRNodeWrapper node = (JCRNodeWrapper) context.get("contextParent");
        String title = node.getPropertyAsString("jcr:title");
        logger.info("****** Got into TestInitlializer - title is : " + title);

        List<ChoiceListValue> choiceListValues = new ArrayList<ChoiceListValue>();

        if ("Title 1".equals(title)) {
            choiceListValues.add(new ChoiceListValue("value1", null, new StringValue("1")));
            choiceListValues.add(new ChoiceListValue("value2", null, new StringValue("2")));
            choiceListValues.add(new ChoiceListValue("value3", null, new StringValue("3")));
        } else if ("Other".equals(title)){
            choiceListValues.add(new ChoiceListValue("value6", null, new StringValue("1")));
            choiceListValues.add(new ChoiceListValue("value7", null, new StringValue("2")));
            choiceListValues.add(new ChoiceListValue("value8", null, new StringValue("3")));

        } else {
            String x = null;
            x.getClass();
        }
        return choiceListValues;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}