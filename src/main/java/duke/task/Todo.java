package duke.task;

import java.util.ArrayList;

import duke.Duke;
import duke.exception.DukeException;

public class Todo extends Task {
    /**
     * Sets the task description and it's task type to task.Todo.
     *
     * @param description Description of the task.
     */
    public Todo(String description) {
        super(description);
        this.taskType = "T";
    }

    /**
     * Returns the newly added task in the list and the number of remaining tasks to complete.
     *
     * @param tasks A list used to store the tasks.
     * @param userInput User input.
     * @return Newly added task in the list and the number of remaining tasks to complete.
     * @throws DukeException If the no todo is given.
     */
    public static String printTodo(ArrayList<Task> tasks, String userInput) throws DukeException {
        if (userInput.substring(4).isBlank()) {
            throw new DukeException("    Pls gimme something to do leh ._." + Duke.LS);
        }
        String todo = userInput.substring(4);
        tasks.add(new Todo(todo));
        String taskType = "    " + tasks.get(getNumberOfTasks() - 1).getTaskType();
        String statusIcon = "[" + tasks.get(getNumberOfTasks() - 1).getStatusIcon() + "]" + todo + Duke.LS;
        String tasksLeft = "    Now you have " + getNumberOfTasks()
                + " tasks in the list." + Duke.LS;
        return ADDED + taskType + statusIcon + tasksLeft;
    }
}
