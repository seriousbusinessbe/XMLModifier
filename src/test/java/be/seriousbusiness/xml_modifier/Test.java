package be.seriousbusiness.xml_modifier;

import java.io.File;

import org.w3c.dom.Document;

import be.seriousbusiness.xml_modifier.attribute.AttributeFactory;
import be.seriousbusiness.xml_modifier.document.DocumentFactory;
import be.seriousbusiness.xml_modifier.document.DocumentUtils;
import be.seriousbusiness.xml_modifier.document.DocumentWriter;

public class Test {
	
	public void testModification(){
		final File file=new File("");
		final Document document=DocumentFactory.create(file);
		DocumentUtils.removeAttributes(document,"xmlns:xf");
		DocumentUtils.addAttributeToNodes(document,"xs:schema",AttributeFactory.create(document,"elementFormDefault","qualified"));
		DocumentUtils.addAttributeToNodes(document,"xs:schema",AttributeFactory.create(document,"xmlns:schemas","http://ws.irisboxservices.bru/permisurbanismeform/schemas"));
		DocumentUtils.addAttributeToNodes(document,"xs:schema",AttributeFactory.create(document,"targetNamespace","http://ws.irisboxservices.bru/permisurbanismeform/schemas"));
		DocumentUtils.removeNodes(document,"xs:import");
		// add name="form"
		// remove all type attributes from nodes with children
		DocumentUtils.replaceAttributeValues(document,"type","xf:int","xs:string");
		DocumentUtils.replaceAttributeValues(document,"type","xf:date","xs:string");
		DocumentUtils.replaceAttributeValues(document,"type","xf:float","xs:string");
		DocumentUtils.replaceAttributeValues(document,"type","xf:double","xs:string");
		DocumentUtils.replaceAttributeValues(document,"type","xf:decimal","xs:string");
		DocumentUtils.replaceAttributeValues(document,"type","xf:integer","xs:string");
		DocumentUtils.replaceAttributeValues(document,"type","xforms:boolean","xs:string");
		DocumentUtils.replaceAttributeValues(document,"type","xforms:integer","xs:string");
		DocumentUtils.replaceAttributeValues(document,"type","xforms:decimal","xs:string");
		// DocumentUtils.replaceAttributeValues(document,"base","xs:anyURI","xs:string"); // needed?
		// add attribute type="xs:string" to nodes with no children


		DocumentWriter.write(document,file);
	}

}
