import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;

public class Main {


    //o menu geral chama dois outros menus (funcionários e setores) de acordo com a escolha do usuário
    private static void menuGeral(Empresa empresa) {

        Scanner scn = new Scanner(System.in);
        int opc;
        String voltar;
        boolean sair = false;


        while(!sair) {

            System.out.println("Escolha sua opção:");
            System.out.println("1 - Acessar Menu de Funcionários");
            System.out.println("2 - Acessar Menu de Setores");
            System.out.println("3 - Sair");

            System.out.printf("%nSua escolha: ");
            opc = Integer.parseInt(scn.nextLine());

            switch (opc) {
                case 1:
                    menuFuncionarios(empresa);


                    System.out.println("\nDeseja voltar ao menu principal? (S/N)");
                    
                    while (true) {
                        voltar = scn.nextLine().toUpperCase(Locale.ROOT);
                        if (voltar.equals("S")) {
                            break;
                        }else if(voltar.equals("N")){
                            sair = true;
                            break;
                        } else {
                            System.out.println("Valor inválido, insira novamente");
                        }
                    }
                    break;

                case 2:
                    menuSetores(empresa);


                    System.out.println("\nDeseja voltar ao menu principal? (S/N)");
                    
                    while (true) {
                        voltar = scn.nextLine().toUpperCase(Locale.ROOT);
                        if (voltar.equals("S")) {
                            break;
                        }else if(voltar.equals("N")){
                            sair = true;
                            break;
                        } else {
                            System.out.println("Valor inválido, insira novamente");
                        }
                    }
                    
                    break;

                case 3:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida, selecione novamente\n");
            }


        }
        
    }

    //contém as opções para funcionários como contratar, demitir, etc.
    private static void menuFuncionarios(Empresa empresa) {
        Scanner sc = new Scanner(System.in);
        int opc;
        String termo, cpf;

    
        System.out.println("\n\nEscolha sua opção:");
        System.out.println("1 - Cadastrar um novo funcionário");
        System.out.println("2 - Consultar dados de um funcionário");
        System.out.println("3 - Atualizar dados de um funcionário");
        System.out.println("4 - Demitir um funcionário");
        System.out.println("5 - Mostrar lista de funcionários");
        System.out.println("6 - Mostrar os funcionários com o maior e o menor salário");
        
        System.out.printf("%nSua escolha: ");
        opc = Integer.parseInt(sc.nextLine());
        System.out.println("\n");

        switch (opc) {
            case 1:
                empresa.funcionarioNovo();
                break;

            case 2:
                System.out.println("Digite o nome ou cpf do funcionário que deseja consultar.");
                termo = sc.nextLine();
                Contrato contr = empresa.funcionarioConsulta(termo);

                System.out.println();


                if (contr == new Contrato()){
                    System.out.println("Funcionário não encontrado");
                }else{
                    empresa.funcionarioImprime(contr);
                }

                break;

            case 3:
                System.out.println("Digite o cpf do funcionário que deseja atualizar.");
                cpf = sc.nextLine();
                System.out.println();
                empresa.funcionarioAtualiza(cpf);
                break;

            case 4:
                System.out.println("Digite o cpf do funcionário que deseja demitir.");
                cpf = sc.nextLine();
                empresa.cpfDemitir(cpf);
                break;

            case 5:
                menuLista(empresa);
                break;
            
            case 6:
                Contrato[] MenorMaior = empresa.funcionarioIdentifica();
                System.out.println("Funcionário com menor salário:");
                empresa.funcionarioImprime(MenorMaior[0]);

                System.out.println("\nFuncionário com maior salário:");
                empresa.funcionarioImprime(MenorMaior[1]);
                break;

            default:
                System.out.println("Opção inválida");
        }

    }

