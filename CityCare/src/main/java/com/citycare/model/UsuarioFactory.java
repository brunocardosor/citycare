package com.citycare.model;

public class UsuarioFactory {
	private static Usuario usuario = null;
	public static Usuario getInstance(){
		if(usuario == null){
			usuario = new Usuario();
		}
			return usuario;
		}
	}
	
