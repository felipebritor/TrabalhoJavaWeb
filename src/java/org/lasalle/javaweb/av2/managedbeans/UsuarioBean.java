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
import org.lasalle.javaweb.av2.modelo.Usuario;
import org.lasalle.javaweb.av2.sessao.UsuarioFacade;

/**
 *
 * @author Avell B153
 */
@Named(value = "usuarioBean")
@RequestScoped
public class UsuarioBean extends AbstractBean<Usuario>{

    @EJB
    UsuarioFacade usuarioFacade;

    public UsuarioBean() {
        super(Usuario.class);
    }
    
    @Override
    public String salvar(){
       if (getEdt() != null) {
            usuarioFacade.edit(getEdt());
        } else {
            usuarioFacade.create(getObj());
        }
        cleanUp();
        return null; 
    }
    

    public List<Usuario> getUsuarios(){
        
        return usuarioFacade.findAll();
    }

    @Override
    public String excluir() {
        usuarioFacade.remove(getSelecionado());
        return null;
    }
    
}
