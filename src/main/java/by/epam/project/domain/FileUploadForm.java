package by.epam.project.domain;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FileUploadForm {
    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    private List<MultipartFile> files;

}
