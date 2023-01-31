package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Attachment;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.ResponseData;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.fileRepositoryFolder.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AttachmentController {
    @Autowired
    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        Attachment attachment = null;

        String downloadURl = "";

        attachment = attachmentService.saveAttachment(file);

        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

        return new ResponseData(attachment.getFileName(),
                downloadURl,
                file.getContentType(),
                (int) file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }


    @GetMapping("/files")
    public ResponseEntity<List<Attachment>> getAllFiles(){
        List<Attachment> allFiles= attachmentService.findAll();
        return new ResponseEntity<List<Attachment>>(allFiles, HttpStatus.OK);
    }



    @GetMapping("/files/{id}")
    public ResponseEntity<Attachment> getFileById(@PathVariable("id") String id){
        Attachment file= attachmentService.findFileById(id);

        return new ResponseEntity<Attachment>(file,HttpStatus.OK);

    }


    @DeleteMapping("/files/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable("id")String id){
        attachmentService.deleteFile(id);
       return new  ResponseEntity<String>("file deleted",HttpStatus.OK);
    }






}
