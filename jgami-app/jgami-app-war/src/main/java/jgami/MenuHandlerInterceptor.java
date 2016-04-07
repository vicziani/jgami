package jgami;

import jgami.core.MenuItem;
import jgami.core.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class MenuHandlerInterceptor extends HandlerInterceptorAdapter {

    private List<Module> modules;

    @Autowired
    public MenuHandlerInterceptor(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            List<MenuItem> menuItems = new ArrayList<>();
            modules.forEach(m -> {
                menuItems.addAll(m.getMenuItems());
            });
            modelAndView.addObject("menuItems", menuItems);
        }
        super.postHandle(request, response, handler, modelAndView);
    }
}
