package MilkStgo.Pep1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import MilkStgo.Pep1.Services.ProveedorService;
import MilkStgo.Pep1.Entities.ProveedorEntity;


@Controller
@RequestMapping
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/lista-proveedores")
    public String listar(Model model) {
        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        model.addAttribute("proveedores", proveedores);
        return "VisualizarProveedores";
    }

    @GetMapping("/nuevo-proveedor")
    public String proveedor(){
        return "IngresarProveedor";
    }
    @PostMapping("/nuevo-proveedor")
    public String nuevoProveedor(@RequestParam("codigo") String codigo,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("categoria") String categoria,
                                 @RequestParam("retencion") Boolean retencion){
        proveedorService.guardarProveedor(codigo, nombre, categoria, retencion);
        return "redirect:/lista-proveedores";
    }
}
