import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Empresa {
    private String nome;
    private String[] endereco;
    private String telefone;
    private String cnpj;
    private String email;
    private String dono;
    private ArrayList<Contrato> listaContratos = new ArrayList<Contrato>();

    //construtor padrão
    public Empresa(String nome, String[] endereco, String telefone, String cnpj, String email, String dono, ArrayList<Contrato> listaContratos) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.email = email;
        this.dono = dono;
        this.listaContratos = listaContratos;
    }

    //construtor genérico
    public Empresa() {
    }
    //Getters
    public String getNome() {
        return nome;
    }

    public String[] getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getDono() {
        return dono;
    }

    public ArrayList<Contrato> getListaContratos() {
        return listaContratos;
    }
    //setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String[] endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public void setListaContratos(ArrayList<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }

    //pede os dados do funcionário para o usuário do sistema, instancia Funcionario e Contrato e depois adiciona na lista de contratos
    public void funcionarioNovo() {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem vind@ ao assistente de cadastro de funcionário");
        System.out.println("Insira o nome do funcionário a ser cadastrado");
        String[] nome = new String[2];
        nome[0] = input.nextLine();

        System.out.println("Insira o sobrenome do funcionário a ser cadastrado");
        nome[1] = input.nextLine();

        System.out.println("Insira o estado o funcionário mora");
        String[] endereco = new String[3];
        endereco[0] = input.nextLine();
        System.out.println("Insira a cidade o funcionário mora");
        endereco[1] = input.nextLine();
        System.out.println("Insira o bairro o funcionário mora");
        endereco[2] = input.nextLine();

        System.out.println("Insira a idade do funcionário");
        int idade;
        while (true) { // uso de loops while(true) para receber inputs até que um input válido seja recebido
            idade = Integer.parseInt(input.nextLine());
            if (idade >= 18 && idade < 100) {
                break;
            } else {
                System.out.println("Valor inválido, insira novamente");
            }
        }

        System.out.println("Insira o sexo do funcionário (M/F)");
        String sexo;
        while (true) {
            sexo = input.nextLine().toUpperCase(Locale.ROOT);
            if (sexo.equals("F") || sexo.equals("M")) {
                break;
            } else {
                System.out.println("Valor inválido, insira novamente");
            }
        }

        System.out.println("Insira o cpf do funcionário (somente números)");
        String cpf;
        while (true) {
            cpf = input.nextLine();
            if (cpf.length() == 11 && cpf.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("Cpf inválido, digite 11 números");
            }
        }

        System.out.println("Insira o email do funcionário");
        String email = input.nextLine();

        System.out.println("Insira o telefone do funcionário (somente números)");
        String telefone;
        while (true) {
            telefone = input.nextLine();
            if (telefone.length() == 11 && telefone.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("Telefone inválido, digite 11 números");
            }
        }

        Funcionario funcionario = new Funcionario(nome[0], nome[1], endereco, idade, sexo.charAt(0), cpf, email, telefone);

        System.out.println("Insira o setor do funcionário\n1. ADMINISTRATIVO\n2. COMERCIAL\n3. FINANCEIRO\n4. RH\n5. OPERACIONAL");
        Setores setor = null; // para evitar erro de runtime

        while(true) {
            int escolha = Integer.parseInt(input.nextLine());
            switch (escolha) {
                case 1:
                    setor = Setores.ADMINISTRATIVO;
                    break;

                case 2:
                    setor = Setores.COMERCIAL;
                    break;

                case 3:
                    setor = Setores.FINANCEIRO;
                    break;

                case 4:
                    setor = Setores.RH;
                    break;

                case 5:
                    setor = Setores.OPERACIONAL;
                    break;

                default:
                    System.out.println("Setor inválido, selecione novamente");
            }

            if (setor != null) {
                break;
            }
        }

        System.out.println("Digite o salário do funcionário");
        double salario = Double.parseDouble(input.nextLine());

        System.out.println("Escolha o cargo do funcionário:\n1. Colaborador\n2. Chefe");
        int escolha;
        String cargo;
        while (true) {
            escolha = Integer.parseInt(input.nextLine());

            if (escolha == 2) {
                boolean valido = true;
                for (Contrato c : this.listaContratos) {
                    if (c.getSetor().equals(setor) && c.getCargo().equals("Chefe")) {
                        valido = false;
                        break;
                    }
                }

                if (valido) {
                    cargo = "Chefe";
                    break;
                } else {
                    System.out.println("Cargo inválido, ja existe um chefe neste setor");
                }

            } else if (escolha == 1) {
                cargo = "Colaborador";
                break;
            } else {
                System.out.println("Opção invalida, escolha novamente");
            }
        }

        Contrato contrato = new Contrato(funcionario, setor, (int) salario*100, cargo);
        this.listaContratos.add(contrato);
    }

    //similar à funcionarioNovo(), porém com a opção de escolher quais dados atualizar
    public void funcionarioAtualiza(String cpf) {
        Scanner input = new Scanner(System.in);
        Contrato contrato = new Contrato();

        for (Contrato c : this.listaContratos) {
            if (c.getFuncionario().getCpf().equals(cpf)) {
                contrato = c;
            }
        }

        if (contrato.equals(new Contrato())) {
            System.out.println("Funcionário não encontrado");
        } else {
            while (true) {
                System.out.println("Escolha o dado a ser atualizado: ");
                System.out.println("1. Nome e sobrenome");
                System.out.println("2. Endereço");
                System.out.println("3. Idade");
                System.out.println("4. Sexo");
                System.out.println("5. Cpf");
                System.out.println("6. Email");
                System.out.println("7. Telefone");
                System.out.println("8. Setor");
                System.out.println("9. Salário");
                System.out.println("10. Cargo");
                System.out.println("11. Sair");

                int escolha = Integer.parseInt(input.nextLine());

                switch (escolha) {
                    case 1:
                        System.out.println("Insira o nome atualizado do funcionário");
                        contrato.getFuncionario().setNome(input.nextLine());
                        System.out.println("Insira o sobrenome atualizado do funcionário");
                        contrato.getFuncionario().setSobrenome(input.nextLine());
                        break;

                    case 2:
                        String[] endereco = new String[3];
                        System.out.println("Insira o estado onde o funcionário mora");
                        endereco[0] = input.nextLine();
                        System.out.println("Insira a cidade onde o funcionário mora");
                        endereco[1] = input.nextLine();
                        System.out.println("Insira o bairro onde o funcionário mora");
                        endereco[2] = input.nextLine();
                        contrato.getFuncionario().setEndereco(endereco[0], endereco[1], endereco[2]);
                        break;

                    case 3:
                        System.out.println("Insira a idade do funcionário");
                        int idade = Integer.parseInt(input.nextLine());
                        if (idade > 18 && idade < 100) {
                            contrato.getFuncionario().setIdade(idade);
                        } else {
                            System.out.println("Idade invalida, tente novamente");
                        }
                        break;

                    case 4:
                        System.out.println("Insira o sexo do funcionário (M ou F)");
                        String sexo = input.nextLine().toUpperCase(Locale.ROOT);
                        if (sexo.equals("F") || sexo.equals("M")) {
                            contrato.getFuncionario().setSexo(sexo.charAt(0));
                        } else {
                            System.out.println("Sexo invalido, tente novamente");
                        }
                        break;

                    case 5:
                        System.out.println("Insira o cpf do funcionário (11 números)");
                        String newCpf = input.nextLine();
                        if (newCpf.matches("[0-9]+") && newCpf.length() == 11) {
                            contrato.getFuncionario().setCpf(newCpf);
                        } else {
                            System.out.println("Cpf invalido, tente novamente");
                        }
                        break;

                    case 6:
                        System.out.println("Insira o email do funcionario");
                        contrato.getFuncionario().setEmail(input.nextLine());
                        break;

                    case 7:
                        System.out.println("Insira o telefone do funcionário (11 números)");
                        String telefone = input.nextLine();
                        if (telefone.matches("[0-9]+") && telefone.length() == 11) {
                            contrato.getFuncionario().setTelefone(telefone);
                        } else {
                            System.out.println("Telefone invalido, tente novamente");
                        }
                        break;

                    case 8:
                        System.out.println("Insira o setor do funcionário\n1. ADMINISTRATIVO\n2. COMERCIAL\n3. FINANCEIRO\n4. RH\n5. OPERACIONAL");
                        int setor = Integer.parseInt(input.nextLine());
                        switch (setor) {
                            case 1:
                                contrato.setSetor(Setores.ADMINISTRATIVO);
                                break;

                            case 2:
                                contrato.setSetor(Setores.COMERCIAL);
                                break;

                            case 3:
                                contrato.setSetor(Setores.FINANCEIRO);
                                break;

                            case 4:
                                contrato.setSetor(Setores.RH);
                                break;

                            case 5:
                                contrato.setSetor(Setores.OPERACIONAL);
                                break;

                            default:
                                System.out.println("Setor inválido, selecione novamente");
                        }

                    case 9:
                        System.out.println("Insira o salário do funcionário");
                        int salario = (int) Double.parseDouble(input.nextLine());
                        salario = salario * 100;
                        contrato.setSalario(salario);
                        break;

                    case 10:
                        System.out.println("Escolha o cargo do funcionário:\n1. Colaborador\n2. Chefe");
                        int cargo = Integer.parseInt(input.nextLine());
                        String novoCargo;

                        if (cargo == 2) {
                            boolean valido = true;
                            for (Contrato c : this.listaContratos) {
                                if (c.getSetor().equals(contrato.getSetor()) && c.getCargo().equals("Chefe")) {
                                    valido = false;
                                    break;
                                }
                            }

                            if (valido) {
                                contrato.setCargo("Chefe");
                            } else {
                                System.out.println("Cargo inválido, ja existe um chefe neste setor");
                            }

                        } else if (cargo == 1) {
                            contrato.setCargo("Colaborador");
                        } else {
                            System.out.println("Opção invalida, escolha novamente");
                        }

                        break;

                    case 11:
                        return; //sai do metodo com return pois break faz parte da sintaxe do switch-case

                    default:
                        System.out.println("Opção invalida, escolha novamente\n");
                }
            }
        }
    }

    //lista todos os funcionários da empresa
    public void funcionarioLista() {
        for (Contrato contrato : this.listaContratos) {
            this.funcionarioImprime(contrato);
        }
    }

    //lista todos os funcionários do setor que recebe
    public void funcionarioLista(Setores setor) {
        for (Contrato contrato : this.listaContratos) {
            if (contrato.getSetor().equals(setor)) {
                this.funcionarioImprime(contrato);
            }
        }
    }

    //lista todos os funcionários do sexo que recebe
    public void funcionarioLista(char sexo) {
        for (Contrato contrato : this.listaContratos) {
            if (contrato.getFuncionario().getSexo() == sexo) {
                this.funcionarioImprime(contrato);
            }
        }
    }

    //lista todos os funcionários do estado que recebe
    public void funcionarioLista(String estado) {
        for (Contrato contrato : this.listaContratos) {
            if (contrato.getFuncionario().getEndereco()[0].equals(estado)) {
                this.funcionarioImprime(contrato);
            }
        }
    }

    //identifica o funcionário com menor e maior salário e os retorna num array Contrato[2]
    public Contrato[] funcionarioIdentifica() {
        Contrato menorSalario = new Contrato();
        Contrato maiorSalario = new Contrato();
        menorSalario.setSalario(Integer.MAX_VALUE);
        maiorSalario.setSalario(-1);
        for (Contrato c : this.listaContratos) {
            if (c.getSalario() < menorSalario.getSalario()) {
                menorSalario = c;
            }

            if (c.getSalario() > maiorSalario.getSalario()) {
                maiorSalario = c;
            }
        }

        return new Contrato[]{menorSalario, maiorSalario};
    }

    //consulta um funcionário com base no nome ou no cpf
    public Contrato funcionarioConsulta(String termo) {
        Contrato resultado = new Contrato();

        if (termo.matches("[A-Za-z]+")) { //se o termo for alfabético, consulta por nome
            for (Contrato c : this.listaContratos) {
                if (c.getFuncionario().getNome().equals(termo)) {
                    resultado = c;
                }
            }
        } else if (termo.matches("[0-9]+")) { //se for numérico, consulta por cpf
            for (Contrato c : this.listaContratos) {
                if (c.getFuncionario().getCpf().equals(termo)) {
                    resultado = c;
                }
            }
        }

        return resultado;
    }

    //demite um funcionário dado seu cpf
    public void cpfDemitir(String cpf) {
        Contrato aDemitir = funcionarioConsulta(cpf);

        if (aDemitir.equals(new Contrato())) {
            System.out.println("Funcionário não encontrado");
        } else {
            this.listaContratos.remove(aDemitir);
        }
    }

    //identifica qual setores tem menos e mais funcionários, imprime o salário total dos setores
    public void setorIdentifica() {
        int[] numFuncionarios = {0, 0, 0, 0, 0}; // [0]: administrativo, [1]: comercial, [2]: financeiro, [3]: rh, [4]: operacional

        for (Contrato c : this.listaContratos) {
            switch (c.getSetor()) {
                case ADMINISTRATIVO:
                    numFuncionarios[0]++;
                    break;

                case COMERCIAL:
                    numFuncionarios[1]++;
                    break;

                case FINANCEIRO:
                    numFuncionarios[2]++;
                    break;

                case RH:
                    numFuncionarios[3]++;
                    break;

                case OPERACIONAL:
                    numFuncionarios[4]++;
                    break;
            }
        }

        int menor = Integer.MAX_VALUE;
        int maior = -1;
        int menorIndex = -1;
        int maiorIndex = 5;

        for (int i = 0; i < numFuncionarios.length; i++) {
            if (numFuncionarios[i] > maior) {
                maior = numFuncionarios[i];
                maiorIndex = i;
            }

            if (numFuncionarios[i] < menor) {
                menor = numFuncionarios[i];
                menorIndex = i;
            }
        }

        System.out.print("Departamento com maior número de funcionários: ");
        switch (menorIndex) {
            case 0:
                System.out.printf("Administrativo\nNúmero de funcionários: %d\n", menor);
                break;

            case 1:
                System.out.printf("Comercial\nNúmero de funcionários: %d\n", menor);
                break;

            case 2:
                System.out.printf("Financeiro\nNúmero de funcionários: %d\n", menor);
                break;

            case 3:
                System.out.printf("Rh\nNúmero de funcionários: %d\n", menor);
                break;

            case 4:
                System.out.printf("Operacional\nNúmero de funcionários: %d\n", menor);
                break;
        }

        System.out.print("Departamento com maior numero de funcionários: ");
        switch (maiorIndex) {
            case 0:
                System.out.printf("Administrativo\nNúmero de funcionários: %d\n", maior);
                break;

            case 1:
                System.out.printf("Comercial\nNúmero de funcionários: %d\n", maior);
                break;

            case 2:
                System.out.printf("Financeiro\nNúmero de funcionários: %d\n", maior);
                break;

            case 3:
                System.out.printf("Rh\nNúmero de funcionários: %d\n", maior);
                break;

            case 4:
                System.out.printf("Operacional\nNúmero de funcionários: %d\n", maior);
                break;
        }
    }

    //imprime todos os dados do funcionário recebido
    public void funcionarioImprime(Contrato contrato) {
        System.out.printf("Nome: %s %s\n", contrato.getFuncionario().getNome(), contrato.getFuncionario().getSobrenome());
        System.out.printf("Cpf: %s\n", contrato.getFuncionario().getCpf());
        System.out.printf("Idade: %d\n", contrato.getFuncionario().getIdade());
        System.out.printf("Sexo: %c\n", contrato.getFuncionario().getSexo());
        System.out.printf("Endereço: %s, %s, %s\n", contrato.getFuncionario().getEndereco()[0], contrato.getFuncionario().getEndereco()[1], contrato.getFuncionario().getEndereco()[2]);
        System.out.printf("Telefone: %s\n", contrato.getFuncionario().getTelefone());
        System.out.printf("Email: %s\n", contrato.getFuncionario().getEmail());
        System.out.printf("Id: %s\n", contrato.getId());
        System.out.printf("Setor: %s\n", contrato.getSetor().getSetor());
        System.out.printf("Salário: R$%.2f\n", (double) contrato.getSalario()/100);
        System.out.printf("Cargo: %s\n\n", contrato.getCargo());
    }

    //consulta um setor baseado na escolha do usuário, imprime o nome, salário total e médio, chefe do setor e numero de funcionários
    public void setorConsulta() {
        Scanner input = new Scanner(System.in);
        Setores setorEscolhido = null;

        System.out.println("Escolha o setor a ser consultado\n1. ADMINISTRATIVO\n2. COMERCIAL\n3. FINANCEIRO\n4. RH\n5. OPERACIONAL");
        int escolha;

        while (true) {
            escolha = Integer.parseInt(input.nextLine());

            switch (escolha) {
                case 1:
                    setorEscolhido = Setores.ADMINISTRATIVO;
                    break;

                case 2:
                    setorEscolhido = Setores.COMERCIAL;
                    break;

                case 3:
                    setorEscolhido = Setores.FINANCEIRO;
                    break;

                case 4:
                    setorEscolhido = Setores.RH;
                    break;

                case 5:
                    setorEscolhido = Setores.OPERACIONAL;
                    break;

                default:
                    System.out.println("Setor inválido, escolha novamente");
            }

            if (setorEscolhido != null) {
                break;
            }
        }

        int numFunc = 0;
        int salarioTotal = 0;
        Contrato chefe = new Contrato();

        for (Contrato c : this.listaContratos) { //procura o chefe do setor enquanto conta o número de funcionários
            if (c.getSetor().equals(setorEscolhido)) {
                numFunc++;
                salarioTotal += c.getSalario();

                if (c.getCargo().equals("Chefe")) {
                    chefe = c;
                }
            }
        }

        Funcionario ch = chefe.getFuncionario();

        System.out.printf("Setor: %s\n", setorEscolhido.getSetor());
        System.out.printf("Número de funcionários: %d\n", numFunc);
        System.out.printf("Salário total: R$%.2f\n", (double) salarioTotal/100);
        System.out.printf("Média de salário no setor: R$%.2f\n", (double) (salarioTotal/100)/numFunc);
        System.out.printf("Chefe do setor: %s %s\n", ch.getNome(), ch.getSobrenome());
        

    }

    public void funcionarioNovo(Contrato contrato) {
        this.listaContratos.add(contrato);
    }
}