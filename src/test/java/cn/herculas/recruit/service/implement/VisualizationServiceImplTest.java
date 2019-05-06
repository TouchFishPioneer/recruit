package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.service.VisualizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisualizationServiceImplTest {

    @Autowired
    private VisualizationService visualizationService;

    @Test
    public void countRegionStatistics() {
        System.out.println(visualizationService.countRegionStatistics());
    }

    @Test
    public void countDivisionStatistics() {
        System.out.println(visualizationService.countDivisionStatistics());
    }

    @Test
    public void countContactStatistics() {
        System.out.println(visualizationService.countContactStatistics());
    }

    @Test
    public void countGradeStatistics() {
        System.out.println(visualizationService.countGradeStatistics());
    }
}