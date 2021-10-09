package br.com.johnsquispe.thechess.domain.usuario;

import br.com.johnsquispe.thechess.domain.AbstractDomain;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = Usuario.Table.NAME)
public class Usuario extends AbstractDomain {

    @Id
    @GenericGenerator(name = "usuarioSequenceGenerator",
            parameters = @org.hibernate.annotations.Parameter(name = "sequence_name", value = "USUARIO_ID_SEQUENCE"),
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSequenceGenerator")
    @Column(name = Columns.ID)
    private Long id;

    @Column(name = Columns.UUID)
    private UUID uuid;

    @Column(name = Columns.NICKNAME)
    private String nickname;

    @Column(name = Columns.EMAIL)
    private String email;

    @Column(name = Columns.SENHA)
    private String senha;

    @Column(name = Columns.DATA_CRIACAO)
    private LocalDateTime dataCriacao;

    @Column(name = Columns.DATA_EXCLUSAO)
    private LocalDateTime dataExclusao;

    @Column(name = Columns.DATA_INATIVACAO)
    private LocalDateTime dataInativacao;

    @Column(name = Columns.TIPO_CONTA)
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(name = Columns.TOKEN_RESET_SENHA)
    private UUID tokenResetSenha;

    @Column(name = Columns.DATA_SOLICITACAO_TOKEN_RESET_SENHA)
    private LocalDateTime dataSolicitacaoTokenResetDeSenha;

    @Column(name = Columns.DATA_RESET_SENHA)
    private LocalDateTime dateResetSenha;

    @Column(name = Columns.DATA_VALIDADE_TOKEN_RESET_SENHA)
    private LocalDateTime dataValidadeTokenResetSenha;

    /*
    * Construtores
    * */

    public Usuario () {

    }

    public Usuario(String nickname, String email, String senha, TipoConta tipoConta) {
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.tipoConta = tipoConta;
        this.dataCriacao = LocalDateTime.now();
    }


    /*
    * Enums
    * */

    public enum Status {

        OCUPADO,
        DISPONIVEL

    }

    public enum TipoConta {

        OPEN_ID,
        COMUM

    }

    /*
    * Getters And Setters
    * */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(LocalDateTime dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public LocalDateTime getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(LocalDateTime dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public UUID getTokenResetSenha() {
        return tokenResetSenha;
    }

    public void setTokenResetSenha(UUID tokenResetSenha) {
        this.tokenResetSenha = tokenResetSenha;
    }

    public LocalDateTime getDataSolicitacaoTokenResetDeSenha() {
        return dataSolicitacaoTokenResetDeSenha;
    }

    public void setDataSolicitacaoTokenResetDeSenha(LocalDateTime dataSolicitacaoTokenResetDeSenha) {
        this.dataSolicitacaoTokenResetDeSenha = dataSolicitacaoTokenResetDeSenha;
    }

    public LocalDateTime getDateResetSenha() {
        return dateResetSenha;
    }

    public void setDateResetSenha(LocalDateTime dateResetSenha) {
        this.dateResetSenha = dateResetSenha;
    }

    public LocalDateTime getDataValidadeTokenResetSenha() {
        return dataValidadeTokenResetSenha;
    }

    public void setDataValidadeTokenResetSenha(LocalDateTime dataValidadeTokenResetSenha) {
        this.dataValidadeTokenResetSenha = dataValidadeTokenResetSenha;
    }


    /*
    * Regras de Negócio
    * */

    public void criarNovoTokenResetSEnha (UUID tokenResetSenha) {
        this.tokenResetSenha = tokenResetSenha;
        this.dataSolicitacaoTokenResetDeSenha = LocalDateTime.now();
        this.dataValidadeTokenResetSenha = LocalDateTime.now().plusMinutes(5);
    }

    /*
    * Informações do Banco
    * */

    public class Table {

        public final static String NAME = "USUARIO";

        private Table() {

        }

    }

    public class Columns {

        public static final String ID = "ID";
        public static final String NICKNAME = "NICKNAME";
        public static final String UUID = "UUID";
        public static final String EMAIL = "EMAIL";
        public static final String SENHA = "SENHA";
        public static final String DATA_CRIACAO = "DATA_CRIACAO";
        public static final String DATA_EXCLUSAO = "DATA_EXCLUSAO";
        public static final String DATA_INATIVACAO = "DATA_INATIVACAO";
        public static final String STATUS = "STATUS";
        public static final String TIPO_CONTA = "TIPO_CONTA";
        public static final String TOKEN_RESET_SENHA = "TOKEN_RESET_SENHA";
        public static final String DATA_SOLICITACAO_TOKEN_RESET_SENHA = "DATA_SOLICITACAO_TOKEN_RESET_SENHA";
        public static final String DATA_RESET_SENHA = "DATA_RESET_SENHA";
        public static final String DATA_VALIDADE_TOKEN_RESET_SENHA = "DATA_VALIDADE_TOKEN_RESET_SENHA";

    }

}
