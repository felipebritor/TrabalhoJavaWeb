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
import org.lasalle.javaweb.av2.modelo.TipoDeUsuario;
import org.lasalle.javaweb.av2.sessao.TipoDeUsuarioFacade;

/**
 *
 * @author Avell B153
 */
@Named(value = "tipoDeUsuarioBean")
@RequestScoped
public class TipoDeUsuarioBean extends AbstractBean<TipoDeUsuario>{

     @EJB
    TipoDeUsuarioFacade tipoDeUsuarioFacade;

    
    /** Creates a new instance of ProdutoBean */
    public TipoDeUsuarioBean() {
        super(TipoDeUsuario.class);
    }
    
    @Override
    public String salvar(){
       if (getEdt() != null) {
            tipoDeUsuarioFacade.edit(getEdt());
        } else {
            tipoDeUsuarioFacade.create(getObj());
        }
        cleanUp();
        return null;
    }
    

    public List<TipoDeUsuario> getTipoDeUsuarios(){
        
        return tipoDeUsuarioFacade.findAll();
    }

    @Override
    public String excluir() {
        tipoDeUsuarioFacade.remove(getSelecionado());
        return null;
    }
    
}
