package seedu.address.storage;

import static seedu.address.commons.util.StringUtil.isEmptyString;
import static seedu.address.commons.util.StringUtil.isOnlyWhiteSpace;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.entry.ResumeEntry;
import seedu.address.storage.entry.XmlAdaptedResumeEntry;

public class XmlAdaptedContextEntry {

    @XmlAttribute
    private String eventName;

    @XmlElement
    private XmlAdaptedResumeEntry entry;

    public String getEventName() throws IllegalValueException {
        if (eventName == null) {
            throw new IllegalValueException("Every contextual entry must have an event name element.");
        }

        if (isEmptyString(eventName) || isOnlyWhiteSpace(eventName)) {
            throw new IllegalValueException("An event name cannot be an empty string or only whitespace.");
        }

        return eventName;
    }

    public ResumeEntry getEntry() throws IllegalValueException {
        if (entry == null) {
            throw new IllegalValueException("Each contextual entry must have an entry element.");
        }

        return entry.toModelType();
    }

}
