public enum Setores { // enumareador usado como controle do setor de cada contrato
    ADMINISTRATIVO("Administrativo"),
    COMERCIAL("Comercial"),
    FINANCEIRO("Financeiro"),
    RH("Rh"),
    OPERACIONAL("Operacional");

    private final String setor; // "conversao" de tipo Setores pra String

    Setores(String setor) { // construtor padrão
        this.setor = setor;
    }

    //getter

    public String getSetor() {
        return this.setor;
    }
}