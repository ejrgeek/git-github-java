package funcionario;

import java.time.LocalDate;
import java.util.UUID;

public class FuncionarioModel {

    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate criadoEm;
    private boolean estaLogado;

    public FuncionarioModel(String nome, String email, String senha){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.criadoEm = LocalDate.now();
    }


}
