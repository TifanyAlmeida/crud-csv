public enum MenuEnum {

    CADASTRAR(1), ALTERAR(2), REMOVER(3), VIZUALIZAR(4), LOGOUT(5), SAIR(6);

    private final int opcoesMenuEnum;

    MenuEnum(int opcoesMenuEnum){
        this.opcoesMenuEnum = opcoesMenuEnum;
    }
    public int getValue(){
        return opcoesMenuEnum;
    }
}
