package seedu.address.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.model.awareness.Awareness;
import seedu.address.model.awareness.Dictionary;
import seedu.address.model.entry.ResumeEntry;

import java.util.TreeMap;

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

}
