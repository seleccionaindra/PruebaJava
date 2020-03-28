package api.rest.indra.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import api.rest.indra.constante.PersonaConstante;
import api.rest.indra.dto.PersonaDTO;
import api.rest.indra.dto.ResponseDTO;
import api.rest.indra.entity.PersonaEntity;
import api.rest.indra.repository.IPersonaRepository;
import api.rest.indra.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepository personaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseDTO devolverPersonas() {

		ResponseDTO responseDTO;
		List<Object> listaDTO = new ArrayList<>();
		try {
			personaRepository.findAll().forEach(x -> listaDTO.add(modelMapper.map(x, PersonaDTO.class)));
			responseDTO = devolverResponse(listaDTO, HttpStatus.OK, HttpStatus.OK.getReasonPhrase());
		} catch (Exception e) {
			responseDTO = devolverResponse(listaDTO, HttpStatus.INTERNAL_SERVER_ERROR,
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		return responseDTO;
	}

	private ResponseDTO devolverResponse(List<Object> lista, HttpStatus status, String mensaje) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setResultado(lista);
		responseDTO.setCodigo(status.value());
		responseDTO.setMensaje(mensaje);
		responseDTO.setHttpStatus(status);
		return responseDTO;
	}

	private boolean idValido(String cadena) {
		try {
			Long.parseLong(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	@Override
	@Transactional
	public ResponseDTO eliminarPersona(String id) {
		ResponseDTO responseDTO;
		if (id != null && !id.trim().isEmpty() && idValido(id)) {

			if (personaRepository.findById(id).isPresent()) {
				try {
					personaRepository.deleteById(id);
					responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.OK, HttpStatus.OK.getReasonPhrase());
				} catch (Exception e) {
					responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
				}
			} else {
				responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.BAD_REQUEST,
						PersonaConstante.ERROR_ID_NO_EXISTE);
			}
		} else {
			responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.BAD_REQUEST,
					PersonaConstante.ERROR_ID_INCORRECTO);
		}
		return responseDTO;
	}

	@Override
	@Transactional
	public ResponseDTO crearPersona(PersonaDTO persona) {
		ResponseDTO responseDTO;
		if (persona != null && persona.getCedula() != null && idValido(persona.getCedula())) {
			if (personaRepository.findById(persona.getCedula()).isPresent()) {
				responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.BAD_REQUEST,
						PersonaConstante.ERROR_PERSONA_ID_EXISTENTE);
			} else {
				try {
					personaRepository.save(modelMapper.map(persona, PersonaEntity.class));
					responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.OK, HttpStatus.OK.getReasonPhrase());
				} catch (Exception e) {
					responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
				}
			}
		} else {
			responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.BAD_REQUEST,
					PersonaConstante.ERROR_PERSONA_INCORRECTA);
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO actualizarPersona(PersonaDTO persona) {
		ResponseDTO responseDTO;
		if (persona != null && persona.getCedula() != null && idValido(persona.getCedula())) {

			if (personaRepository.findById(persona.getCedula()).isPresent()) {
				personaRepository.save(modelMapper.map(persona, PersonaEntity.class));
				responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.OK, HttpStatus.OK.getReasonPhrase());
			} else {
				responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.BAD_REQUEST,
						PersonaConstante.ERROR_ID_NO_EXISTE);
			}

		} else {
			responseDTO = devolverResponse(new ArrayList<>(), HttpStatus.BAD_REQUEST,
					PersonaConstante.ERROR_PERSONA_INCORRECTA);
		}
		return responseDTO;
	}

}
