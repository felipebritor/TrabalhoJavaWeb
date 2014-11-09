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
import org.lasalle.javaweb.av2.modelo.Artista;
import org.lasalle.javaweb.av2.sessao.ArtistaFacade;

/**
 *
 * @author Avell B153
 */
@Named(value = "artistaBean")
@RequestScoped
public class ArtistaBean extends AbstractBean<Artista>{

    @EJB
    ArtistaFacade artistaFacade;

    public ArtistaBean() {
        super(Artista.class);
    }
    
    @Override
    public String salvar(){
       if (getEdt() != null) {
            artistaFacade.edit(getEdt());
        } else {
            artistaFacade.create(getObj());
        }
        cleanUp();
        return null; 
    }
    

    public List<Artista> getUsuarios(){
        
        return artistaFacade.findAll();
    }

    @Override
    public String excluir() {
        artistaFacade.remove(getSelecionado());
        return null;
    }
    
}
