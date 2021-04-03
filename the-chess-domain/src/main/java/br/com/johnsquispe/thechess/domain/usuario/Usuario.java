package br.com.johnsquispe.thechess.domain.usuario;

import br.com.johnsquispe.thechess.domain.AbstractDomain;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USUARIO")
public class Usuario extends AbstractDomain {

    @Id
    @GenericGenerator(name = "usuarioSequenceGenerator",
            parameters = @org.hibernate.annotations.Parameter(name = "sequence_name", value = "USUARIO_ID_SEQUENCE"),
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSequenceGenerator")
    @Column(name = Columns.ID)
    private Long id;

    @Column(name = Columns.NICKNAME)
    private String nickname;

    @Column(name = Columns.EMAIL)
    private String email;

    @Column(name = Columns.SENHA)
    private String senha;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Columns.DATA_CRIACAO)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Columns.DATA_EXCLUSAO)
    private Date dataExclusao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Columns.DATA_INATIVACAO)
    private Date dataInativacao;

    @Column(name = Columns.TIPO_CONTA)
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    public Usuario () {

    }

    public Usuario(String nickname, String email, String senha, TipoConta tipoConta) {
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.tipoConta = tipoConta;
        this.dataCriacao = new Date();
    }

    public enum Status {

        OCUPADO,
        DISPONIVEL

    }

    public enum TipoConta {

        OPEN_ID,
        COMUM;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Date getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public class Table {
        public final static String NAME = "USUARIO";
    }

    public class Columns {

        public static final String ID = "ID";
        public static final String NICKNAME = "NICKNAME";
        public static final String EMAIL = "EMAIL";
        public static final String SENHA = "SENHA";
        public static final String DATA_CRIACAO = "DATA_CRIACAO";
        public static final String DATA_EXCLUSAO = "DATA_EXCLUSAO";
        public static final String DATA_INATIVACAO = "DATA_INATIVACAO";
        public static final String STATUS = "STATUS";
        public static final String TIPO_CONTA = "TIPO_CONTA";

    }

}