    //é chamado pelo menu de Funcionários
    //serve para vizualizar a lista geral de funcioários ou as listas por sexo, estado ou setor
    private static void menuLista(Empresa empresa){
        Scanner sc = new Scanner(System.in);
        int opc;
        boolean valido = true;


        do{

            System.out.println("Escolha sua opção:");
            System.out.println("1 - Mostrar lista de todos os funcionários");
            System.out.println("2 - Mostrar lista de funcionários por estado");
            System.out.println("3 - Mostrar lista de funcionários por setor");
            System.out.println("4 - Mostrar lista de funcionários por sexo");


            System.out.printf("%nSua escolha: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    empresa.funcionarioLista();
                    break;

                case 2:
                    System.out.println("Insira o estado");
                    String estado = new String();
                    estado = sc.nextLine();
                    
                    empresa.funcionarioLista(estado);
                    break;

                case 3:

                    System.out.println("Insira o setor\n1. ADMINISTRATIVO\n2. COMERCIAL\n3. FINANCEIRO\n4. RH\n5. OPERACIONAL");
                    Setores setor = null; // para evitar erro de runtime
            
                    while(true) {
                        int escolha = Integer.parseInt(sc.nextLine());
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

                    empresa.funcionarioLista(setor);
                    break;

                case 4:

                    System.out.println("Insira o sexo (M/F)");
                    String sexo;
                    while (true) {
                        sexo = sc.nextLine().toUpperCase(Locale.ROOT);
                        if (sexo.equals("F") || sexo.equals("M")) {
                            break;
                        } else {
                            System.out.println("Valor inválido, insira novamente");
                        }
                    }
                    empresa.funcionarioLista(sexo);
                    break;

                default:
                    valido = false;
                    System.out.println("Opção inválida, selecione novamente\n");
            }


        }while(!valido);

    }

    //contém as ações para ver informações de setores
    private static void menuSetores(Empresa empresa) {
        
        Scanner sc = new Scanner(System.in);
        int opc;
    
        System.out.println("\n\nEscolha sua opção:");
        System.out.println("1 - Mostrar o setor com mais e o setor com menos funcionários");
        System.out.println("2 - Consultar informações de um setor");
        
        System.out.printf("%nSua escolha: ");
        opc = Integer.parseInt(sc.nextLine());
        System.out.println("\n");

        switch (opc) {
            case 1:
                empresa.setorIdentifica();
                break;

            case 2:
                empresa.setorConsulta();
                break;

            default:
                System.out.println("Opção inválida");
        }

    }


    public static void main(String[] args) {
        String[] enderecoEmp = {"Pará", "Belém", "Umarizal"};
        ArrayList<Contrato> listaContratos = new ArrayList<Contrato>();
        Empresa empresa = new Empresa("Empresa", enderecoEmp, "09199965222", "09203983777", "empresa@gmail.com", "João Alberto", listaContratos);
        
        //criação de indereços pra testes
        String[] teste1 = {"Pará", "Belém", "Umarizal"};
        String[] teste2 = {"Rio Janeiro", "Rio Janeiro", "Copacabana"};
        String[] teste3 = {"São Paulo", "São Paulo", "Jardins"};
        String[] teste4 = {"Pará", "Belém", "Marambaia"};
        String[] teste5 = {"Pará", "Belém", "Marco"};
        String[] teste6 = {"Pará", "Belém", "Guamá"};
        String[] teste7 = {"Pará", "Belém", "Cremação"};
        String[] teste8 = {"Pará", "Belém", "Pedreira"};
        String[] teste9 = {"Pará", "Belém", "Nazaré"};
        String[] teste10 = {"Pará", "Belém", "Reduto"};

        //criação de funcionários pra testes
        Funcionario teste1Func = new Funcionario("Albert", "Souza", teste1, 20, 'M', "03399288201", "asouza@gamail.com", "09198867673");
        Funcionario teste2Func = new Funcionario("Luciano", "Lima", teste2, 20, 'M', "54284839497", "llimao@gamail.com", "09198392989");
        Funcionario teste3Func = new Funcionario("Gabriel", "Sales", teste3, 20, 'M', "27483903006", "gsales@gamail.com", "09199999993");
        Funcionario teste4Func = new Funcionario("Lucas", "Oliveira", teste4, 20, 'M', "98948938499", "loliveira@gamail.com", "09192442473");
        Funcionario teste5Func = new Funcionario("Paulo", "Souza", teste5, 20, 'M', "73848878783", "psouza@gamail.com", "09198934984");
        Funcionario teste6Func = new Funcionario("Julia", "Ramos", teste6, 20, 'F', "66382782882", "jramos@gamail.com", "09198888883");
        Funcionario teste7Func = new Funcionario("Gabriely", "Santos", teste7, 20, 'F', "98398928393", "gsantosb@gamail.com", "09189928292");
        Funcionario teste8Func = new Funcionario("Bruna", "Rodrigues", teste8, 20, 'F', "74783478378", "brodrigues@gamail.com", "09199993333");
        Funcionario teste9Func = new Funcionario("Ana", "Ferreira", teste9, 20, 'F', "56233665211", "aferreira@gamail.com", "09198348378");
        Funcionario teste10Func = new Funcionario("Clara", "Alves", teste10, 20, 'F', "52899993-22", "calves@gamail.com", "09199383383");

        //criação de contratos pra testes
        Contrato teste1Cont = new Contrato(teste1Func, Setores.ADMINISTRATIVO, 1700000, "Chefe");
        Contrato teste2Cont = new Contrato(teste2Func, Setores.ADMINISTRATIVO, 200000, "Colaborador");
        Contrato teste3Cont = new Contrato(teste3Func, Setores.RH, 1200000, "Chefe");
        Contrato teste4Cont = new Contrato(teste4Func, Setores.RH, 170000, "Colaborador");
        Contrato teste5Cont = new Contrato(teste5Func, Setores.COMERCIAL, 2300000, "Chefe");
        Contrato teste6Cont = new Contrato(teste6Func, Setores.COMERCIAL, 100000, "Colaborador");
        Contrato teste7Cont = new Contrato(teste7Func, Setores.FINANCEIRO, 1500000, "Chefe");
        Contrato teste8Cont = new Contrato(teste8Func, Setores.FINANCEIRO, 120000, "Colaborador");
        Contrato teste9Cont = new Contrato(teste9Func, Setores.OPERACIONAL, 1900000, "Chefe");
        Contrato teste10Cont = new Contrato(teste10Func, Setores.OPERACIONAL, 130000, "Colaborador");


        //adicionar os contratos na lista de contratos da empresa
        empresa.funcionarioNovo(teste1Cont);
        empresa.funcionarioNovo(teste2Cont);
        empresa.funcionarioNovo(teste3Cont);
        empresa.funcionarioNovo(teste4Cont);
        empresa.funcionarioNovo(teste5Cont);
        empresa.funcionarioNovo(teste6Cont);
        empresa.funcionarioNovo(teste7Cont);
        empresa.funcionarioNovo(teste8Cont);
        empresa.funcionarioNovo(teste9Cont);
        empresa.funcionarioNovo(teste10Cont);




        menuGeral(empresa);

    }
}