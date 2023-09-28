package com.dim.agesilapi.entidades;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="INCIDENCIAS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="categoria", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("null")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Incidencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private Date fechaInicio;
	private Date fechaFin;
	private int numDias;
	private String estado;
	private Date comunicaEmpresa;
	private String infoAdicio_grabador;
	private String descripcion;
	public static enum Categoria {
		DeficienciaServicio,
		LimpiezaChoque,
		CambiosDependencia
	}
	@OneToMany(mappedBy = "incidencia")
	List<Usuario> usuarios;
	
	@OneToMany(mappedBy = "incidencia")
	List<Receptor> receptores;
	
	public Categoria getCategoria() {
		return null;
	}
	public Categoria setCategoria() {		
		return null;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getNumDias() {
		return numDias;
	}
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getComunicaEmpresa() {
		return comunicaEmpresa;
	}
	public void setComunicaEmpresa(Date comunicaEmpresa) {
		this.comunicaEmpresa = comunicaEmpresa;
	}
	public String getInfoAdicio_grabador() {
		return infoAdicio_grabador;
	}
	public void setInfoAdicio_grabador(String infoAdicio_grabador) {
		this.infoAdicio_grabador = infoAdicio_grabador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Receptor> getReceptores() {
		return receptores;
	}
	public void setReceptores(List<Receptor> receptores) {
		this.receptores = receptores;
	}
	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", numDias="
				+ numDias + ", estado=" + estado + ", comunicaEmpresa=" + comunicaEmpresa + ", infoAdicio_grabador="
				+ infoAdicio_grabador + ", descripcion=" + descripcion + ", usuarios=" + usuarios + ", receptores="
				+ receptores + "]";
	}

}
