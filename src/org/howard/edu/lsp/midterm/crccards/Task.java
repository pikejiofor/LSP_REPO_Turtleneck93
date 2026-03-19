/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.crccards;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a task in the TMS (Task Management System).
 * Every task will have an unique ID, description, and status.
 * 
 * @author Precious Ikejiofor
 */
public class Task {
    private String taskId;
    private String description;
    private String status;
    
    // These are the valid status values
    private static final Set<String> VALID_STATUSES = new HashSet<>();
    
    static {
        VALID_STATUSES.add("OPEN");
        VALID_STATUSES.add("IN_PROGRESS");
        VALID_STATUSES.add("COMPLETE");
    }
    
    /**
     * Makes a new Task with the ID's and description's.
     * By default the status is set to "OPEN".
     * 
     * @param taskId the unique identifier for this task
     * @param description the description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }
    
    /**
     * Gets the task ID.
     * 
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }
    
    /**
     * Gets the task description.
     * 
     * @return the task description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Gets the current status.
     * 
     * @return the task status
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Sets the task status.
     * If the status is not valid, sets to "UNKNOWN".
     * 
     * @param status the new status to set
     */
    public void setStatus(String status) {
        if (VALID_STATUSES.contains(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }
    
    /**
     * Returns task as: taskId description [status].
     * 
     * @return formatted task string
     */
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}