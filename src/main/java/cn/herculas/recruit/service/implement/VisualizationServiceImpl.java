package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DTO.StudentContactStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentDivisionStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentGradeStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentRegionStatisticsDTO;
import cn.herculas.recruit.repository.StudentDetailRepository;
import cn.herculas.recruit.service.VisualizationService;
import cn.herculas.recruit.util.penetrator.DatabasePenetrator;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizationServiceImpl implements VisualizationService {

    @Value("${statistics.expires}")
    private Integer expires;
    @Value("${statistics.region-key}")
    private String regionKey;
    @Value("${statistics.division-key}")
    private String divisionKey;
    @Value("${statistics.contact-key}")
    private String contactKey;
    @Value("${statistics.grade-key}")
    private String gradeKey;

    private final StudentDetailRepository studentDetailRepository;
    private final StringRedisTemplate stringRedisTemplate;

    public VisualizationServiceImpl(StudentDetailRepository studentDetailRepository,
                                    StringRedisTemplate stringRedisTemplate) {

        this.studentDetailRepository = studentDetailRepository;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public List<StudentRegionStatisticsDTO> countRegionStatistics() {
        String list = stringRedisTemplate.opsForValue().get(regionKey);
        if (list == null) {
            return DatabasePenetrator
                    .statisticsPenetrator(
                            studentDetailRepository::groupByStudentRegion,
                            stringRedisTemplate,
                            regionKey,
                            expires);
        } else {
            return JSONObject.parseArray(list, StudentRegionStatisticsDTO.class);
        }
    }

    @Override
    public List<StudentDivisionStatisticsDTO> countDivisionStatistics() {
        String list = stringRedisTemplate.opsForValue().get(divisionKey);
        if (list == null) {
            return DatabasePenetrator
                    .statisticsPenetrator(
                            studentDetailRepository::groupByStudentDivision,
                            stringRedisTemplate,
                            divisionKey,
                            expires);
        } else {
            return JSONObject.parseArray(list, StudentDivisionStatisticsDTO.class);
        }
    }

    @Override
    public List<StudentContactStatisticsDTO> countContactStatistics() {
        String list = stringRedisTemplate.opsForValue().get(contactKey);
        if (list == null) {
            return DatabasePenetrator
                    .statisticsPenetrator(
                            studentDetailRepository::groupByStudentContactStatus,
                            stringRedisTemplate,
                            contactKey,
                            expires);
        } else {
            return JSONObject.parseArray(list, StudentContactStatisticsDTO.class);
        }
    }

    @Override
    public List<StudentGradeStatisticsDTO> countGradeStatistics() {
        String list = stringRedisTemplate.opsForValue().get(gradeKey);
        if (list == null) {
            return DatabasePenetrator
                    .statisticsPenetrator(
                            studentDetailRepository::groupByStudentGrade,
                            stringRedisTemplate,
                            gradeKey,
                            expires);
        } else {
            return JSONObject.parseArray(list, StudentGradeStatisticsDTO.class);
        }
    }
}
