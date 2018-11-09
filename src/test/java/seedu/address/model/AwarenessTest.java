package seedu.address.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.TreeMap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.model.awareness.Awareness;
import seedu.address.model.awareness.Dictionary;
import seedu.address.model.entry.ResumeEntry;
import seedu.address.model.util.SampleDataUtil;

public class AwarenessTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void constructor_null_throwsNullPointerException() {
        thrown.expect(NullPointerException.class);

        Dictionary dictionary = null;
        TreeMap<String, ResumeEntry> nameToEntryMappings = null;

        new Awareness(dictionary, nameToEntryMappings);
    }

    @Test
    public void equals() {

        Dictionary sampleDictionary = SampleDataUtil.getSampleDictionary();
        Dictionary emptyDictionary = new Dictionary();

        TreeMap<String, ResumeEntry> sampleNameToEntryMappings = SampleDataUtil.makeNameToEntryMappings();
        TreeMap<String, ResumeEntry> emptyNameToEntrMappings = new TreeMap<String, ResumeEntry>();

        // same mappings in both dictionary and treemap --> true
        Awareness sampleAwareness = SampleDataUtil.getSampleAwareness();
        Awareness sampleAwarenessDuplicate = new Awareness(sampleDictionary, sampleNameToEntryMappings);

        assertTrue(sampleAwareness.equals(sampleAwarenessDuplicate));

        // different mappings in dictionary, same mappings in treemap --> false

        assertFalse(sampleAwareness.equals(new Awareness(emptyDictionary, sampleNameToEntryMappings)));

        // same mappings in dictionary, different mappings treemap --> false

        assertFalse(sampleAwareness.equals(new Awareness(sampleDictionary, emptyNameToEntrMappings)));


    }

}
