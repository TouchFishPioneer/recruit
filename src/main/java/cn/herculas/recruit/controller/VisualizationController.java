package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.service.VisualizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visualization")
public class VisualizationController {

    private final VisualizationService visualizationService;

    public VisualizationController(VisualizationService visualizationService) {
        this.visualizationService = visualizationService;
    }

    @GetMapping("/region/index")
    public ResultVO getRegionStatistics() {
        return ResultVO.success(visualizationService.countRegionStatistics());
    }

    @GetMapping("/division/index")
    public ResultVO getDivisionStatistics() {
        return ResultVO.success(visualizationService.countDivisionStatistics());
    }

    @GetMapping("/contact/index")
    public ResultVO getContactStatistics() {
        return ResultVO.success(visualizationService.countContactStatistics());
    }

    @GetMapping("/grade/index")
    public ResultVO getGradeStatistics() {
        return ResultVO.success(visualizationService.countGradeStatistics());
    }
}
