package funcionario;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        this.senha = codificarSenha(senha);
        this.criadoEm = LocalDate.now();
    }

    static private String codificarSenha(String senha){
        String senhaCodificada;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(senha.getBytes(StandardCharsets.UTF_8));

            BigInteger representanteNumerico = new BigInteger(1, digest);

            senhaCodificada = representanteNumerico.toString(16);

            while (senhaCodificada.length() < 32){
                senhaCodificada = String.format("0%s", senhaCodificada);
            }
            return senhaCodificada;
        } catch (NoSuchAlgorithmException e){
            return null;
        }
    }

    protected UUID getId() {
        return id;
    }

    protected String getNome() {
        return nome;
    }

    protected String getEmail() {
        return email;
    }

    protected boolean isEstaLogado() {
        return estaLogado;
    }

    protected LocalDate getCriadoEm() {
        return criadoEm;
    }

    protected void logarDeslogar() {
        this.estaLogado = !this.estaLogado;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", criadoEm=" + criadoEm +
                ", estaLogado=" + estaLogado +
                '}';
    }



}
