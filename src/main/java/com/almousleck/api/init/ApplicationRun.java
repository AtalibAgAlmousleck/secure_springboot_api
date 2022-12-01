package com.almousleck.apiapplication.init;

import com.almousleck.apiapplication.model.Role;
import com.almousleck.apiapplication.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationRun implements CommandLineRunner {
    private final RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(1L, "199", "ROLE_USER");
        Role roleAdmin = new Role(2L, "120", "ROLE_ADMIN");
         //Save
        //roleRepository.saveAll(List.of(roleUser, roleAdmin));
    }
}
