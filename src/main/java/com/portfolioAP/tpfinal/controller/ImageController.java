package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.dto.ImageDTO;

import com.portfolioAP.tpfinal.service.ImageService;
import com.portfolioAP.tpfinal.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/images")
public class ImageController {

   @Autowired
    private ImageService imageService;

   @Autowired
    PersonaService personaService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/img")
    @ResponseBody
    public ImageDTO uploadProfileImage(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        return this.imageService.upload(multipartFile);
    }
}
