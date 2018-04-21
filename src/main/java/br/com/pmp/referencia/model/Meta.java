package br.com.pmp.referencia.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Meta {
	
	private Long id;
	private String meta;
	private String autorMeta;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataInicio;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFim;
	private boolean finalizado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getAutorMeta() {
		return autorMeta;
	}
	public void setAutorMeta(String autorMeta) {
		this.autorMeta = autorMeta;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataFim() {
		return dataFim;
	}
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
}
