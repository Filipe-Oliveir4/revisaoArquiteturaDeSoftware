package com.trabalhoarquitetura.TrabalhoArquitetura.seguranca;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebConfigure {

    @Autowired
    private SecurityDatabaseService securityDatabaseService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityDatabaseService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        //Usuário
                        .requestMatchers(HttpMethod.POST,"/api/cadastrarUsuario").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.GESTOR.name())
                        //Solicitações
                        .requestMatchers(HttpMethod.GET,"/api/solicitacoes/listarSolicitacoes").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.GESTOR.name(),RoleEnum.PROFESSOR.name())
                        .requestMatchers(HttpMethod.POST,"/api/solicitacoes/cadastrarSolicitacao").hasAnyRole(RoleEnum.PROFESSOR.name())
                        .requestMatchers(HttpMethod.POST,"/api/solicitacoes/cancelarSolicitacao").hasAnyRole(RoleEnum.PROFESSOR.name())
                        .requestMatchers(HttpMethod.POST,"/api/solicitacoes/editarSolicitacao").hasRole(RoleEnum.PROFESSOR.name())
                        .requestMatchers(HttpMethod.POST,"/api/solicitacoes/resolverSolicitacao").hasRole(RoleEnum.GESTOR.name())
                        .requestMatchers(HttpMethod.GET,"/api/solicitacoes/solicitacoesAprovadas").hasRole(RoleEnum.GESTOR.name())
                        .requestMatchers(HttpMethod.GET,"/api/solicitacoes/solicitacoesPendentes").hasRole(RoleEnum.GESTOR.name())
                        .requestMatchers(HttpMethod.GET,"/api/solicitacoes/solicitacoesRejeitadas").hasRole(RoleEnum.GESTOR.name())
                        //Gestão de espaco
                        .requestMatchers(HttpMethod.POST,"/api/gestaoespaco/cadastrarEspaco").hasRole(RoleEnum.ADMIN.name())
                        .requestMatchers(HttpMethod.POST,"/api/gestaoespaco/editarEspaco").hasRole(RoleEnum.ADMIN.name())
                        .requestMatchers(HttpMethod.POST,"/api/gestaoespaco/cadastrarRecurso").hasRole(RoleEnum.ADMIN.name())
                        .anyRequest().permitAll()
                ).httpBasic(withDefaults()).formLogin(withDefaults()).csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
