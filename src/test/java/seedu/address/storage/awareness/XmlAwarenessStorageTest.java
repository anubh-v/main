package seedu.address.storage.awareness;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import seedu.address.model.awareness.Awareness;
import seedu.address.storage.XmlAwarenessStorage;

import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.Assert.assertFalse;

public class XmlAwarenessStorageTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Optional<Awareness> readAwareness(String filePath) throws Exception {
        return new XmlAwarenessStorage(Paths.get(filePath)).readAwarenessData();
    }

    @Test
    public void readAddressBook_nullFilePath_throwsNullPointerException() throws Exception {
        thrown.expect(NullPointerException.class);
        readAwareness(null);
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readAwareness("NonExistentFile.xml").isPresent());
    }


}
