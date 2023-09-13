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
public class FotoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fp_id")
    private Integer id;

    @Column(name = "fp_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate data;

    @Column(name = "fp_bucket")
    private String bucket;

    @Column(name = "fp_hash")
    private String hash;

    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoa;

}
