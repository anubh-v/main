package seedu.address.storage;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.XmlUtil;
import seedu.address.model.awareness.Awareness;
import seedu.address.model.awareness.Dictionary;
import seedu.address.model.entry.ResumeEntry;

/**
 * This class is used to de-serialize XML data into an in-memory Awareness object.
 * It controls the logic used to perform the de-serialization.
 */
@XmlRootElement(name = "awareness")
public class XmlSerializableAwareness {

    @XmlElement (name = "mapping")
    private LinkedList<XmlMapping> mappings;

    @XmlElement (name = "context-entry")
    private List<XmlAdaptedContextEntry> contextEntries;

    /* Default constructor is needed for the JAXB library to work */
    public XmlSerializableAwareness() {

    }

    public XmlSerializableAwareness(LinkedList<XmlMapping> mappings) {
        this.mappings = mappings;
    }

    /**
     * Convert XML data to an instance of XmlSerializableAwareness object.
     *
     * @param file the path to the XML data
     * @return an instance of XmlSerializableAwareness
     * @throws DataConversionException
     * @throws FileNotFoundException
     */
    public static XmlSerializableAwareness loadDataFromSaveFile(Path file) throws DataConversionException,
            FileNotFoundException {
        try {
            return XmlUtil.getDataFromFile(file, XmlSerializableAwareness.class);
        } catch (JAXBException e) {
            throw new DataConversionException(e);
        }
    }

    /**
     * Uses the data in this XmlSerializableAwareness object to generate an instance of Awareness.
     *
     * @return an instance of Awareness, representing the data held by this XmlSerializableAwareness object
     */
    public Awareness toModelType() throws IllegalValueException {

        Dictionary dictionary = new Dictionary();
        TreeMap<String, ResumeEntry> nameToEntryMappings = new TreeMap<String, ResumeEntry>();

        for (XmlMapping map : mappings) {
            String currentFullPhrase = map.getFullPhrase();
            HashSet<String> slangSet = map.getSlang();

            dictionary.registerFullPhrase(currentFullPhrase);

            if (slangSet == null) {
                // current full phrase is not associated with any slang
                continue;
            }

            for (String eachSlang : slangSet) {
                dictionary.registerMapping(eachSlang, currentFullPhrase);
            }
        }

        // wip construct and return a new Awareness object
        return new Awareness();
    }

    @Override
    public String toString() {
        return this.mappings.toString();
    }
}
