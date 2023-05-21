package MilkStgo.Pep1.Controllers;


import MilkStgo.Pep1.Entities.PlanillaEntity;
import MilkStgo.Pep1.Entities.ProveedorEntity;
import MilkStgo.Pep1.Services.PagoFinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import MilkStgo.Pep1.Services.ProveedorService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping
public class PlanillaController {
    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private PagoFinalService pagoFinalService;

    @GetMapping("/planillaSelect")
    public String main(Model model){
        ArrayList<ProveedorEntity> proveedores= proveedorService.obtenerProveedores();
        if (proveedores.isEmpty()){
            model.addAttribute("NoProveedores", "No Existen proveedores ingresados en el sistema.");
        }
        else{
            model.addAttribute("proveedores", proveedores);
        }
        return "SeleccionPlanilla";
    }

    @GetMapping("/planillaGenerate")
    public String generarPlanilla(Model model, @RequestParam("codigo") String codigo){
        System.out.println("Antes de generar planilla");
        PlanillaEntity planilla = pagoFinalService.generarPlanilla(codigo);
        System.out.println("Generando planilla");
        if (planilla == null){
            model.addAttribute("NoDataMessage", "No existen pagos asociados a este codigo de proveedor");
        }
        else{
            model.addAttribute("planilla", planilla);
        }
        return "GenerarPlanilla";
    }
}
