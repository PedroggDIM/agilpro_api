package com.dim.agesilapi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

import com.dim.agesilapi.entidades.Incidencia;

@Entity
@Table(name="USUARIOS")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private int id_unidad;
	private String correo;
	private String contrasenia;
	private int tip;
	public static enum UsuarioRol {
		Grabador,
		Administrador
	}
	private UsuarioRol estado = UsuarioRol.Grabador;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IncidenciaId")
	private Incidencia incidencia;
	
	// de entidad Unidad
	@OneToMany(mappedBy = "usuario")
	List<Unidad> unidades;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getId_unidad() {
		return id_unidad;
	}

	public void setId_unidad(int id_unidad) {
		this.id_unidad = id_unidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getTip() {
		return tip;
	}

	public void setTip(int tip) {
		this.tip = tip;
	}

	public UsuarioRol getEstado() {
		return estado;
	}

	public void setEstado(UsuarioRol estado) {
		this.estado = estado;
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", id_unidad=" + id_unidad + ", correo=" + correo + ", contrasenia=" + contrasenia
				+ ", tip=" + tip + ", estado=" + estado + ", incidencia=" + incidencia + "]";
	}
	

}
