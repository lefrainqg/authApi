/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth.logic;

import auth.entity.Sesion;

/**
 *
 * @author Efrain
 */
public class AutenticacionLN {

    public static String verificarAuth(Sesion usesion, String strUsername, String strPassword) {
        String strResult;
        try {
            if (usesion.getSesUsername().equals(strUsername) && usesion.getSesPassword().equals(strPassword)) {
                if (usesion.getSesState()) {
                    strResult = "ok";
                } else {
                    strResult = "La cuenta a la que intenta acceder esta inactivo";
                }
            } else {
                strResult = "Usuario y contraseña incorrecto";
            }
        } catch (Exception e) {
            strResult = "Ha ocurrido algún problema, intente mas tarde";
        }
        return strResult;
    }

}
