package be.seriousbusiness.xml_modifier.document;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 * @author Stefan Borghys
 */
public class DocumentWriter {
	private static final Logger LOGGER=LoggerFactory.getLogger(DocumentWriter.class);
	
	public static final void write(final Document document,final File file) throws IllegalArgumentException, DocumentException{
		if(document==null){
			throw new IllegalArgumentException("The document is null.");
		}else if(file==null){
			throw new IllegalArgumentException("The file is null.");
		}else{
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			try {
				final Transformer transformer = transformerFactory.newTransformer();
				final DOMSource domSource = new DOMSource(document);
				final StreamResult streamResult = new StreamResult(file);
				try {
					transformer.transform(domSource,streamResult);
				} catch (final TransformerException e) {
					LOGGER.error("The document could not be transformed into file {}.",file.getAbsolutePath(),e);
					throw new DocumentException("The document could not be written.");
				}
			} catch (final TransformerConfigurationException e) {
				LOGGER.error("A Transformer could not be created.",e);
				throw new DocumentException("The document could not be written.");
			}
		}
		
	}

}
