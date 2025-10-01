package fiap.com.br.eficientiza.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_mtt_estacao")
public class Estacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacao")
    private Long id;

    @Column(name = "nm_estacao", nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "ds_localizacao", length = 200)
    private String localizacao;

    @Column(name = "nr_capacidade")
    private Integer capacidade;

    @Column(name = "ds_status", nullable = false, length = 30)
    private String status;

    @Column(name = "dt_criacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;

    @Column(name = "dt_ultima_atualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

    @Column(name = "ds_responsavel", length = 100)
    private String responsavel;

    public Estacao() {}

    public Estacao(String nome, String localizacao, Integer capacidade, String status,
                   Date dataCriacao, Date dataAtualizacao, String responsavel) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.responsavel = responsavel;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
