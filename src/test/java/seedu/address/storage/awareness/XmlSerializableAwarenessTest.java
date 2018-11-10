package seedu.address.storage.awareness;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.storage.XmlSerializableAwareness;


public class XmlSerializableAwarenessTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "XmlSerializableAwarenessTest");
    private static final Path MISSING_CONTEXTENTRY_FILE = TEST_DATA_FOLDER.resolve("missingContextEntry.xml");
    private static final Path DUPLICATE_EVENTNAMES_FILE = TEST_DATA_FOLDER.resolve("duplicateEventNames.xml");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void toModelType_typicalAwarenessFile_success() throws Exception {
      // wip to add positive test case
    }

    @Test
    public void toModelType_missingContextEntryFile_throwsIllegalValueException() throws Exception {
        XmlSerializableAwareness dataFromFile =
                XmlSerializableAwareness.loadDataFromSaveFile(MISSING_CONTEXTENTRY_FILE);

        thrown.expect(IllegalValueException.class);
        dataFromFile.toModelType();
    }

    @Test
    public void toModelType_duplicateEventNames_throwsIllegalValueException() throws Exception {
        XmlSerializableAwareness dataFromFile =
                XmlSerializableAwareness.loadDataFromSaveFile(DUPLICATE_EVENTNAMES_FILE);

        thrown.expect(IllegalValueException.class);
        dataFromFile.toModelType();
    }






}
