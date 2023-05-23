package MilkStgo.Pep1;

import MilkStgo.Pep1.Entities.AcopioEntity;
import MilkStgo.Pep1.Entities.PorcentajeEntity;
import MilkStgo.Pep1.Services.PorcentajeService;
import MilkStgo.Pep1.Repositories.PorcentajeRepository;
import MilkStgo.Pep1.Services.AcopioService;
import MilkStgo.Pep1.Repositories.AcopioRepository;
import MilkStgo.Pep1.Services.SubirDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SubirDataServiceTests {
    @Autowired
    private PorcentajeService porcentajeService;

    @Autowired
    private PorcentajeRepository porcentajeRepository;



    @Autowired
    private AcopioService acopioService;



    @Autowired
    private SubirDataService subirDataService;





}

