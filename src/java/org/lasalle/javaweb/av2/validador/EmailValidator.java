package org.lasalle.javaweb.av2.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.lasalle.si.javaweb.av2.util.Messages;


/**
 *
 * @author Felipe Brito e Vitor Garcia
 */
@FacesValidator("validator.EmailValidator")
public class EmailValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = (String)value;
        if(!str.contains("@")){
            FacesMessage msg = Messages.getMessage("org.lasalle.si.javaweb.av1.strings.strings", "emailInvalido", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }    
    }
    
}
