package ru.lantsev.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lantsev.model.dao.menu.MenuDao;
import ru.lantsev.model.entry.Menu;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    private MenuDao menuDao ;

    @Autowired
    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Override
    public List<Menu> allMenu() {
        return menuDao.allMenu();
    }

    @Override
    public List<Menu> allMenuWithRecipe() {
        return menuDao.allMenuWithRecipe();
    }

    @Override
    public Menu save(Menu menu) {
        return menuDao.save(menu);
    }

    @Override
    public void delete(Menu menu) {
        menuDao.delete(menu);
    }

    @Override
    public Menu getById(long id) {
        return menuDao.getById(id);
    }
}
