package MilkStgo.Pep1;

import MilkStgo.Pep1.Entities.PorcentajeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import MilkStgo.Pep1.Repositories.PorcentajeRepository;
import MilkStgo.Pep1.Services.PorcentajeService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PorcentajeServiceTests {
    @Autowired
    private PorcentajeService porcentajeService;

    @Autowired
    private PorcentajeRepository porcentajeRepository;

    @Test
    public void testObtenerCantArchivos()
    {
        //##############################################################
        // Poblando db con datos dummies

        PorcentajeEntity porcentaje = new PorcentajeEntity();
        porcentaje.setID_PORCENTAJE(1);
        porcentaje.setID_archivo(1);
        porcentaje.setCod_proveedor("1003");
        porcentaje.setGrasa(15);
        porcentaje.setSolido(15);
        porcentaje.setFecha("17/03/2023");

        porcentajeRepository.save(porcentaje);

        PorcentajeEntity porcentaje2 = new PorcentajeEntity();
        porcentaje2.setID_PORCENTAJE(2);
        porcentaje2.setID_archivo(2);
        porcentaje2.setCod_proveedor("1003");
        porcentaje2.setGrasa(20);
        porcentaje2.setSolido(10);
        porcentaje2.setFecha("28/02/2023");

        porcentajeRepository.save(porcentaje2);

        //##############################################################

        ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentaje();
        int result = porcentajeService.obtenerCantArchivos(porcentajes);

        assertEquals(1, result);

        porcentajeService.eliminarData(porcentajes);
    }

    @Test
    public void testObtenerGrasa()
    {
        //##############################################################
        // Poblando db con datos dummies

        PorcentajeEntity porcentaje = new PorcentajeEntity();
        porcentaje.setID_PORCENTAJE(1);
        porcentaje.setID_archivo(1);
        porcentaje.setCod_proveedor("1003");
        porcentaje.setGrasa(15);
        porcentaje.setSolido(15);
        porcentaje.setFecha("17/03/2023");

        porcentajeRepository.save(porcentaje);

        PorcentajeEntity porcentaje2 = new PorcentajeEntity();
        porcentaje2.setID_PORCENTAJE(2);
        porcentaje2.setID_archivo(2);
        porcentaje2.setCod_proveedor("1003");
        porcentaje2.setGrasa(20);
        porcentaje2.setSolido(10);
        porcentaje2.setFecha("28/02/2023");

        porcentajeRepository.save(porcentaje2);

        //##############################################################

        int result = porcentajeService.obtenerGrasa("1003");

        assertEquals(20, result);

        ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentaje();
        porcentajeService.eliminarData(porcentajes);
    }

    // El acopio actual tiene un 66% más de grasa
    @Test
    public void testObtenerDiferenciaGrasa2()
    {
        //##############################################################
        // Poblando db con datos dummies

        PorcentajeEntity porcentaje = new PorcentajeEntity();
        porcentaje.setID_PORCENTAJE(1);
        porcentaje.setID_archivo(1);
        porcentaje.setCod_proveedor("1003");
        porcentaje.setGrasa(15);
        porcentaje.setSolido(15);
        porcentaje.setFecha("17/03/2023");

        porcentajeRepository.save(porcentaje);

        //##############################################################

        String result = porcentajeService.obtenerDiferenciaGrasa("1003");

        assertEquals("0", result);

        ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentaje();
        porcentajeService.eliminarData(porcentajes);
    }
}
