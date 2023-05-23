package MilkStgo.Pep1;

import MilkStgo.Pep1.Entities.ProveedorEntity;
import MilkStgo.Pep1.Repositories.ProveedorRepository;
import MilkStgo.Pep1.Services.ProveedorService;
import org.hibernate.dialect.MariaDB10Dialect;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

@SpringBootTest

public class ProveedorServiceTests {
    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @BeforeEach
    public void contextLoads() {
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setIDPROVEEDOR(5);
        proveedor.setCodigo("1003");
        proveedor.setNombre("Juan");
        proveedor.setCategoria("A");
        proveedor.setRetencion(true);

        ProveedorEntity proveedor2 = new ProveedorEntity();
        proveedor2.setIDPROVEEDOR(6);
        proveedor2.setCodigo("1000");
        proveedor2.setNombre("Pedro");
        proveedor2.setCategoria("B");
        proveedor2.setRetencion(false);

        proveedorRepository.save(proveedor);
        proveedorRepository.save(proveedor2);
    }

    @Test
    public void testObtenerProveedores(){
        ArrayList<ProveedorEntity> expected = new ArrayList<>();

        ProveedorEntity aux1 = new ProveedorEntity();
        aux1.setIDPROVEEDOR(4);
        aux1.setCodigo("1003");
        aux1.setNombre("Juan");
        aux1.setCategoria("A");
        aux1.setRetencion(true);

        ProveedorEntity aux2 = new ProveedorEntity();
        aux2.setIDPROVEEDOR(5);
        aux2.setCodigo("1000");
        aux2.setNombre("Pedro");
        aux2.setCategoria("B");
        aux2.setRetencion(false);

        expected.add(aux1);
        expected.add(aux2);

        ArrayList<ProveedorEntity> result = proveedorService.obtenerProveedores();

        assertEquals(expected, result);

    }

    @Test
    public void testObtenerCategoria(){
        String resultado = proveedorService.obtenerCategoria("1000");

        assertEquals("B", resultado);

        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        proveedorService.eliminarData(proveedores);
    }

    @Test
    public void testFindByCodigo(){
        ProveedorEntity expected = new ProveedorEntity();
        expected.setIDPROVEEDOR(2);
        expected.setCodigo("1003");
        expected.setNombre("Juan");
        expected.setCategoria("A");
        expected.setRetencion(true);

        ProveedorEntity result = proveedorService.findByCodigo("1003");

        assertEquals(expected, result);

        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        proveedorService.eliminarData(proveedores);
    }


    @AfterEach
    public void eliminarData(){
        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        proveedorService.eliminarData(proveedores);
    }
}
