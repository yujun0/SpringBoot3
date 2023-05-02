package com.example.http.service;

import com.example.http.model.Album;
import com.example.http.record.AlbumRecord;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "https://jsonplaceholder.typicode.com/")
public interface AlbumService {

    // 查詢專輯
    @HttpExchange(method = "GET", url = "/albums/{id}")
    Album getById(@PathVariable Integer id);

    // 使用 Java Record
    @HttpExchange(method = "GET", url = "/albums/{id}", contentType = MediaType.APPLICATION_JSON_VALUE)
    AlbumRecord getByIdReturnRecord(@PathVariable Integer id);
}
