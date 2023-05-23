package MilkStgo.Pep1;

import MilkStgo.Pep1.Entities.AcopioEntity;
import MilkStgo.Pep1.Repositories.AcopioRepository;
import MilkStgo.Pep1.Services.AcopioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

@SpringBootTest
public class AcopioServiceTests {
    @Autowired
    private AcopioService acopioService;

    @Autowired
    private AcopioRepository acopioRepository;




    @Test
    void contextLoads() {
    }

    // El codigo 1003 debe retornar [True, True] ya que entrego mañana y tarde
    @Test
    public void testObtenerTurnos() {

        // Poblando db con datos dummies

        AcopioEntity acopio1 = new AcopioEntity();
        acopio1.setIDACOPIO(1);
        acopio1.setIDarchivo(2);
        acopio1.setFecha("17/03/2023");
        acopio1.setTurno("M");
        acopio1.setProveedor("1003");
        acopio1.setKls_leche(50);

        AcopioEntity acopio2 = new AcopioEntity();
        acopio2.setIDACOPIO(2);
        acopio2.setIDarchivo(2);
        acopio2.setFecha("17/03/2023");
        acopio2.setTurno("T");
        acopio2.setProveedor("1003");
        acopio2.setKls_leche(50);

        AcopioEntity acopio3 = new AcopioEntity();
        acopio3.setIDACOPIO(3);
        acopio3.setIDarchivo(2);
        acopio3.setFecha("16/03/2023");
        acopio3.setTurno("M");
        acopio3.setProveedor("1000");
        acopio3.setKls_leche(50);

        AcopioEntity acopio4 = new AcopioEntity();
        acopio4.setIDACOPIO(4);
        acopio4.setIDarchivo(1);
        acopio4.setFecha("31/03/2023");
        acopio4.setTurno("M");
        acopio4.setProveedor("1000");
        acopio4.setKls_leche(50);

        AcopioEntity acopio5 = new AcopioEntity();
        acopio5.setIDACOPIO(5);
        acopio5.setIDarchivo(1);
        acopio5.setFecha("31/03/2023");
        acopio5.setTurno("M");
        acopio5.setProveedor("1003");
        acopio5.setKls_leche(25);

        acopioRepository.save(acopio1);
        acopioRepository.save(acopio2);
        acopioRepository.save(acopio3);
        acopioRepository.save(acopio4);
        acopioRepository.save(acopio5);

        //################################################################

        ArrayList<Boolean> expected = new ArrayList<>();
        expected.add(true);
        expected.add(true);

        ArrayList<Boolean> result = acopioService.obtenerTurnos("1003");

        assertEquals(expected, result);

        ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
        acopioService.eliminarData(acopios);
        }
    // Variacion del 400% con 75kg más en relacion al anterior (25kg)
    @Test
    public void testObtenerVariacionLeche(){
        //################################################################
        // Poblando db con datos dummies

        AcopioEntity acopio1 = new AcopioEntity();
        acopio1.setIDACOPIO(1);
        acopio1.setIDarchivo(2);
        acopio1.setFecha("17/03/2023");
        acopio1.setTurno("M");
        acopio1.setProveedor("1003");
        acopio1.setKls_leche(50);

        AcopioEntity acopio2 = new AcopioEntity();
        acopio2.setIDACOPIO(2);
        acopio2.setIDarchivo(2);
        acopio2.setFecha("17/03/2023");
        acopio2.setTurno("T");
        acopio2.setProveedor("1003");
        acopio2.setKls_leche(50);

        AcopioEntity acopio3 = new AcopioEntity();
        acopio3.setIDACOPIO(3);
        acopio3.setIDarchivo(2);
        acopio3.setFecha("16/03/2023");
        acopio3.setTurno("M");
        acopio3.setProveedor("1000");
        acopio3.setKls_leche(50);

        AcopioEntity acopio4 = new AcopioEntity();
        acopio4.setIDACOPIO(4);
        acopio4.setIDarchivo(1);
        acopio4.setFecha("31/03/2023");
        acopio4.setTurno("M");
        acopio4.setProveedor("1000");
        acopio4.setKls_leche(50);

        AcopioEntity acopio5 = new AcopioEntity();
        acopio5.setIDACOPIO(5);
        acopio5.setIDarchivo(1);
        acopio5.setFecha("31/03/2023");
        acopio5.setTurno("M");
        acopio5.setProveedor("1003");
        acopio5.setKls_leche(25);

        acopioRepository.save(acopio1);
        acopioRepository.save(acopio2);
        acopioRepository.save(acopio3);
        acopioRepository.save(acopio4);
        acopioRepository.save(acopio5);

        //################################################################

        ArrayList<String> expected = new ArrayList<>();
        expected.add("75");
        expected.add("400");

        ArrayList<String> result = acopioService.obtenerVariacionLeche("1003");

        assertEquals(expected, result);

        ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
        acopioService.eliminarData(acopios);
    }

