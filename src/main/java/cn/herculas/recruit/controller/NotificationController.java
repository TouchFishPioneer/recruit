package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.Notification;
import cn.herculas.recruit.data.VO.NotificationVO;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.NotificationForm;
import cn.herculas.recruit.service.NotificationService;
import cn.herculas.recruit.util.parser.NotificationParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/interactive/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/index")
    public ResultVO listNotification(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "20") Integer size) {

        // TODO: Permission check

        Page<Notification> notificationPage = notificationService.listNotification(PageRequest.of(page, size));
        List<NotificationVO> notificationVOList = new ArrayList<>();
        for (Notification notification : notificationPage) {
            notificationVOList.add(NotificationParser.viewParser(notification));
        }
        return ResultVO.success(notificationVOList);
    }

    @PostMapping("/index")
    public ResultVO createNotification(@Valid NotificationForm notificationForm, BindingResult bindingResult) {

        // TODO: Permission check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        Notification notification = NotificationParser.formParser(notificationForm);

        try {
            Notification result = notificationService.createNotification(notification);
            return ResultVO.success(NotificationParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }
}
