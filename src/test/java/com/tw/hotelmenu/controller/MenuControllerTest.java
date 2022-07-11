package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.model.Menu;
import com.tw.hotelmenu.repository.MenuRepository;
import com.tw.hotelmenu.service.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matcher;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsMapWithSize.aMapWithSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest()
class MenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MenuService menuService;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void getAllMenu() throws Exception {
        List<Menu> menu = Arrays.asList(new Menu("dish1", 32), new Menu("dish2", 35));
        when(menuService.getAllMenu()).thenReturn(menu);

        String jsonContent = "[{\"name\": \"dish1\", \"price\" : 32}, {\"name\": \"dish2\", \"price\" : 35}]";
        mockMvc.perform(get("/menu/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(content().json(jsonContent));

    }



    @Test
    void createMenu() throws Exception {
        Menu menu = new Menu(5,"Chicken roti",250d);
        when(menuService.createMenu(menu)).thenReturn("Menu Created Successfully");

        mockMvc.perform(post("/menu/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menu)))
                .andExpect(status().isOk());
    }

    @Test
    void updateMenu() throws Exception {
        Menu menu = new Menu();
        menu.setId(1);
        menu.setName("Dish 1");
        menu.setPrice(20d);
        when(menuService.updateMenu(menu)).thenReturn("Menu Updated Successfully");

        mockMvc.perform(post("/menu/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menu)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteMenu() throws Exception {
        Menu menu = new Menu();
        menu.setId(2l);
        menu.setName("Dish 1");
        menu.setPrice(20d);
        when(menuService.deleteMenu(2l)).thenReturn("Deleted menu Successfully");


        mockMvc.perform(post("/menu/delete?id="+2l)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menu)))
                .andExpect(status().isOk());
    }
}