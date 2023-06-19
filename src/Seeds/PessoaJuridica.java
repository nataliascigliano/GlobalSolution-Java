package Seeds;

class PessoaJuridica extends Usuario {
    private String cnpj;

    public PessoaJuridica(String usuario, String senha, String nome, String endereco, String cnpj) {
        super(usuario, senha, nome, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}
