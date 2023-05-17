package MilkStgo.Pep1.Services;

import MilkStgo.Pep1.Entities.AcopioEntity;
import MilkStgo.Pep1.Repositories.AcopioRepository;
import MilkStgo.Pep1.Entities.PorcentajeEntity;
import MilkStgo.Pep1.Repositories.PorcentajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service

public class SubirDataService {
    @Autowired
    private AcopioRepository dataAcopioRepository;

    @Autowired
    private PorcentajesRepository dataPorcentajesRepository;

    private final Logger logg = LoggerFactory.getLogger(SubirDataService.class);

    public ArrayList<AcopioEntity> obtenerDataAcopio() {
        return (ArrayList<AcopioEntity>) dataAcopioRepository.findAll();
    }

    public ArrayList<PorcentajeEntity> obtenerDataPorcentaje() {
        return (ArrayList<PorcentajeEntity>) dataPorcentajesRepository.findAll();
    }

    @Generated
    public String guardar(MultipartFile file) {
        String filename = file.getOriginalFilename();
        if (filename != null) {
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                } catch (IOException e) {
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito!";
        } else {
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsvAcopio(String direccion) {
        String texto = "";
        BufferedReader bf = null;
        //dataAcopioRepository.deleteAll();
        try {
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while ((bfRead = bf.readLine()) != null) {
                if (count == 1) {
                    count = 0;
                } else {
                    guardarDataDBAcopio(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        } catch (Exception e) {
            System.err.println("No se encontro el archivo");
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public void guardarDataAcopio(AcopioEntity data) {
        dataAcopioRepository.save(data);
    }

    public void guardarDataDBAcopio(String fecha, String turno, String proveedor, String kls_leche) {
        AcopioEntity newData = new AcopioEntity();
        newData.setFecha(fecha);
        newData.setTurno(turno);
        newData.setProveedor(proveedor);
        newData.setKls_leche(kls_leche);
        guardarDataAcopio(newData);
    }

    public void eliminarDataAcopio(ArrayList<AcopioEntity> datas) {
        dataAcopioRepository.deleteAll(datas);
    }

    //##########################################################################################

    @Generated
    public void leerCsvPorcentaje(String direccion) {
        String texto = "";
        BufferedReader bf = null;
        //dataAcopioRepository.deleteAll();
        try {
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while ((bfRead = bf.readLine()) != null) {
                if (count == 1) {
                    count = 0;
                } else {
                    guardarDataDBPorcentaje(bfRead.split(";")[0], Integer.parseInt(bfRead.split(";")[1]), Integer.parseInt(bfRead.split(";")[2]));
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        } catch (Exception e) {
            System.err.println("No se encontro el archivo");
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public void guardarDataPorcentaje(PorcentajeEntity data) {
        dataPorcentajesRepository.save(data);
    }

    public void guardarDataDBPorcentaje(String cod_proveedor, int grasa, int solido) {
        PorcentajeEntity newData = new PorcentajeEntity();
        newData.setCod_proveedor(cod_proveedor);
        newData.setGrasa(grasa);
        newData.setSolido(solido);
        guardarDataPorcentaje(newData);
    }

    public void eliminarDataPorcentaje(ArrayList<PorcentajeEntity> datas) {
        dataPorcentajesRepository.deleteAll(datas);
    }
}



