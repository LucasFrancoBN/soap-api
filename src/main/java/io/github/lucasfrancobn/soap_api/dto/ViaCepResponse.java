package io.github.lucasfrancobn.soap_api.dto;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@XmlRootElement(name = "xmlcep")
public class ViaCepResponse {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    @XmlElement
    public String getCep() {
        return cep;
    }

    @XmlElement
    public String getLogradouro() {
        return logradouro;
    }

    @XmlElement
    public String getComplemento() {
        return complemento;
    }

    @XmlElement
    public String getUnidade() {
        return unidade;
    }

    @XmlElement
    public String getBairro() {
        return bairro;
    }

    @XmlElement
    public String getLocalidade() {
        return localidade;
    }

    @XmlElement
    public String getUf() {
        return uf;
    }

    @XmlElement
    public String getEstado() {
        return estado;
    }

    @XmlElement
    public String getRegiao() {
        return regiao;
    }

    @XmlElement
    public String getIbge() {
        return ibge;
    }

    @XmlElement
    public String getGia() {
        return gia;
    }

    @XmlElement
    public String getDdd() {
        return ddd;
    }

    @XmlElement
    public String getSiafi() {
        return siafi;
    }
}
