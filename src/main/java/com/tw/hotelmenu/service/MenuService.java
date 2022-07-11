package com.tw.hotelmenu.service;

import com.tw.hotelmenu.model.Menu;
import com.tw.hotelmenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;
    //Show available menu
    public List<Menu> getAllMenu(){
        return (List<Menu>) menuRepository.findAll();
    }

    public Menu getMenuById(long id){
        return menuRepository.findById(id).get();
    }
   /* public Menu Menu(Long userId) {
        return menuRepository.findById(userId).get();
    }*/

    public String createMenu(Menu menu){
        menuRepository.save(menu);
        return "Menu Created Successfully";
    }

    // Update menu
    public String updateMenu(Menu menu){
        Menu menuToUpdate = menuRepository.findById(menu.getId()).get();
        menuToUpdate.setName(menu.getName());
        menuToUpdate.setPrice(menu.getPrice());
        menuRepository.save(menuToUpdate);
        String s = "Menu Updated Successfully";
        return s;
    }

    // Delete menu
    public String deleteMenu(long id){
        Menu menuTodelete = menuRepository.findById(id).get();
        menuRepository.delete(menuTodelete);
        return "Deleted menu Successfully";
    }
}
