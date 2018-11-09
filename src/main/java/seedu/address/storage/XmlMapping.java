package seedu.address.storage;

import java.util.HashSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  This class holds a full phrase and, optionally, a set of slang corresponding to this full phrase.
 *  For example, a full phrase could be "computer science" and the set of slang would be {"cs", "compsci"}.
 *  Note that it is ok for a full phrase to be associated with no slang.
 *
 *  It is meant to be JAXB friendly - i.e. meant to be used to des-serialize mappings held in XML, into a Java object
 *  representation.
 */

@XmlRootElement
public class XmlMapping {

    @XmlElement
    private String fullPhrase;

    @XmlElement
    private HashSet<String> slang;

    /* JAXB requires a default constructor */
    public XmlMapping() {}

    public String getFullPhrase() {
        return fullPhrase;
    }

    public HashSet<String> getSlang() {
        return slang;
    }

    @Override
    public String toString() {
        return fullPhrase + "[" + slang + "]";
    }
}
