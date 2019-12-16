package ru.lantsev.model.dao.menu;

import ru.lantsev.model.entry.Menu;
import ru.lantsev.model.entry.Order;

import java.util.List;

public interface MenuDao {
    List<Menu> allMenu();
    List<Menu> allMenuWithRecipe() ;
    Menu save(Menu menu);
    void delete(Menu menu);
    Menu getById(long id);
}
