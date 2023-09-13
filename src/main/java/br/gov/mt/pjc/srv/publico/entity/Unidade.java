package br.gov.mt.pjc.srv.publico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unid_id")
    private Integer id;

    @Column(name = "unid_nome", nullable = false)
    private String nome;

    @Column(name = "unid_sigla")
    private String sigla;

    @ManyToMany(mappedBy = "unidadeList", fetch = FetchType.LAZY)
    private List<Endereco> enderecoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidade", fetch = FetchType.LAZY)
    private List<Lotacao> lotacaoList;

}
