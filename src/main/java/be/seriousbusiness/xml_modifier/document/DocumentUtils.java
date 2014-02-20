package be.seriousbusiness.xml_modifier.document;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

import be.seriousbusiness.xml_modifier.node.NodeUtils;

public class DocumentUtils {
	
	/**
	 * Replace the value of all attributes with a given name.
	 * @param document
	 * @param name
	 * @param value
	 * @param newValue
	 */
	public static final void replaceAttributeValues(final Document document,final String name,final String value,final String newValue){
		NodeUtils.recursivelyReplaceAttributeValue(document.getFirstChild(),name,value,newValue);
	}
	
	/**
	 * Remove all nodes by name.
	 * @param document
	 * @param name
	 */
	public static final void removeNodes(final Document document,final String name){
		NodeUtils.recursivelyRemoveNode(document.getFirstChild(),name);
	}
	
	/**
	 * Remove all attributes by name.
	 * @param document
	 * @param name
	 */
	public static final void removeAttributes(final Document document,final String name){
		NodeUtils.recursivelyRemoveAttribute(document.getFirstChild(),name);
	}
	
	/**
	 * Add a new attribute to all nodes with given name.
	 * @param document
	 * @param name
	 * @param attribute
	 */
	public static final void addAttributeToNodes(final Document document,final String name,final Attr attribute){
		NodeUtils.recursivelyAddAttribute(document.getFirstChild(),name,attribute);
	}

}
