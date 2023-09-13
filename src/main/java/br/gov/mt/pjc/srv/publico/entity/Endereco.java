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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private Integer id;

    @Column(name = "end_tipo_logradouro", nullable = false)
    private String tipoLogradouro;

    @Column(name = "end_logradouro", nullable = false)
    private String logradouro;

    @Column(name = "end_numero", nullable = false)
    private Integer numero;

    @Column(name = "end_bairro", nullable = false)
    private String bairro;

    @JoinTable(name = "unidade_endereco", joinColumns = {
            @JoinColumn(name = "end_id", referencedColumnName = "end_id")}, inverseJoinColumns = {
            @JoinColumn(name = "unid_id", referencedColumnName = "unid_id")}
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Unidade> unidadeList;

    @JoinTable(name = "pessoa_endereco", joinColumns = {
            @JoinColumn(name = "end_id", referencedColumnName = "end_id")}, inverseJoinColumns = {
            @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Pessoa> pessoaList;

    @JoinColumn(name = "cid_id", referencedColumnName = "cid_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade cidade;

}
