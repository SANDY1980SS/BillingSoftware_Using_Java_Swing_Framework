/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author iesha
 */
public class RegValidations 
{
    private Pattern name,email,phno,password;
    private Matcher matcher;
    
    
    String name_pattern = "^[a-zA-z ]{3,30}$";
    String email_pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+[A-Za-z]{2,6}$";
    String phone_pattern = "^\\+?\\d{1,3}?[-.\\s]?\\(?\\d{1,4}\\)?[-.\\s]?\\d{6,10}$";
    String pass_pattern = "^[a-zA-Z0-9]{5,20}";
     public RegValidations()
     {
         name = Pattern.compile(name_pattern);
         email = Pattern.compile(email_pattern);
         phno = Pattern.compile(phone_pattern);
         password = Pattern.compile(pass_pattern);
     }
     public boolean nameValidation(String user_name)
     {
        matcher = name.matcher(user_name);
         return matcher.matches();
     }
     public boolean emailValidation(String user_email)
     {
         matcher = email.matcher(user_email);
         return matcher.matches();
     }
     public boolean phonenoValidation(String user_phoneno)
     {
         matcher = phno.matcher(user_phoneno);
         return matcher.matches();
     }
     public boolean passwordValidation(String user_password)
     {
         matcher = password.matcher(user_password);
         return matcher.matches();
     }
}
