package br.gov.mt.pjc.srv.publico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_id")
    private Integer id;

    @Column(name = "pes_nome", nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "pes_data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "pes_sexo", nullable = false)
    private String sexo;

    @Column(name = "pes_mae", nullable = false)
    private String mae;

    @Column(name = "pes_pai", nullable = false)
    private String pai;

    @ManyToMany(mappedBy = "pessoaList")
    private List<Endereco> enderecoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<FotoPessoa> fotoPessoaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<Lotacao> lotacaoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<ServidorEfetivo> servidorEfetivoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<ServidorTemporario> servidorTemporarioList;

}
