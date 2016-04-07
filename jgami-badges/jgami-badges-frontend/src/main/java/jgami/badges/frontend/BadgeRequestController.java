package jgami.badges.frontend;

import jgami.courses.backend.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BadgeRequestController {

    private BadgeService badgeService;

    @Autowired
    public BadgeRequestController(BadgeService badgeService) {
        this.badgeService= badgeService;
    }

    @InitBinder("requestBadgeForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new BadgeRequestFormValidator());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listBadgeRequests() {
        return new ModelAndView("badgeRequest")
                .addObject("badgeRequestForm", new BadgeRequestForm())
                .addObject("courses", badgeService.listCourses());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView requestBadge(
            @Validated BadgeRequestForm badgeRequestForm, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("badgeRequest")
                    .addObject("courses", badgeService.listCourses());
        }

        badgeService.requestBadge(new BadgeRequestFormConverter().convert(badgeRequestForm));
        redirectAttributes.addFlashAttribute("message", "Kérelmed elküldésre került");
        return new ModelAndView("redirect:/");
    }
}
