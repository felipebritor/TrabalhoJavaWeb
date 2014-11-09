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
import org.lasalle.javaweb.av2.modelo.Musica;
import org.lasalle.javaweb.av2.sessao.MusicaFacade;

/**
 *
 * @author Avell B153
 */
@Named(value = "musicaBean")
@RequestScoped
public class MusicaBean extends AbstractBean<Musica>{

     @EJB
    MusicaFacade musicaFacade;

    public MusicaBean() {
        super(Musica.class);
    }
    
    @Override
    public String salvar(){
       if (getEdt() != null) {
            musicaFacade.edit(getEdt());
        } else {
            musicaFacade.create(getObj());
        }
        cleanUp();
        return null; 
    }
    

    public List<Musica> getMusicas(){
        
        return musicaFacade.findAll();
    }

    @Override
    public String excluir() {
        musicaFacade.remove(getSelecionado());
        return null;
    }
    
}
