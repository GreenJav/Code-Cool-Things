public class Funcionario {
    private String nome;
    private String sobrenome;
    private String[] endereco = new String[3];
    private int idade;
    private char sexo;
    private String cpf;
    private String email;
    private String telefone;

    // construtor padrão
    public Funcionario(String nome, String sobrenome, String[] endereco, int idade, char sexo, String cpf, String email, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public Funcionario() { //construtor genérico
    }

    //getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String[] getEndereco() {
        return endereco;
    }

    public void setEndereco(String estado, String cidade, String bairro) {
        this.endereco[0] = estado;
        this.endereco[1] = cidade;
        this.endereco[2] = bairro;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}