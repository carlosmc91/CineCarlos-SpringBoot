package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Usuarios;
import com.example.demo.model.MUsuarios;


@Component("mapper")
public class Mapper {
	
	public static List<MUsuarios> convertirLista(List<Usuarios> usuarios){
		List<MUsuarios> mUsuarios = new ArrayList<>();
		
		for(Usuarios usuario: usuarios) {
			mUsuarios.add(new MUsuarios(usuario));
		}
	
		return mUsuarios;
	}

}
