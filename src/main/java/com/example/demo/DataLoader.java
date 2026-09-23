package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Espacio;
import com.example.demo.entities.Reserva;
import com.example.demo.entities.Servicio;
import com.example.demo.entities.Usuario;
import com.example.demo.repository.EspacioRespository;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.ServicioRepository;
import com.example.demo.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Component //crear objeto tipo dataLoader
@Transactional //para que todos los queries que llegan a salir bien hace commit si no rollback
public class DataLoader implements CommandLineRunner{

    @Autowired 
    private UsuarioRepository usuarioRepository;
    @Autowired 
    private ReservaRepository reservaRepository;
    @Autowired 
    private ServicioRepository servicioRepository;
    @Autowired 
    private EspacioRespository espacioRepository;



    @Override
    public void run(String... args) throws Exception {

        Random random = new Random(42);

        usuarioRepository.save(new Usuario(
            "Andrés Martínez",
            "andres.martinez@gmail.com",
            "3004567821",
            "Andres123",
            "CLIENTE",
            true,
            new Date()
        ));

        usuarioRepository.save(new Usuario(
            "Laura Rodríguez",
            "laura.rodriguez@gmail.com",
            "3157823490",
            "Laura123",
            "CLIENTE",
            true,
            new Date()
        ));

        usuarioRepository.save(new Usuario(
            "Santiago Gómez",
            "santiago.gomez@gmail.com",
            "3106745238",
            "Santiago123",
            "CLIENTE",
            true,
            new Date()
        ));

        usuarioRepository.save(new Usuario(
            "Valentina Herrera",
            "valentina.herrera@gmail.com",
            "3204587612",
            "Valentina123",
            "CLIENTE",
            true,
            new Date()
        ));

        usuarioRepository.save(new Usuario(
            "Nicolás Ramírez",
            "nicolas.ramirez@gmail.com",
            "3018964527",
            "Nicolas123",
            "CLIENTE",
            true,
            new Date()
        ));

        usuarioRepository.save(new Usuario(
            "Daniela Castro",
            "daniela.castro@gmail.com",
            "3165438902",
            "Daniela123",
            "CLIENTE",
            true,
            new Date()
        ));
        
        //creacion de reservas
        // Creacion de reservas

        reservaRepository.save(new Reserva(
            LocalDate.of(2026, 9, 18),
            LocalTime.of(9, 0),
            LocalTime.of(10, 0),
            true,
            LocalDate.now(),
            "Corte de cabello",
            35000.0
        ));

        reservaRepository.save(new Reserva(
            LocalDate.of(2026, 9, 18),
            LocalTime.of(10, 30),
            LocalTime.of(11, 30),
            true,
            LocalDate.now(),
            "Corte y arreglo de barba",
            50000.0
        ));

        reservaRepository.save(new Reserva(
            LocalDate.of(2026, 9, 19),
            LocalTime.of(14, 0),
            LocalTime.of(15, 0),
            true,
            LocalDate.now(),
            "Cliente solicita corte clásico",
            30000.0
        ));

        reservaRepository.save(new Reserva(
            LocalDate.of(2026, 9, 19),
            LocalTime.of(16, 30),
            LocalTime.of(17, 30),
            false,
            LocalDate.now(),
            "Reserva pendiente de confirmación",
            45000.0
        ));

        reservaRepository.save(new Reserva(
            LocalDate.of(2026, 9, 20),
            LocalTime.of(11, 0),
            LocalTime.of(12, 0),
            true,
            LocalDate.now(),
            "Corte degradado",
            40000.0
        ));

        reservaRepository.save(new Reserva(
            LocalDate.of(2026, 9, 20),
            LocalTime.of(15, 0),
            LocalTime.of(16, 0),
            true,
            LocalDate.now(),
            "Corte y lavado",
            55000.0
        ));

        // Asignar usuarios a reservas

        int cantidadUsuarios = usuarioRepository.findAll().size();
        for (Reserva reserva : reservaRepository.findAll()) {
            int randomNum = random.nextInt(1, cantidadUsuarios + 1);
            Usuario user = usuarioRepository.findById((long) randomNum).get();
            reserva.setUsuario(user);
            reservaRepository.save(reserva);
        }

        //creacion de servicios

        servicioRepository.save(new Servicio(
            "Corte clásico",
            "Corte de cabello tradicional con acabado y peinado.",
            30000.0,
            true
        ));

        servicioRepository.save(new Servicio(
            "Corte degradado",
            "Corte con degradado en laterales y acabado personalizado.",
            35000.0,
            true
        ));

        servicioRepository.save(new Servicio(
            "Arreglo de barba",
            "Perfilado, recorte y arreglo completo de barba.",
            20000.0,
            true
        ));

        servicioRepository.save(new Servicio(
            "Corte y barba",
            "Servicio completo de corte de cabello y arreglo de barba.",
            48000.0,
            true
        ));

        servicioRepository.save(new Servicio(
            "Lavado de cabello",
            "Lavado de cabello con productos profesionales.",
            15000.0,
            true
        ));

        servicioRepository.save(new Servicio(
            "Cejas",
            "Perfilado y arreglo de cejas.",
            12000.0,
            true
        ));

        //asignar servicios a reserva
        int cantidadServicio = servicioRepository.findAll().size();
        //cada reserva va a tener 3 servicios
        int CANTIDAD_RESERA_SERVICIO = 3;
        for (Reserva reserva : reservaRepository.findAll()) {
            for(int i = 0; i < CANTIDAD_RESERA_SERVICIO; i++){
                int randomNumServicio = random.nextInt(1, cantidadServicio + 1);    
                Servicio servicio = servicioRepository.findById((long) randomNumServicio).get();
                reserva.getServicio().add(servicio);
            }
            reservaRepository.save(reserva);
        }

        //creacion de espacio
        espacioRepository.save(new Espacio(
            "Estación 1",
            "Barbería",
            "Estación equipada para cortes de cabello.",
            1,
            "https://s.dabelleza.com/ogimg/barberias.jpg",
            true
        ));

        espacioRepository.save(new Espacio(
            "Estación 2",
            "Barbería",
            "Estación para cortes, degradados y peinados.",
            1,
            "https://s.dabelleza.com/ogimg/barberias.jpg",
            true
        ));

        espacioRepository.save(new Espacio(
            "Estación 3",
            "Barbería",
            "Estación equipada para corte y arreglo de barba.",
            1,
            "https://s.dabelleza.com/ogimg/barberias.jpg",
            true
        ));

        espacioRepository.save(new Espacio(
            "Zona de barba",
            "Barba",
            "Espacio especializado para perfilado y arreglo de barba.",
            1,
            "https://s.dabelleza.com/ogimg/barberias.jpg",
            true
        ));

        espacioRepository.save(new Espacio(
            "Zona de lavado",
            "Lavado",
            "Espacio equipado con lavacabezas y productos para el cabello.",
            1,
            "https://ubeauty.pro/image/cache/catalog/import_yml/719/975/681/1198050018-mojka-parikmaherskaya-shelliflamingo-550x550w.jpg",
            true
        ));

        espacioRepository.save(new Espacio(
            "Estación Premium",
            "Barbería",
            "Estación privada para servicios completos de corte y barba.",
            1,
            "https://img.ltwebstatic.com/images3_spmp/2024/12/07/bf/17335514592d75b59cc7b294d5372dc046b0cf2878_thumbnail_900x.jpg",
            true
        ));

        

        //asignar espacios a los servicios
        int cantidadEspacios = espacioRepository.findAll().size();
        // Cada servicio va a tener 3 espacios
        int CANTIDAD_ESPACIOS_SERVICIO = 3;
        for (Servicio servicio : servicioRepository.findAll()) {
            for (int i = 0; i < CANTIDAD_ESPACIOS_SERVICIO; i++) {
                int randomNumEspacio = random.nextInt(1, cantidadEspacios + 1);
                Espacio espacio = espacioRepository
                        .findById((long) randomNumEspacio)
                        .get();
                servicio.getEspacio().add(espacio);
            }
            servicioRepository.save(servicio);
        }
    }
    
}
