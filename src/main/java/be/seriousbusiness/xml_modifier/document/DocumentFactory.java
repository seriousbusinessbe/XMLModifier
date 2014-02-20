package be.seriousbusiness.xml_modifier.document;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author Stefan Borghys
 */
public class DocumentFactory {
	private static final Logger LOGGER=LoggerFactory.getLogger(DocumentFactory.class);

	public static final Document create(final File file) throws IllegalArgumentException, DocumentException{
		if(file==null){
			throw new IllegalArgumentException("The file is null.");
		}else{
			final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			try {
				final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				try {
					return documentBuilder.parse(file);
				} catch (final SAXException e) {
					LOGGER.error("A document could not be parsed from file {}.",file.getAbsolutePath(),e);
					throw new DocumentException("Document could not be parsed from file.");
				} catch (final IOException e) {
					LOGGER.error("A document could not be created from file {}.",file.getAbsolutePath(),e);
					throw new DocumentException("Document could not be created from file.");
				}
			} catch (final ParserConfigurationException e) {
				LOGGER.error("A DocumentBuilder could not be created.",e);
				throw new DocumentException("Document could not be created.");
			}
		}
	}

}
