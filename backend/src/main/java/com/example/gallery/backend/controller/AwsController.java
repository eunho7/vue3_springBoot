package com.example.gallery.backend.controller;

import com.example.gallery.backend.dto.FileDeleteDto;
import com.example.gallery.backend.dto.FileNameDto;
import com.example.gallery.backend.file.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/aws")
public class AwsController {

    private final S3Uploader s3Uploader;

    @PostMapping("/create")
    public ResponseEntity<?> uploadFile(MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok().body(s3Uploader.create(multipartFile));
    }

    @GetMapping("/read/{fileName}")
    public ResponseEntity<?> findFile(@PathVariable String fileName) throws IOException {
        return s3Uploader.read(fileName);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateFile(FileDeleteDto fileDeleteDto) throws IOException {
        return ResponseEntity.ok().body(s3Uploader.update(fileDeleteDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteFile(@RequestBody FileNameDto fileName) {
        s3Uploader.delete(fileName.getFileName());
        return ResponseEntity.ok().body(null);
    }
}
