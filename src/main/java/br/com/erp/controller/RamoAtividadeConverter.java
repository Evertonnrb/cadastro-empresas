package br.com.erp.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.br.erp.model.RamoAtividade;

//@FacesConverter("ramoAtividadeConverter")
public class RamoAtividadeConverter implements Converter {
	
	private List<RamoAtividade> ramoDeAtividades;
	
	public RamoAtividadeConverter(List<RamoAtividade> ramoDeAtividades) {
		this.ramoDeAtividades = ramoDeAtividades;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null) {
			return null;
		}
		Long id = Long.valueOf(value);
		for(RamoAtividade atividade : ramoDeAtividades) {
			if(id.equals(atividade.getId())) {
				return atividade;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		RamoAtividade ramoAtividade = (RamoAtividade) value; 
		return ramoAtividade.getId().toString();
	}

}
