package model;

import enums.TipoUsuario;
import java.time.LocalDate;

public class UsuarioModel {
    private int id;
    private String login;
    private String senha;
    private TipoUsuario tipoUsuario;
    private boolean ativo;
    private String criadoPor;
    private LocalDate criadoEm;
    private String alteradoPor;
    private LocalDate alteradoEm;

    public UsuarioModel () {
    }

    public UsuarioModel (int id, String login, String senha, TipoUsuario tipoUsuario, boolean ativo, String criadoPor, LocalDate criadoEm, String alteradoPor, LocalDate alteradoEm) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.ativo = ativo;
        this.criadoPor = criadoPor;
        this.criadoEm = criadoEm;
        this.alteradoPor = alteradoPor;
        this.alteradoEm = alteradoEm;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getLogin () {
        return login;
    }

    public void setLogin (String login) {
        this.login = login;
    }

    public String getSenha () {
        return senha;
    }

    public void setSenha (String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario () {
        return tipoUsuario;
    }

    public void setTipoUsuario (TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isAtivo () {
        return ativo;
    }

    public void setAtivo (boolean ativo) {
        this.ativo = ativo;
    }

    public String getCriadoPor () {
        return criadoPor;
    }

    public void setCriadoPor (String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public LocalDate getCriadoEm () {
        return criadoEm;
    }

    public void setCriadoEm (LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getAlteradoPor () {
        return alteradoPor;
    }

    public void setAlteradoPor (String alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public LocalDate getAlteradoEm () {
        return alteradoEm;
    }

    public void setAlteradoEm (LocalDate alteradoEm) {
        this.alteradoEm = alteradoEm;
    }
}
