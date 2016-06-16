package de.hsb.hci.wth.web.config.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ApplicationScoped
public class ThemeSwitcher {

    @Autowired
    private ThemeService service;

    private List<Theme> themes;
    private Theme currentTheme;

    @PostConstruct
    public void init() {
        themes = service.getThemes();
        currentTheme = themes.stream().filter(theme -> "bootstrap".equals(theme.getName())).findFirst().get();
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public Theme getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(Theme currentTheme) {
        this.currentTheme = currentTheme;
    }
}
