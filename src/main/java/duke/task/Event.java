package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Event extends Task {
    /**
     * Sets the task description and it's task type to Events.
     *
     * @param description Description of the task.
     */
    public Event(String description) {
        super(description + ")");
        this.taskType = "E";
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     * @throws DukeException If no event is given or event is invalid.
     */
    public static String printEvent(ArrayList<Task> tasks, String userInput) throws DukeException {
        int atIndex = userInput.indexOf("/at");
        if (userInput.substring(5).isBlank()) {
            throw new DukeException("    Why u nvr give any event sia :<" + Duke.LS);
        } else if (!userInput.contains("/at") || userInput.substring(5, atIndex).isBlank()
                || userInput.substring(atIndex + 3).isBlank()) {
            throw new DukeException("    Ur event seems wrong sia" + Duke.LS);
        }
        String event = userInput.substring(5).replace("/at","(at:");
        tasks.add(new Event(event));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]"
                + event + ")" + Duke.LS;
        String tasksLeft = "    Now you have " + getNumberOfTasks()
                + " tasks in the list."+ Duke.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
