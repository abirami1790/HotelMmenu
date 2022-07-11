package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.model.Menu;
import com.tw.hotelmenu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    //Show available menu
    @GetMapping("/all")
    public List<Menu> getAllMenu(){
        return menuService.getAllMenu();
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Long id){
      return menuService.getMenuById(id);
    }

    @PostMapping("/create")
    public String createMenu(@RequestBody Menu menu){
        menuService.createMenu(menu);
        return "Created menu Successfully";
    }

    // Update menu
    @PostMapping("/update")
    public String updateMenu(@RequestBody Menu menu){
        menuService.updateMenu(menu);
        return "Updated menu Successfully";
    }

  /*  // Delete menu
    @PostMapping ("/delete")
    public String deleteMenu(@RequestBody Menu menu){
        menuService.deleteMenu(menu);
        return "Deleted menu Successfully";
    }*/
    // Delete menu
    @PostMapping ("/delete")
    public String deleteMenu(@RequestParam long id){
        menuService.deleteMenu(id);
        return "Deleted menu Successfully";
    }
}
