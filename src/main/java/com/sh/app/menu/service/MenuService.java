package com.sh.app.menu.service;


import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {
    private final MenuRepository menuRepository;

    public ResponseEntity<?> findById(Long menuCode) {
        Menu menu = menuRepository.findById(menuCode).orElse(null);
        if(menu == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(menu);
    }
}
