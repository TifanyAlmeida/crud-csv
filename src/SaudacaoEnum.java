public enum SaudacaoEnum {
    Empresa("\n\n|||||||||||||||||||| EMPRESA X ||||||||||||||||||||\n\n"),
    Saida("||||||||||||||||||||| ATÉ LOGO ||||||||||||||||||||");

    private final String msg;

    SaudacaoEnum(String msg){
        this.msg = msg;
    }public String getMsg(){
        return msg;
    }
}
