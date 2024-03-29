package com.fatemeh.app;

import com.fatemeh.app.entity.JukeboxEntity;
import com.fatemeh.app.entity.SettingEntity;
import com.fatemeh.app.model.Jukebox;
import com.fatemeh.app.repository.JukeboxRepo;
import com.fatemeh.app.repository.SettingRepo;
import com.fatemeh.app.service.JukeboxService;
import com.fatemeh.app.service.SettingService;
import com.fatemeh.app.util.JukeModelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableSwagger2

public class BackendAssignmentJukeboxApplication {


    @Autowired
    SettingRepo settingRepo;

    @Autowired
    JukeboxRepo jukeboxRepo;

    @Autowired
    JukeboxService jukeboxService;

    @Autowired
    SettingService settingService;

    @Autowired
    JukeModelBuilder jukeModelBuilder;

    public static void main(String[] args) {
        SpringApplication.run(BackendAssignmentJukeboxApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

            //save all Jukebox Entity to DB
            List<JukeboxEntity> jukeboxes = jukeboxService.readAllJukebox();
            jukeboxRepo.saveAll(jukeboxes);

            System.out.printf("Jukebox Table in DB contains %d items",jukeboxRepo.count());
            System.out.println();



            //save all settings to DB
            List<SettingEntity> settings = settingService.resdAllSettings();
            settingRepo.saveAll(settings);

            System.out.printf("Setting Table in DB contains %d items",settingRepo.count());



        };
    }

}



