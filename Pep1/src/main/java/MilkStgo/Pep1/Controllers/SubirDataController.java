package MilkStgo.Pep1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import MilkStgo.Pep1.Services.SubirDataService;
import MilkStgo.Pep1.Entities.SubirDataEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping

public class SubirDataController {
    @Autowired
    private SubirDataService subirData;

    @GetMapping("/acopioUpload")
    public String mainAcopio() {
        return "acopioUpload";
    }

    @PostMapping("/acopioUpload")
    public String uploadAcopio(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirData.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        subirData.leerCsvAcopio(file.getOriginalFilename());
        return "redirect:/acopioUpload";
    }

    @GetMapping("/porcentajeUpload")
    public String mainPorcentaje() {
        return "porcentajeUpload";
    }

    @PostMapping("/porcentajeUpload")
    public String uploadPorcentaje(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirData.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        subirData.leerCsvAcopio(file.getOriginalFilename());
        return "redirect:/porcentajeUpload";
    }



}
