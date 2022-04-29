package Objecto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Aluno implements Serializable 
{
    private String nome, apelido, nacionalidade, sexo;
    private UUID id;

    public Aluno(String nome, String apelido, String nacionalidade, String sexo) {
        this.nome = nome;
        this.apelido = apelido;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
        this.id = UUID.randomUUID();
    }
    
    public Aluno() {
        this.id = UUID.randomUUID();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}