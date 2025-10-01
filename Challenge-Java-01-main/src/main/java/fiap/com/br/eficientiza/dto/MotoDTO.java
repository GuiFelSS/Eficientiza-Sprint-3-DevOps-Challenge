package fiap.com.br.eficientiza.dto;

public class MotoDTO {

    private Long id;
    private String placa;
    private String modelo;
    private String cor;
    private Integer ano;
    private String status;
    private String vaga;
    private Long idEstacao;

    public MotoDTO() {
    }

    public MotoDTO(Long id, String placa, String modelo, String cor, Integer ano, String status, String vaga, Long idEstacao) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.status = status;
        this.vaga = vaga;
        this.idEstacao = idEstacao;
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

    public Long getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Long idEstacao) {
        this.idEstacao = idEstacao;
    }
}
