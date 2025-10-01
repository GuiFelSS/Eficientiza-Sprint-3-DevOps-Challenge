package fiap.com.br.eficientiza.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mtt_moto")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moto")
    private Long id;

    @Column(name = "ds_placa", nullable = false, unique = true, length = 10)
    private String placa;

    @Column(name = "nm_modelo", nullable = false, length = 100)
    private String modelo;

    @Column(name = "ds_cor", length = 30)
    private String cor;

    @Column(name = "nr_ano")
    private Integer ano;

    @Column(name = "ds_status", length = 50)
    private String status;

    @Column(name = "ds_vaga", unique = true, length = 10)
    private String vaga;

    @ManyToOne
    @JoinColumn(name = "id_estacao", nullable = false)
    private Estacao estacao;

    public Moto() {}

    public Moto(String placa, String modelo, String cor, Integer ano, String status, String vaga, Estacao estacao) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.status = status;
        this.vaga = vaga;
        this.estacao = estacao;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }
}
