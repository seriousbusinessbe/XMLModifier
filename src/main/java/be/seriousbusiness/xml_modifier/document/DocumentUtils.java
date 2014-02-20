package be.seriousbusiness.xml_modifier.document;

import org.w3c.dom.Document;

import be.seriousbusiness.xml_modifier.node.NodeUtils;

public class DocumentUtils {
	
	public static final void setAttributeValue(final Document document,final String name,final String value,final String newValue){
		NodeUtils.setRecursiveAttributeValue(document.getFirstChild(), name, value, newValue);
	}

}
