#  🧼 SOAP API 🧼

<div align="center">
 <h2> Sumário</h2>
  <a href="#descrição-do-projeto">Descrição do projeto</a> -
  <a href="#ferramentas-utilizadas">Ferramentas utilizadas</a> - 
  <a href="#wsdl">WSDL</a> - 
  <a href="#guia-de-implantação">Guia de implantação</a> -
  <a href="#exemplo-de-requests">Exemplo de requests</a> -
  <a href="#desenvolvedores">Desenvolvedores</a>
</div>

## Descrição do projeto
<p align="justify">
Este projeto foi desenvolvido como uma aplicação de estudo para criação de uma API SOAP utilizando Java e Spring Boot. Durante o desenvolvimento, explorei conceitos fundamentais do protocolo SOAP e aprofundei meus conhecimentos no ecossistema Spring, com foco no uso do Spring Web Services para a implementação e exposição dos endpoints. O objetivo principal foi consolidar práticas de integração, estruturação de serviços e boas práticas no desenvolvimento de APIs SOAP com Java.
## Funcionalidades

`Funcionalidade 1:` CRUD de usuários.

`Funcionalidade 2:` Integração com a API ViaCep para busca de endereços.

`Funcionalidade 3:` Tratamento da resposta da API ViaCep em formato XML.

`Funcionalidade 4:` Definição e uso de schemas XSD personalizados.


## WSDL
Abaixo estão exemplos dos schemas XSD utilizados para definição dos contratos de entrada e saída nos endpoints:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           targetNamespace="http://example.com/soap/address"
           xmlns:tns="http://example.com/soap/address"
           elementFormDefault="qualified">

    <xs:element name="findAddress">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="cep" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="addressResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="address" type="tns:address"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="address">
        <xs:sequence>
            <xs:element name="id" type="xs:long"/>
            <xs:element name="cep" type="xs:string"/>
            <xs:element name="street" type="xs:string"/>
            <xs:element name="complement" type="xs:string"/>
            <xs:element name="unit" type="xs:string"/>
            <xs:element name="district" type="xs:string"/>
            <xs:element name="city" type="xs:string"/>
            <xs:element name="stateCode" type="xs:string"/>
            <xs:element name="state" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:schema>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           targetNamespace="http://example.com/soap/users"
           xmlns:tns="http://example.com/soap/users"
           xmlns:addr="http://example.com/soap/address"
           elementFormDefault="qualified">

    <xs:import namespace="http://example.com/soap/address"
               schemaLocation="../address/address.xsd"/>


    <xs:element name="getUserRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="id" type="xs:long"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="createUserRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="createUser" type="tns:createUser"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="updateUserRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="updateUser" type="tns:updateUser"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="deleteUserRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="id" type="xs:long"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="userResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="user" type="tns:user"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="deleteUserResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="deletedUser" type="xs:boolean"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="user">
        <xs:sequence>
            <xs:element name="id" type="xs:long"/>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="email" type="xs:string"/>
            <xs:element name="address" type="addr:address"/>
        </xs:sequence>
    </xs:complexType>

    <xs:complexType name="createUser">
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="email" type="xs:string"/>
            <xs:element name="cep" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>

    <xs:complexType name="updateUser">
        <xs:sequence>
            <xs:element name="id" type="xs:long"/>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="email" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:schema>
```

## Ferramentas utilizadas
<div style="display: flex; gap: 15px">
<a href="https://www.java.com" target="_blank"> 
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="40" height="40"/> 
</a>

<a href="https://spring.io/" target="_blank"> 
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="Spring" width="40" height="40"/> 
</a>

<a href="https://www.postman.com/" target="_blank"> 
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg" alt="Postman" width="40" /> 
</a>

</div>

## Guia de implantação
Antes de iniciar o projeto, precisamos do [Docker](https://www.docker.com/) e [Git](https://git-scm.com/) instalados em nossas máquinas.
Tendo o git instlado, rode o seguinte comando no terminal da sua máquina:
``` bash
git clone https://github.com/LucasFrancoBN/gerenciador-estoque.git
```

Após isso, rode o comando para compilar as classes necessárias:
```bash
mvn clean compile
```
Agora basta iniciar o projeto em sua IDE.


## Exemplos de requests
Buscar usuário por id
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
               xmlns:us="http://example.com/soap/users">
    <soap:Body>
        <us:getUserRequest>
            <us:id>1</us:id>
        </us:getUserRequest>
    </soap:Body>
</soap:Envelope>
```

Criar usuário
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:usr="http://example.com/soap/users">
    <soapenv:Header/>
    <soapenv:Body>
        <usr:createUserRequest>
            <usr:createUser>
                <usr:name>Lucas Silva</usr:name>
                <usr:email>lucas.silva@exemplo.com</usr:email>
                <usr:cep>01001-000</usr:cep>
            </usr:createUser>
        </usr:createUserRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

Atualizar usuário
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:usr="http://example.com/soap/users">
    <soapenv:Header/>
    <soapenv:Body>
        <usr:updateUserRequest>
            <usr:updateUser>
                <usr:id>1</usr:id>
                <usr:name>João Silva Atualizado</usr:name>
                <usr:email>joao.atualizado@exemplo.com</usr:email>
            </usr:updateUser>
        </usr:updateUserRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

Deletar usuário
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:usr="http://example.com/soap/users">
    <soapenv:Header/>
    <soapenv:Body>
        <usr:deleteUserRequest>
            <usr:id>1</usr:id>
        </usr:deleteUserRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

## Desenvolvedores
<table align="center">
  <tr>
    <td align="center">
      <div>
        <img src="https://avatars.githubusercontent.com/LucasFrancoBN" width="120px;" alt="Foto no GitHub" class="profile"/><br>
          <b> Lucas Franco   </b><br>
            <a href="https://www.linkedin.com/in/lucas-franco-barbosa-navarro-a51937221/" alt="Linkedin"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" height="20"></a>
            <a href="https://github.com/LucasFrancoBN" alt="Github"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" height="20"></a>
      </div>
    </td>
  </tr>
</table>
