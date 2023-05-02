package com.example.http;

import com.example.http.model.Album;
import com.example.http.record.AlbumRecord;
import com.example.http.service.AlbumService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAlbumsService {
    
    @Resource
    private AlbumService albumService;

    @Test
    void testQuery() {
        Album album = albumService.getById(5);
        System.out.println("album = " + album);
    }

    @Test
    void testRecord() {
        try{
            AlbumRecord record = albumService.getByIdReturnRecord(211);
            System.out.println("record = " + record);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
