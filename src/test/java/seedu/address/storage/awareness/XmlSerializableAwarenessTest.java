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

    private static final Path TYPICAL_AWARENESS_FILE = TEST_DATA_FOLDER("typicalAwareness.xml");

    private static final Path MISSING_CONTEXTENTRY_FILE = TEST_DATA_FOLDER.resolve("missingContextEntry.xml");
    private static final Path DUPLICATE_EVENTNAMES_FILE = TEST_DATA_FOLDER.resolve("duplicateEventNames.xml");
    private static final Path EMPTY_EVENTNAME_FILE = TEST_DATA_FOLDER.resolve("emptyEventName.xml");
    private static final Path WHITESPACE_EVENTNAME_FILE = TEST_DATA_FOLDER.resolve("whitespaceEventName.xml");

    private static final Path DUPLICATE_SLANG_FILE = TEST_DATA_FOLDER.resolve("duplicateSlang.xml");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void toModelType_typicalAwarenessFile_success() throws Exception {
        XmlSerializableAwareness dataFromFile =
                XmlSerializableAwareness.loadDataFromSaveFile(TYPICAL_AWARENESS_FILE);

        // wip to add equals check to assert test success
        dataFromFile.toModelType();
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

    @Test
    public void toModelType_emptyEventName_throwsIllegalValueException() throws Exception {
        XmlSerializableAwareness dataFromFile =
                XmlSerializableAwareness.loadDataFromSaveFile(EMPTY_EVENTNAME_FILE);

        thrown.expect(IllegalValueException.class);
        dataFromFile.toModelType();
    }

    @Test
    public void toModelType_whitespaceEventName_throwsIllegalValueException() throws Exception {
        XmlSerializableAwareness dataFromFile =
                XmlSerializableAwareness.loadDataFromSaveFile(WHITESPACE_EVENTNAME_FILE);

        thrown.expect(IllegalValueException.class);
        dataFromFile.toModelType();
    }

    @Test
    public void toModelType_duplicateSlang_throwsIllegalValueException() throws Exception {
        XmlSerializableAwareness dataFromFile =
                XmlSerializableAwareness.loadDataFromSaveFile(DUPLICATE_SLANG_FILE);

        thrown.expect(IllegalValueException.class);
        dataFromFile.toModelType();
    }






}
