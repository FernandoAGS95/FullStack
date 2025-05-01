package com.example.SegundaEntrega.Model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuario {
//QUe diferencia existe entre usar getter setter y @Data?
// @Data incluye getter, setter, toString, equals y hashCode
//Para un superClass, es mejor usar @Data o @Getter y @Setter?
    protected String id;
    protected String rut;
    protected String username;
    protected String password;
    protected String nombre;
    protected String apellido;
 
    protected RolUsuario rol; 

    public enum RolUsuario {
      ADMIN,
      PROFESOR,
      ALUMNO,
      APODERADO
  }
  // Constructor
  public Usuario(String username, String password,String rut, String nombre, String apellido, RolUsuario rol) {
    this.username = username;
    this.password = password;
    this.rut = rut;
    this.nombre = nombre;
    this.apellido = apellido;
    this.rol = rol;
}
    
    // Método abstracto para mostrar información específica
    public abstract String mostrarInformacion();
}
