package Seeds;

class PessoaFisica extends Usuario {
    private String cpf;

    public PessoaFisica(String usuario, String senha, String nome, String endereco, String cpf) {
        super(usuario, senha, nome, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
