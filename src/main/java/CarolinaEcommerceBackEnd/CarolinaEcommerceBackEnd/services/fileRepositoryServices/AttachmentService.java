package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.fileRepositoryServices;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;

    List<Attachment> findAll();

    Attachment findFileById(String fileId);

    void deleteFile(String fileId);


}
