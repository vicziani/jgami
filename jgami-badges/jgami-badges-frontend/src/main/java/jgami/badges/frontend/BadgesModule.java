package jgami.badges.frontend;

import jgami.core.MenuItem;
import jgami.core.Module;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BadgesModule implements Module {

    @Override
    public String getName() {
        return "Badges";
    }

    @Override
    public List<MenuItem> getMenuItems() {
        return Arrays.asList(new MenuItem("Jóváhagyás", "/admin/approve"));
    }
}
