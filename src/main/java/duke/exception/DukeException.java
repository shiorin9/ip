package duke.exception;

import duke.ui.Ui;

public class DukeException extends Exception {
    /**
     * Constructs a {@code duke.exception.DukeException} with the specified detail
     * message.
     *
     * @param message The detail message.
     */
    public DukeException (String message) {
        super(message);
    }

    /**
     * Prints the exception message.
     */
    public void printExceptionMessage() {
        Ui.printLine(this.getMessage());
    }
}
