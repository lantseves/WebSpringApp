package ru.lantsev.service.menu;

import ru.lantsev.model.entry.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> allMenu();
    List<Menu> allMenuWithRecipe() ;
    Menu save(Menu menu);
    void delete(Menu menu);
    Menu getById(long id);
}
