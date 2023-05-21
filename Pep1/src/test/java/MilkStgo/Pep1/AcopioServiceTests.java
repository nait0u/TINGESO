package MilkStgo.Pep1;

import MilkStgo.Pep1.Repositories.AcopioRepository;
import MilkStgo.Pep1.Services.AcopioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AcopioServiceTests {
    @Autowired
    private AcopioService acopioService;

    @Autowired
    private AcopioRepository acopioRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testKlsLeche(){

    }


}
