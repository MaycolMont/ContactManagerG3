/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.validator;
import javafx.scene.control.TextField;

/**
 *
 * @author maycmont
 */
public class FormatValidator implements InputValidator {
    private final String regex;
    private final TextField textField;
    private final String message;
    private final boolean required;
    
    public FormatValidator(TextField textField, String regex, String message, boolean required) {
        this.regex = regex;
        this.textField = textField;
        this.message = message;
        this.required = required;
    }
    
    @Override
    public void validate() {
        String input = textField.getText();
        if (input.isBlank() && required){
            throw new IllegalArgumentException("El campo no puede estar vacío");
        } else if(input.isBlank() && !required) {
            return;
        }
        
        if (!regex.isBlank()) {
            input = input.replaceAll("\\s+", "");
            if (!input.matches(regex)) {
                throw new IllegalArgumentException(message);
            }
        }
        
    }
    
}
