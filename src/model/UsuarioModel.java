package model;

import enums.TipoUsuario;
import java.time.LocalDate;

public class UsuarioModel {
    private static int ultimoId = 0;
    private int id;
    private String login;
    private String senha;
    private TipoUsuario tipoUsuario;
    private boolean ativo;
    private boolean logado;
    private String criadoPor;
    private LocalDate criadoEm;
    private String alteradoPor;
    private LocalDate alteradoEm;

    @Override
    public String toString () {
        return "UsuarioModel{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", senha='" + senha + '\'' +
            ", tipoUsuario=" + tipoUsuario +
            ", ativo=" + ativo +
            ", criadoPor='" + criadoPor + '\'' +
            ", criadoEm=" + criadoEm +
            ", alteradoPor='" + alteradoPor + '\'' +
            ", alteradoEm=" + alteradoEm +
            '}';
    }

    public UsuarioModel () {
            this.id = ++ultimoId;
    }

    public UsuarioModel (String login, String senha, TipoUsuario tipoUsuario, boolean ativo, boolean logado, String criadoPor, LocalDate criadoEm, String alteradoPor, LocalDate alteradoEm) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.ativo = ativo;
        this.logado = logado;
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

    public boolean isLogado() {
        return logado;
    }

    public UsuarioModel setLogado(boolean logado) {
        this.logado = logado;
        return this;
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
