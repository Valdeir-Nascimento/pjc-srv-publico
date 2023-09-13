package br.gov.mt.pjc.srv.publico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id")
    private Integer id;

    @Column(name = "lot_data_lotacao")
    @Temporal(TemporalType.DATE)
    private LocalDate dataLotacao;

    @Column(name = "lot_data_remocao")
    @Temporal(TemporalType.DATE)
    private LocalDate dataRemocao;

    @Column(name = "lot_portaria", nullable = false)
    private String portaria;

    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoa;

    @JoinColumn(name = "unid_id", referencedColumnName = "unid_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Unidade unidade;

}