    @Test
    public void testObtenerAcopios(){
        //################################################################
        // Poblando db con datos dummies

        AcopioEntity aux1 = new AcopioEntity();
        aux1.setIDACOPIO(1);
        aux1.setIDarchivo(2);
        aux1.setFecha("17/03/2023");
        aux1.setTurno("M");
        aux1.setProveedor("1003");
        aux1.setKls_leche(50);

        AcopioEntity aux2 = new AcopioEntity();
        aux2.setIDACOPIO(2);
        aux2.setIDarchivo(2);
        aux2.setFecha("17/03/2023");
        aux2.setTurno("T");
        aux2.setProveedor("1003");
        aux2.setKls_leche(50);

        AcopioEntity aux3 = new AcopioEntity();
        aux3.setIDACOPIO(3);
        aux3.setIDarchivo(2);
        aux3.setFecha("16/03/2023");
        aux3.setTurno("M");
        aux3.setProveedor("1000");
        aux3.setKls_leche(50);

        AcopioEntity aux4 = new AcopioEntity();
        aux4.setIDACOPIO(4);
        aux4.setIDarchivo(1);
        aux4.setFecha("31/03/2023");
        aux4.setTurno("M");
        aux4.setProveedor("1000");
        aux4.setKls_leche(50);

        acopioRepository.save(aux1);
        acopioRepository.save(aux2);
        acopioRepository.save(aux3);
        acopioRepository.save(aux4);

        //################################################################

        ArrayList<AcopioEntity> expected = new ArrayList<>();

        AcopioEntity aux6 = new AcopioEntity();
        aux6.setIDACOPIO(6);
        aux6.setIDarchivo(2);
        aux6.setFecha("17/03/2023");
        aux6.setTurno("M");
        aux6.setProveedor("1003");
        aux6.setKls_leche(50);

        AcopioEntity aux7 = new AcopioEntity();
        aux7.setIDACOPIO(7);
        aux7.setIDarchivo(2);
        aux7.setFecha("17/03/2023");
        aux7.setTurno("T");
        aux7.setProveedor("1003");
        aux7.setKls_leche(50);

        AcopioEntity aux8 = new AcopioEntity();
        aux8.setIDACOPIO(8);
        aux8.setIDarchivo(2);
        aux8.setFecha("16/03/2023");
        aux8.setTurno("M");
        aux8.setProveedor("1000");
        aux8.setKls_leche(50);

        AcopioEntity aux9 = new AcopioEntity();
        aux9.setIDACOPIO(9);
        aux9.setIDarchivo(1);
        aux9.setFecha("31/03/2023");
        aux9.setTurno("M");
        aux9.setProveedor("1000");
        aux9.setKls_leche(50);

        expected.add(aux6);
        expected.add(aux7);
        expected.add(aux8);
        expected.add(aux9);

        ArrayList<AcopioEntity> resultado = acopioService.obtenerAcopios();

        assertEquals(expected, resultado);

        acopioService.eliminarData(resultado);
        acopioService.eliminarData(expected);
    }

}
