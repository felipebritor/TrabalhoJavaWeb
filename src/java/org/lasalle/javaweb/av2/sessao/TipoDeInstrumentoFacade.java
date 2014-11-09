/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.sessao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.lasalle.javaweb.av2.modelo.TipoDeInstrumento;

/**
 *
 * @author Vitor
 */
@Stateless
public class TipoDeInstrumentoFacade extends AbstractFacade<TipoDeInstrumento> {
    @PersistenceContext(unitName = "Av2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDeInstrumentoFacade() {
        super(TipoDeInstrumento.class);
    }
    
}
