package repository;

import model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo {
  private List<UsuarioModel>  usuarios;

  public UsuarioRepo(){
    usuarios = new ArrayList<UsuarioModel>();
  }
}
