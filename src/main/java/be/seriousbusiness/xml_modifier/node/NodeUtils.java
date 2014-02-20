package be.seriousbusiness.xml_modifier.node;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeUtils {
	private static final Logger LOGGER=LoggerFactory.getLogger(NodeUtils.class);
	
	public static final Set<Node> getChildren(final Node node){
		final Set<Node> children=new HashSet<Node>();
		if(node!=null && node.hasChildNodes()){
			final NodeList childNodeList=node.getChildNodes();
			for(int i=0; i<childNodeList.getLength(); i++){
				children.add(childNodeList.item(i));
			}
		}
		return children;
	}
	
	public static final boolean hasChildren(final Node node){
		return node==null ? false : node.hasChildNodes();
	}
	
	public static final void addChild(final Node node,final Node child){
		if(node!=null){
			node.appendChild(child);
		}
	}
	
	public static final void removeChild(final Node node,final Node child){
		if(node!=null){
			node.removeChild(child);
		}
	}
	
	public static final void recursivelyRemoveChildren(final Node node){
		if(node!=null){
			for(final Node child : NodeUtils.getChildren(node)){
				recursivelyRemoveChildren(child);
				node.removeChild(child);
			}
		}
	}
	
	public static final boolean recursivelyRemoveNode(final Node node,final String name){
		if(node!=null){
			final Set<Node> children=new HashSet<Node>();
			for(final Node child : NodeUtils.getChildren(node)){
				if(recursivelyRemoveNode(child,name)){
					children.add(child);
				}
			}
			for(final Node child : children){
				node.removeChild(child);
			}
			final String nodeName=node.getNodeName();
			if(nodeName!=null && nodeName.equals(name)){
				recursivelyRemoveChildren(node);
				return true;
			}
		}
		return false;
	}
		
	public static final Node getAttribute(final Node node,final String name){
		if(node==null){
			throw new IllegalArgumentException("The node is null.");
		}else if(name==null || name.isEmpty()){
			throw new IllegalArgumentException("The attribute's name is null or empty.");
		}else{
			final NamedNodeMap namedNodeMap=node.getAttributes();
			if(namedNodeMap!=null){
				return namedNodeMap.getNamedItem(name);
			}
		}
		return null;
	}
	
	public static final void replaceAttributeValue(final Node node,final String name,final String value,final String newValue){
		if(node!=null && name!=null){
			if(value==null){
				throw new IllegalArgumentException("The attribute's value is null.");
			}else if(newValue==null){
				throw new IllegalArgumentException("The attribute's new value is null.");
			}else{
				final Node attribute=getAttribute(node,name);
				if(attribute!=null && !value.equals(newValue)){
					final String attributeValue=attribute.getNodeValue();
					if(attributeValue!=null && attributeValue.equals(value)){
						attribute.setNodeValue(newValue);
					}
				}
			}
		}else{
			LOGGER.debug("Attribute value is not set if the node or name is null.");
		}
	}
	
	public static final void recursivelyReplaceAttributeValue(final Node node,final String name,final String value,final String newValue){
		for(final Node child : NodeUtils.getChildren(node)){
			recursivelyReplaceAttributeValue(child,name,value,newValue);
		}
		replaceAttributeValue(node,name,value,newValue);
	}
	
	
	public static final void addAttribute(final Node node,final Attr attribute){
		if(node!=null){
			node.getAttributes().setNamedItem(attribute);
		}
	}
	
	public static final void addAttribute(final Node node,final String name,final Attr attribute){
		if(node!=null){
			final String nodeName=node.getNodeName();
			if(nodeName!=null && nodeName.equals(name)){
				node.getAttributes().setNamedItem(attribute);
			}
		}
	}
	
	public static final void recursivelyAddAttribute(final Node node,final String name,final Attr attribute){
		for(final Node child : NodeUtils.getChildren(node)){
			recursivelyAddAttribute(child,name,attribute);
		}
		addAttribute(node,name,attribute);
	}
	
	public static final void removeAttribute(final Node node,final String name){
		if(node!=null){
			final NamedNodeMap namedNodeMap=node.getAttributes();
			if(namedNodeMap!=null){
				namedNodeMap.removeNamedItem(name);
			}
		}
	}
	
	public static final void recursivelyRemoveAttribute(final Node node,final String name){
		for(final Node child : NodeUtils.getChildren(node)){
			recursivelyRemoveAttribute(child,name);
		}
		removeAttribute(node,name);
	}

}
