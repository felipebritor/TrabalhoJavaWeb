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
import org.lasalle.javaweb.av2.modelo.TipoDeInstrumento;
import org.lasalle.javaweb.av2.sessao.TipoDeInstrumentoFacade;

@Named(value = "tipoDeInstrumentoBean")
@RequestScoped
public class TipoDeInstrumentoBean extends AbstractBean<TipoDeInstrumento>{

    @EJB
    TipoDeInstrumentoFacade tipoDeInstrumentoFacade;

    
    /** Creates a new instance of ProdutoBean */
    public TipoDeInstrumentoBean() {
        super(TipoDeInstrumento.class);
    }
    
    @Override
    public String salvar(){
       if (getEdt() != null) {
            tipoDeInstrumentoFacade.edit(getEdt());
        } else {
            tipoDeInstrumentoFacade.create(getObj());
        }
        cleanUp();
        return null; 
    }
    

    public List<TipoDeInstrumento> getTipoDeInstrumentos(){
        return tipoDeInstrumentoFacade.findAll();
    }

    @Override
    public String excluir() {
        tipoDeInstrumentoFacade.remove(getSelecionado());
        return null;
    }
    
}
