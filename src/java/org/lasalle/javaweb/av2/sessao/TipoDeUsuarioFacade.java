/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lasalle.javaweb.av2.sessao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.lasalle.javaweb.av2.modelo.TipoDeUsuario;

/**
 *
 * @author Vitor
 */
@Stateless
public class TipoDeUsuarioFacade extends AbstractFacade<TipoDeUsuario> {
    @PersistenceContext(unitName = "Av2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDeUsuarioFacade() {
        super(TipoDeUsuario.class);
    }
    
}
