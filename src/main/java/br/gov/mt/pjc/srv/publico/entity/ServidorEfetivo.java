package br.gov.mt.pjc.srv.publico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class ServidorEfetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "se_id")
    private Integer id;

    @Column(name = "se_matricula", nullable = false)
    private String matricula;

    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoa;

}
