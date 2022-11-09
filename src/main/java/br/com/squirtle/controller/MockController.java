package br.com.squirtle.controller;

import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.model.Usuario;
import br.com.squirtle.model.UsuarioDispositivo;
import br.com.squirtle.repository.DispositivoRepository;
import br.com.squirtle.repository.LinkRepository;
import br.com.squirtle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/api/v1/mock", produces = MediaType.APPLICATION_JSON_VALUE)
public class MockController {
    @Autowired
    public UsuarioRepository usuarioRepository;
    @Autowired
    public DispositivoRepository dispositivoRepository;
    @Autowired
    public LinkRepository linkRepository;

    @GetMapping("")
    public String mock(){
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Usuario");
        usuario1.setSobrenome("1");
        usuario1.setEmail("usuario1@usuario.com");
        usuario1.setSenha("$2a$12$pz72U85468cEmExuIZ4R6OgdMy.rVDznoi0cQKD7iVlG2MZa1hugO");
        usuario1.setDispositivos(new ArrayList<>());

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Usuario");
        usuario2.setSobrenome("2");
        usuario2.setEmail("usuario2@usuario.com");
        usuario2.setSenha("$2a$12$pz72U85468cEmExuIZ4R6OgdMy.rVDznoi0cQKD7iVlG2MZa1hugO");
        usuario2.setDispositivos(new ArrayList<>());

        Usuario teste = new Usuario();
        teste.setNome("Teste");
        teste.setSobrenome("Teste");
        teste.setEmail("teste@teste.com");
        teste.setSenha("$2a$12$lislWxX03MIzG8rsAojFU.j8Rl7xcuc5oJlAc7CjcWldGxGg2hEYS");
        teste.setDispositivos(new ArrayList<>());

        Usuario user1 = usuarioRepository.save(usuario1);
        Usuario user2 = usuarioRepository.save(usuario2);
        Usuario user3 = usuarioRepository.save(teste);


        // Dispositivo Mock
        Dispositivo dispositivo1 = new Dispositivo();
        dispositivo1.setNome("Arduino A");
        dispositivo1.setDescricao("Plantação de Acerola");
        dispositivo1.setIcone("plant");
        dispositivo1.setStatus(true);
        dispositivo1.setTempo_bomba("null");
        dispositivo1.setTipo_solo("Arenoso");
        dispositivo1.setWifi_ssid("wifi_ssid_teste");
        dispositivo1.setWifi_pass("wifi_pass_teste");
        dispositivo1.setSensor1("mp:0,pp:0,pt:0,value:0");
        dispositivo1.setSensor2("mp:0,pp:0,pt:0,value:0");
        dispositivo1.setSensor3("mp:0,pp:0,pt:0,value:0");
        dispositivo1.setSensor4("mp:0,pp:0,pt:0,value:0");
        dispositivo1.setSensor5("mp:0,pp:0,pt:0,value:0");

        Dispositivo dispositivo2 = new Dispositivo();
        dispositivo2.setNome("Arduino B");
        dispositivo2.setDescricao("Plantação de Goiaba");
        dispositivo2.setIcone("sun");
        dispositivo2.setStatus(true);
        dispositivo2.setTempo_bomba("null");
        dispositivo2.setTipo_solo("Arenoso");
        dispositivo2.setWifi_ssid("wifi_ssid_teste");
        dispositivo2.setWifi_pass("wifi_pass_teste");
        dispositivo2.setSensor1("mp:0,pp:0,pt:0,value:0");
        dispositivo2.setSensor2("mp:0,pp:0,pt:0,value:0");
        dispositivo2.setSensor3("mp:0,pp:0,pt:0,value:0");
        dispositivo2.setSensor4("mp:0,pp:0,pt:0,value:0");
        dispositivo2.setSensor5("mp:0,pp:0,pt:0,value:0");

        Dispositivo dispositivo3 = new Dispositivo();
        dispositivo3.setNome("Plantação Cachoeira");
        dispositivo3.setDescricao("Plantação de Algo");
        dispositivo3.setIcone("cloud");
        dispositivo3.setStatus(true);
        dispositivo3.setTempo_bomba("null");
        dispositivo3.setTipo_solo("Arenoso");
        dispositivo3.setWifi_ssid("wifi_ssid_teste");
        dispositivo3.setWifi_pass("wifi_pass_teste");
        dispositivo3.setSensor1("mp:0,pp:0,pt:0,value:0");
        dispositivo3.setSensor2("mp:0,pp:0,pt:0,value:0");
        dispositivo3.setSensor3("mp:0,pp:0,pt:0,value:0");
        dispositivo3.setSensor4("mp:0,pp:0,pt:0,value:0");
        dispositivo3.setSensor5("mp:0,pp:0,pt:0,value:0");

        Dispositivo dispositivo4 = new Dispositivo();
        dispositivo4.setNome("Esp da Lua");
        dispositivo4.setDescricao("Plantação de Mandioca");
        dispositivo4.setIcone("moon");
        dispositivo4.setStatus(true);
        dispositivo4.setTempo_bomba("null");
        dispositivo4.setTipo_solo("Arenoso");
        dispositivo4.setWifi_ssid("wifi_ssid_teste");
        dispositivo4.setWifi_pass("wifi_pass_teste");
        dispositivo4.setSensor1("mp:0,pp:0,pt:0,value:0");
        dispositivo4.setSensor2("mp:0,pp:0,pt:0,value:0");
        dispositivo4.setSensor3("mp:0,pp:0,pt:0,value:0");
        dispositivo4.setSensor4("mp:0,pp:0,pt:0,value:0");
        dispositivo4.setSensor5("mp:0,pp:0,pt:0,value:0");

        Dispositivo device1 = dispositivoRepository.save(dispositivo1);
        Dispositivo device2 = dispositivoRepository.save(dispositivo2);
        Dispositivo device3 = dispositivoRepository.save(dispositivo3);
        Dispositivo device4 = dispositivoRepository.save(dispositivo4);

        UsuarioDispositivo ud1 = new UsuarioDispositivo();
        ud1.setUsuario_id(user1.getId());
        ud1.setDispositivo_id(device1.getId());

        UsuarioDispositivo ud2 = new UsuarioDispositivo();
        ud2.setUsuario_id(user2.getId());
        ud2.setDispositivo_id(device1.getId());

        UsuarioDispositivo ud3 = new UsuarioDispositivo();
        ud3.setUsuario_id(user3.getId());
        ud3.setDispositivo_id(device2.getId());
        UsuarioDispositivo ud4 = new UsuarioDispositivo();
        ud4.setUsuario_id(user3.getId());
        ud4.setDispositivo_id(device3.getId());
        UsuarioDispositivo ud5 = new UsuarioDispositivo();
        ud5.setUsuario_id(user3.getId());
        ud5.setDispositivo_id(device4.getId());


        linkRepository.save(ud1);
        linkRepository.save(ud2);
        linkRepository.save(ud3);
        linkRepository.save(ud4);
        linkRepository.save(ud5);

        return "Mock realizado com sucesso!";
    }
}
