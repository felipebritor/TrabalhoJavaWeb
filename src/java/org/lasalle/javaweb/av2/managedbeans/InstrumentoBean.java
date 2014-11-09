/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import org.lasalle.javaweb.av2.modelo.Instrumento;
import org.lasalle.javaweb.av2.sessao.InstrumentoFacade;

/**
 *
 * @author Avell B153
 */
@Named(value = "instrumentoBean")
@RequestScoped
public class InstrumentoBean extends AbstractBean<Instrumento>{

    @EJB
    InstrumentoFacade instrumentoFacade;

    public InstrumentoBean() {
        super(Instrumento.class);
    }
    
    @Override
    public String salvar(){
       if (getEdt() != null) {
            instrumentoFacade.edit(getEdt());
        } else {
            instrumentoFacade.create(getObj());
        }
        cleanUp();
        return null; 
    }
    

    public List<Instrumento> getInstrumentos(){
        
        return instrumentoFacade.findAll();
    }

    @Override
    public String excluir() {
        instrumentoFacade.remove(getSelecionado());
        return null;
    }
    
}
