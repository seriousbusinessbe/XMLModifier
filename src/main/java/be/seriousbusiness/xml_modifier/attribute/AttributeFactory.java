package be.seriousbusiness.xml_modifier.attribute;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class AttributeFactory {
	
	public static final Attr create(final Document document,final String name){
		return document.createAttribute(name);
	}
	
	public static final Attr create(final Document document,final String name,final String value){
		final Attr attribute=document.createAttribute(name);
		attribute.setValue(value);
		return attribute;
	}

}
