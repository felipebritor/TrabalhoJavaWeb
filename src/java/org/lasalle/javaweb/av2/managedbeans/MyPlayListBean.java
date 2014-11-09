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
import org.lasalle.javaweb.av2.modelo.MyPlayList;
import org.lasalle.javaweb.av2.sessao.MyPlayListFacade;

/**
 *
 * @author Avell B153
 */
@Named(value = "myPlayListBean")
@RequestScoped
public class MyPlayListBean extends AbstractBean<MyPlayList>{

    @EJB
    MyPlayListFacade myPlayListFacade;

    public MyPlayListBean() {
        super(MyPlayList.class);
    }
    
    @Override
    public String salvar(){
       if (getEdt() != null) {
            myPlayListFacade.edit(getEdt());
        } else {
            myPlayListFacade.create(getObj());
        }
        cleanUp();
        return null; 
    }
    

    public List<MyPlayList> getMyPlayLists(){
        
        return myPlayListFacade.findAll();
    }

    @Override
    public String excluir() {
        myPlayListFacade.remove(getSelecionado());
        return null;
    }
    
    
}
