package by.epam.project.web;

import by.epam.project.domain.FileUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/files")
public class FileUploadController {
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String displayForm() {
        return "file_upload_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
                       Model map) {

        MultipartFile multipartFile = uploadForm.getFile();
        String saveDirectory = "c:/";

        String fileName = "";

        if (multipartFile != null) {

            fileName = multipartFile.getOriginalFilename();
            try {
                multipartFile.transferTo(new File(saveDirectory + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        map.addAttribute("files", fileName);
        return "file_upload_success";
    }

}
