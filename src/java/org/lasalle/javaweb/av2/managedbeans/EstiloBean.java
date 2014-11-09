/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.lasalle.javaweb.av2.modelo.Estilo;
import org.lasalle.javaweb.av2.sessao.EstiloFacade;

/**
 *
 * @author Avell B153
 */
@Named(value = "estiloBean")
@RequestScoped
public class EstiloBean extends AbstractBean<Estilo>{

    @EJB
    EstiloFacade estiloFacade;

    public EstiloBean() {
        super(Estilo.class);
    }
    
    @Override
    public String salvar(){
       if (getEdt() != null) {
            estiloFacade.edit(getEdt());
        } else {
            estiloFacade.create(getObj());
        }
        cleanUp();
        return null; 
    }
    

    public List<Estilo> getEstilos(){
        
        return estiloFacade.findAll();
    }

    @Override
    public String excluir() {
        estiloFacade.remove(getSelecionado());
        return null;
    }
    
}
