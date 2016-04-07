package jgami.badges.frontend;

import jgami.courses.backend.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ApproveController {

    private BadgeService badgeService;

    @Autowired
    public ApproveController(BadgeService badgeService) {
        this.badgeService= badgeService;
    }

    @RequestMapping(value = "/admin/approve", method = RequestMethod.GET)
    public ModelAndView listBadgeRequests() {
        return new ModelAndView("approve")
                .addObject("badgeRequests", badgeService.listBadgeRequests())
                .addObject("approveForm", new ApproveForm());
    }

    @RequestMapping(value = "/admin/approve", method = RequestMethod.POST)
    public ModelAndView requestBadge(
            @ModelAttribute ApproveForm approveForm,
            RedirectAttributes redirectAttributes) {

        badgeService.approveBadgeRequest(approveForm.getIds());
        redirectAttributes.addFlashAttribute("message", "Jóváhagyva");
        return new ModelAndView("redirect:/admin/approve");
    }
}
