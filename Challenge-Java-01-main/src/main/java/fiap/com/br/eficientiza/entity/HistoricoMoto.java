package fiap.com.br.eficientiza.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_mtt_historico_moto")
public class HistoricoMoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_moto", nullable = false)
    private Moto moto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "tp_acao", nullable = false, length = 20)
    private String tipoAcao;

    @Column(name = "dt_acao", nullable = false)
    private LocalDate dataAcao;

    public HistoricoMoto() {}

    public HistoricoMoto(Moto moto, Usuario usuario, String tipoAcao, LocalDate dataAcao) {
        this.moto = moto;
        this.usuario = usuario;
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

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
