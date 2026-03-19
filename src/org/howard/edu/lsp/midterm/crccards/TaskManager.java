/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This manages a collection of Task objects.
 * It can add tasks, find them by ID, and get them by status.
 * 
 * @author Precious Ikejiofor
 */
public class TaskManager {
    private Map<String, Task> tasks;
    
    /**
     * Makes an empty TaskManager.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }
    
    /**
     * Adds a task to the manager.
     * 
     * @param task the task to add
     * @throws IllegalArgumentException if task ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task with ID " + task.getTaskId() + " already exists");
        }
        tasks.put(task.getTaskId(), task);
    }
    
    /**
     * Finds a task by its ID.
     * 
     * @param taskId the ID to look for
     * @return the task if found, null otherwise
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }
    
    /**
     * Gets all tasks with the given status.
     * 
     * @param status the status to filter by
     * @return a List of tasks with that status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}