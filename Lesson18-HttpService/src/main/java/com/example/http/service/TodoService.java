package com.example.http.service;

import com.example.http.model.Todo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

public interface TodoService {

    // 一個方法就是一個遠程服務(遠程調用)
    @GetExchange("/todos/{id}")
    Todo getTodoById(@PathVariable("id") Integer id);

    @PostExchange(value = "/todos/", accept = MediaType.APPLICATION_JSON_VALUE)
    Todo createTodo(@RequestBody Todo todo);

    // 修改資源
    @PutExchange("/todos/{id}")
    ResponseEntity<Todo> modifyTodo(@PathVariable Integer id, @RequestBody Todo todo);

    // 刪除
    @DeleteExchange("/todos/{sid}")
    void removeTodo(@PathVariable("sid") Integer id);

}
