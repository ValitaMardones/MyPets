package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocialmypets.mypets.model.PerfilMascota;
import com.redsocialmypets.mypets.model.DTO.PerfilDTO;
import com.redsocialmypets.mypets.repository.PerfilMascotaRepository;

@Service
public class PerfilMascotaService {

  @Autowired
  private PerfilMascotaRepository perfilMascotaRepository;

  // Solo usuarios autorizados podran acceder a la lista completa de Perfiles de
  // Mascotas
  public List<PerfilMascota> findAllPerfilMascota() {
    return perfilMascotaRepository.findAll();
  }

  // Cuando soliciten informacion del perfil de una mascota se entregara un
  // PerfilDTO para proteger datos sencibles

  public PerfilDTO getPerfilMascotaById(Long id) {
    PerfilMascota perfilGet = perfilMascotaRepository.findPerfilMascotaById(id);
    PerfilDTO perfilDTOId = PerfilDTO.builder()
        .nombrePerfil(perfilGet.getNombre())
        .nombreUsuario(perfilGet.getIdUsuarioPerfilMascota().getNombre())
        .apellidoUsuario(perfilGet.getIdUsuarioPerfilMascota().getApellido())
        .build();
    return perfilDTOId;
  }

  // Cuando se registre un nuevo PerfilMascota solo retornaran datos del perfilDTO
  // para proteger datos sencibles
  @Transactional
  public PerfilDTO savePerfilMascota(PerfilMascota perfilMascota) {
    PerfilMascota perfilMascotaGuardar = perfilMascotaRepository.save(perfilMascota);
    PerfilDTO perfilDTOGuardado = PerfilDTO.builder()
        .nombrePerfil(perfilMascotaGuardar.getNombre())
        .nombreUsuario(perfilMascotaGuardar.getIdUsuarioPerfilMascota().getNombre())
        .apellidoUsuario(perfilMascotaGuardar.getIdUsuarioPerfilMascota().getApellido())
        .build();
    return perfilDTOGuardado;
  }

  // Solo usuarios autorizados podran actualizar datos de los perfiles, por lo que
  // no sera necesario entregar un PerfilDTO para proteger datos
  @Transactional
  public PerfilMascota updatePerfilMascota(PerfilMascota perfilMascota) {
    PerfilMascota perfilMascotaActualizar = perfilMascotaRepository.save(perfilMascota);
    return perfilMascotaActualizar;
  }

  @Transactional
  public void deletePerfilMascota(Long id) {
    perfilMascotaRepository.deleteById(id);
  }

}
