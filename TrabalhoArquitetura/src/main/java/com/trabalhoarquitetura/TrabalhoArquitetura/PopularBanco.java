package com.trabalhoarquitetura.TrabalhoArquitetura;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.RoleEnum;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.UserEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.service.UserService;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.EspacoFisicoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.RecursoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.repository.EspacoFisicoRepository;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.repository.RecursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PopularBanco implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private EspacoFisicoRepository espacoFisicoRepository;
    @Autowired
    private RecursoRepository recursoRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity = userService.findByUsername("Sandro");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Sandro silva");
            userEntity.setUsername("Sandro");
            userEntity.setPassword("Sandro123");
            userEntity.setRole(RoleEnum.ADMIN.name());
            userService.save(userEntity);

        }
        userEntity = userService.findByUsername("amanda");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Amanda Costa");
            userEntity.setUsername("amanda");
            userEntity.setPassword("Amanda123");
            userEntity.setRole(RoleEnum.ADMIN.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("bernardo");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Bernardo Souza");
            userEntity.setUsername("bernardo");
            userEntity.setPassword("Bernardo123");
            userEntity.setRole(RoleEnum.ADMIN.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("carla");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Carla Lima");
            userEntity.setUsername("carla");
            userEntity.setPassword("Carla123");
            userEntity.setRole(RoleEnum.ADMIN.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("daniel");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Daniel Rocha");
            userEntity.setUsername("daniel");
            userEntity.setPassword("Daniel123");
            userEntity.setRole(RoleEnum.ADMIN.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("eliane");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Eliane Martins");
            userEntity.setUsername("eliane");
            userEntity.setPassword("Eliane123");
            userEntity.setRole(RoleEnum.ADMIN.name());
            userService.save(userEntity);
        }
// PROFESSOR users
        userEntity = userService.findByUsername("fabio");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Fabio Nogueira");
            userEntity.setUsername("fabio");
            userEntity.setPassword("Fabio123");
            userEntity.setRole(RoleEnum.PROFESSOR.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("gabriela");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Gabriela Pinto");
            userEntity.setUsername("gabriela");
            userEntity.setPassword("Gabriela123");
            userEntity.setRole(RoleEnum.PROFESSOR.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("henrique");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Henrique Ferreira");
            userEntity.setUsername("henrique");
            userEntity.setPassword("Henrique123");
            userEntity.setRole(RoleEnum.PROFESSOR.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("ingrid");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Ingrid Silva");
            userEntity.setUsername("ingrid");
            userEntity.setPassword("Ingrid123");
            userEntity.setRole(RoleEnum.PROFESSOR.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("joana");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Joana Teixeira");
            userEntity.setUsername("joana");
            userEntity.setPassword("Joana123");
            userEntity.setRole(RoleEnum.PROFESSOR.name());
            userService.save(userEntity);
        }
// GESTOR users
        userEntity = userService.findByUsername("lucas");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Lucas Almeida");
            userEntity.setUsername("lucas");
            userEntity.setPassword("Lucas123");
            userEntity.setRole(RoleEnum.GESTOR.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("maria");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Maria Carvalho");
            userEntity.setUsername("maria");
            userEntity.setPassword("Maria123");
            userEntity.setRole(RoleEnum.GESTOR.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("nelson");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Nelson Barreto");
            userEntity.setUsername("nelson");
            userEntity.setPassword("Nelson123");
            userEntity.setRole(RoleEnum.GESTOR.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("otavio");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Otavio Lima");
            userEntity.setUsername("otavio");
            userEntity.setPassword("Otavio123");
            userEntity.setRole(RoleEnum.GESTOR.name());
            userService.save(userEntity);
        }

        userEntity = userService.findByUsername("paula");
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNome("Paula Santana");
            userEntity.setUsername("paula");
            userEntity.setPassword("Paula123");
            userEntity.setRole(RoleEnum.GESTOR.name());
            userService.save(userEntity);
        }

        EspacoFisicoEntity espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 1");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 1");
            espacoFisicoEntity.setCapacidade("10");
            espacoFisicoEntity.setLocalizacao("Bloco A");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }
        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 2");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 2");
            espacoFisicoEntity.setCapacidade("10");
            espacoFisicoEntity.setLocalizacao("Bloco A");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }
        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 1");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 1");
            espacoFisicoEntity.setCapacidade("20");
            espacoFisicoEntity.setLocalizacao("Bloco A");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 2");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 2");
            espacoFisicoEntity.setCapacidade("10");
            espacoFisicoEntity.setLocalizacao("Bloco A");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 3");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 3");
            espacoFisicoEntity.setCapacidade("30");
            espacoFisicoEntity.setLocalizacao("Bloco B");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 4");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 4");
            espacoFisicoEntity.setCapacidade("15");
            espacoFisicoEntity.setLocalizacao("Bloco B");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 5");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 5");
            espacoFisicoEntity.setCapacidade("50");
            espacoFisicoEntity.setLocalizacao("Bloco B");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 6");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 6");
            espacoFisicoEntity.setCapacidade("40");
            espacoFisicoEntity.setLocalizacao("Bloco B");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 7");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 7");
            espacoFisicoEntity.setCapacidade("35");
            espacoFisicoEntity.setLocalizacao("Bloco B");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 8");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 8");
            espacoFisicoEntity.setCapacidade("25");
            espacoFisicoEntity.setLocalizacao("Bloco B");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 9");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 9");
            espacoFisicoEntity.setCapacidade("60");
            espacoFisicoEntity.setLocalizacao("Bloco B");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 10");
        if (espacoFisicoEntity == null) {
            espacoFisicoEntity = new EspacoFisicoEntity();
            espacoFisicoEntity.setNome("Sala 10");
            espacoFisicoEntity.setCapacidade("45");
            espacoFisicoEntity.setLocalizacao("Bloco C");
            espacoFisicoRepository.save(espacoFisicoEntity);
        }

        RecursoEntity recursoEntity;
        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 1");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }

            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Computador");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("TV");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 2");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Caixa de som", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Caixa de som");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Quadro");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }
        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 3");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Computador");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 4");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Computador");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }
        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 5");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Caixa de som");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }
        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 6");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Computador");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("TV");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }
        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 7");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Caixa de som");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 8");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Computador");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }
        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 9");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Computador");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }

        espacoFisicoEntity = espacoFisicoRepository.findByNome("Sala 10");
        if (espacoFisicoEntity != null && espacoFisicoEntity.getRecursos() != null) {
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Projetor", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Projetor");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
            if (!espacoFisicoEntity.getRecursos().contains(recursoRepository.findByNome("Computador", espacoFisicoEntity))) {
                recursoEntity = new RecursoEntity();
                recursoEntity.setNome("Caixa de som");
                recursoEntity.setEspacoFisicoEntity(espacoFisicoEntity);
                recursoRepository.save(recursoEntity);
            }
        }
    }
}
