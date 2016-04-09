package jgami.badges.frontend;

import jgami.courses.backend.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BadgesController {

    private BadgeService badgeService;

    @Autowired
    public BadgesController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @RequestMapping("/admin/badges")
    public ModelAndView badges() {
        return new ModelAndView("badges")
                .addObject("badges", badgeService.listBadges());
    }
}
