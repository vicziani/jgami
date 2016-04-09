package jgami.badges.restapi;

import jgami.courses.backend.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private BadgeService badgeService;

    @Value("${badges.host}")
    private String host;

    @Autowired
    public ApiController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @RequestMapping("/assertions/{id}")
    public Assertion assertion(@PathVariable String id) {
        return new AssertionConverter(host).convert(badgeService.getBadgeById(id));
    }
}
