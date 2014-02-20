package be.seriousbusiness.xml_modifier.node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class NodeFactory {
	
	public static final Node create(final Document document,final String name){
		final Element element=document.createElement(name);
		return element;
	}

}
