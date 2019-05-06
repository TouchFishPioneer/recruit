package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DTO.StudentContactStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentDivisionStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentGradeStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentRegionStatisticsDTO;

import java.util.List;

public interface VisualizationService {
    List<StudentRegionStatisticsDTO> countRegionStatistics();
    List<StudentDivisionStatisticsDTO> countDivisionStatistics();
    List<StudentContactStatisticsDTO> countContactStatistics();
    List<StudentGradeStatisticsDTO> countGradeStatistics();
}
