/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fg1.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Login  implements Serializable{
    private String  email;

    
    private String code;
    
        

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Login{" + "email=" + email + ", code=" + code + '}';
    }
    
    
}
