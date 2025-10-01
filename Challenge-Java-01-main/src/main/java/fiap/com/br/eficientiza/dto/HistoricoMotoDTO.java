package fiap.com.br.eficientiza.dto;

import java.time.LocalDate;

public class HistoricoMotoDTO {

    private Long id;
    private Long idMoto;
    private Long idUsuario;
    private String tipoAcao;
    private LocalDate dataAcao;

    public HistoricoMotoDTO() {
    }

    public HistoricoMotoDTO(Long id, Long idMoto, Long idUsuario, String tipoAcao, LocalDate dataAcao) {
        this.id = id;
        this.idMoto = idMoto;
        this.idUsuario = idUsuario;
        this.tipoAcao = tipoAcao;
        this.dataAcao = dataAcao;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Long idMoto) {
        this.idMoto = idMoto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public LocalDate getDataAcao() {
        return dataAcao;
    }

    public void setDataAcao(LocalDate dataAcao) {
        this.dataAcao = dataAcao;
    }
}
