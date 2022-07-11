package com.tw.hotelmenu.repository;

import com.tw.hotelmenu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
