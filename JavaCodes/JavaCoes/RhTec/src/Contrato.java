import java.util.UUID;

public class Contrato {
    private Funcionario funcionario;
    private Setores setor;
    private UUID id;
    private int salario; //salário do funcionário guardado em centavos, para evitar erros de arredondamento
    private String cargo;

    public Contrato(Funcionario funcionario, Setores setor, int salario, String cargo) { // construtor padrão
        this.funcionario = funcionario;
        this.setor = setor;
        this.id = UUID.randomUUID();
        this.salario = salario;
        this.cargo = cargo;
    }

    public Contrato() { //construtor genérico para inicialização de variáveis

    }

    //getters e setters

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Setores getSetor() {
        return setor;
    }

    public void setSetor(Setores setor) {
        this.setor = setor;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void newId() {
        this.id = UUID.randomUUID();
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}