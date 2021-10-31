package com.github.rshtishi;

import com.github.rshtishi.doc.Request;
import com.github.rshtishi.doc.TaskService;
import org.awaitility.Awaitility;
import org.jfree.data.gantt.Task;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServerTest {

    @Test
    public void shouldSaveTasks() {
        //setup
        final Task task = mock(Task.class);
        List<Task> tasks = Arrays.asList(task);
        final TaskService taskService = mock(TaskService.class);
        doNothing().when(taskService).handle(task);
        Request request = mock(Request.class);
        when(request.getTasks()).thenReturn(tasks);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Server server = new Server(taskService, executorService);
        //execute
        server.serve(request);
        //verify
        Awaitility.await().atMost(1, TimeUnit.SECONDS)
                .with().pollInterval(100, TimeUnit.MILLISECONDS)
                .until(new Callable<Boolean>() {

                    @Override
                    public Boolean call() throws Exception {
                        try{
                            verify(taskService).handle(task);
                            return true;
                        } catch(AssertionError error){
                            return false;
                        }
                    }
                });
    }

}