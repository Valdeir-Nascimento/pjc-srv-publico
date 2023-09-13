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
public class ServidorTemporario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "st_data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "st_data_demissao")
    @Temporal(TemporalType.DATE)
    private LocalDate dataDemissao;

    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoa;

}
