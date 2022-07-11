package com.tw.hotelmenu.service;

import com.tw.hotelmenu.model.Menu;
import com.tw.hotelmenu.repository.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class MenuServiceTest {

    @Autowired
    MenuService menuService;

    @MockBean
    MenuRepository menuRepository;


    @Test
    void getAllMenu() {
        Menu menu = new Menu("Mutton biryani",140d);
        Menu menu2 = new Menu("carb lollipop",490d);

        List<Menu> menuList = new ArrayList<>(Arrays.asList(menu,menu2));
        when(menuRepository.findAll()).thenReturn(menuList);

        List<Menu> resultList = menuService.getAllMenu();
        Assertions.assertEquals(menuList,resultList);
    }

    @Test
    void createMenu() {
        Menu menu = new Menu("Mutton varuval",240d);
        String result = menuService.createMenu(menu);
        Assertions.assertEquals("Menu Created Successfully",result);

    }

    @Test
    void updateMenu() {

        Menu menu = new Menu(1,"Mutton biryani",140d);
        when(menuRepository.findById(1l)).thenReturn(Optional.of(menu));

        Menu menuToUpdate = new Menu();
        menuToUpdate.setId(1);
        menuToUpdate.setName("Mutton biryani");
        menuToUpdate.setPrice(300d);
        String result = menuService.updateMenu(menu);
        Assertions.assertEquals("Menu Updated Successfully",result);
    }

    @Test
    void deleteMenu() {

        Menu menu = new Menu(1,"Mutton biryani",140d);
        when(menuRepository.findById(1l)).thenReturn(Optional.of(menu));

      /*  Menu menuToUpdate = new Menu();
        menuToUpdate.setId(1);
        menuToUpdate.setName("Mutton biryani");
        menuToUpdate.setPrice(20d);*/
        String result = menuService.deleteMenu(1l);
        Assertions.assertEquals("Deleted menu Successfully",result);
    }
}