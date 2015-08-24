package by.epam.project.web;

import by.epam.project.domain.FileUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileUploadController {

    public String getPath() throws UnsupportedEncodingException {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
        String reponsePath = new File(pathArr[0]).getPath() + File.separatorChar;
        return reponsePath;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String displayForm() {
        return "file_upload_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
                       Model map) {

        try {
            MultipartFile multipartFile = uploadForm.getFile();
            String saveDirectory = getPath();
            String fileName = "";

            if (multipartFile != null) {
                fileName = multipartFile.getOriginalFilename();
                multipartFile.transferTo(new File(saveDirectory + fileName));
            }

            map.addAttribute("files", fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "file_upload_success";
    }

}
