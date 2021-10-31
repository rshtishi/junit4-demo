package com.github.rshtishi;

import com.github.rshtishi.doc.Request;
import com.github.rshtishi.doc.TaskService;
import org.jfree.data.gantt.Task;

import java.util.concurrent.ExecutorService;

public class Server {

    private final ExecutorService executorService;
    private final TaskService taskService;

    public Server(TaskService taskService, ExecutorService executorService) {
        this.taskService = taskService;
        this.executorService = executorService;
    }

    public void serve(Request request){
        for(Task task:request.getTasks()){
            executorService.submit(new TaskHandler(taskService, task));
        }
    }

    private class TaskHandler implements Runnable {

        private final TaskService taskService;
        private final Task task;

        public TaskHandler(TaskService taskService, Task task){
            this.taskService = taskService;
            this.task = task;
        }

        @Override
        public void run() {
            this.taskService.handle(task);
        }
    }
}
