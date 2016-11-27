package com.citycare.model;

public class UsuarioSingleton {
	private static Usuario usuario = null;
	
	public static Usuario getInstance(){
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}
	public static void setInstance(Usuario usuario){
		UsuarioSingleton.usuario = usuario;
	}
	
}
