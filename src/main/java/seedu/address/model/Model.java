package seedu.address.model;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Predicate;

import javafx.collections.ObservableList;

import seedu.address.model.entry.ResumeEntry;
import seedu.address.model.person.Person;
import seedu.address.model.resume.Resume;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = person -> true;
    Predicate<ResumeEntry> PREDICATE_SHOW_ALL_ENTRIES = entry -> true;

    /** Clears existing backing model and replaces with the provided new data. */
    void resetData(ReadOnlyAddressBook newData);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * returns the entryBook
     */
    ReadOnlyEntryBook getEntryBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     *
     * @param entry to be searched
     * @return true if an entry with the same identity as {@code entry} exists in the ResuMaker.
     */
    boolean hasEntry(ResumeEntry entry);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Adds the given person.
     * {@code entry} must not already exist in the address book.
     */
    void addEntry(ResumeEntry entry);


    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void updatePerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<ResumeEntry> getFilteredEntryList();
    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredEntryList(Predicate<ResumeEntry> predicate);


    /**
     * Loads a template from the specified filepath.
     */
    void loadTemplate(Path filepath);
    /**
     * Returns true if the model has previous address book states to restore.
     */
    boolean canUndoAddressBook();

    /**
     * Returns true if the model has undone address book states to restore.
     */
    boolean canRedoAddressBook();

    /**
     * Restores the model's address book to its previous state.
     */
    void undoAddressBook();

    /**
     * Restores the model's address book to its previously undone state.
     */
    void redoAddressBook();

    /**
     * Saves the current address book state for undo/redo.
     */
    void commitAddressBook();

    /**
     * Saves the current entry book state for undo/redo.
     */
    void commitEntryBook();

    /**
     * Generates a resume using the current EntryBook and Template.
     */
    void generateResume();

    /**
     * Fetches the last Resume generated (if any).
     */
    Optional<Resume> getLastResume();

    /**
     * Saves the last Resume generated to the specified filepath.
     */
    void saveLastResume(Path filepath);

    /**
     * Returns the name of an Event that possibly matches a given expression.
     * This may not be part of the Model API in V1.4.
     * I have added it here to ensure a user testable feature for V1.2 submission.
     */
    String getPossibleEventName(String expression);
}
