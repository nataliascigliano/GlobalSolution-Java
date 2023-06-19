package Seeds;

import java.util.ArrayList;
import java.util.List;

class CadastroLogin {
    private List<Usuario> usuarios;

    public CadastroLogin() {
        usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!\n");
        
        if (usuario instanceof PessoaFisica) {
            PessoaFisica pessoaFisica = (PessoaFisica) usuario;
        } else if (usuario instanceof PessoaJuridica) {
            PessoaJuridica pessoaJuridica = (PessoaJuridica) usuario;
        }
    }

    public boolean realizarLogin(String nome, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(nome) && usuario.getSenha().equals(senha)) {
                System.out.println("\nLogin bem-sucedido! Bem-vindo, " + nome + "!");
                return true;
            }
        }
        System.out.println("Nome de usuário ou senha incorretos. Tente novamente.\n");
        return false;
    }

	public String obterTipoUsuario(String nome) {
	    for (Usuario usuario : usuarios) {
	        if (usuario.getUsuario().equals(nome)) {
	            if (usuario instanceof PessoaFisica) {
	                return "Pessoa Física";
	            } else if (usuario instanceof PessoaJuridica) {
	                return "Pessoa Jurídica";
	            } else if (usuario instanceof Ong) {
	                return "ONG";
	            }
	        }
	    }
	    return null;
	}
	
	public void exibirUsuarios() {
	    System.out.println("Lista de usuários cadastrados:");
	    for (Usuario usuario : usuarios) {
	        System.out.println(usuario.getUsuario());
	    }
	}
	
	public void exibirOngsCadastradas() {
	    System.out.println("\nLista de ONGs cadastradas:");
	    for (Usuario usuario : usuarios) {
	        if (usuario instanceof Ong) {
	            Ong ong = (Ong) usuario;
	            System.out.println("Nome: " + ong.getNome());
	            System.out.println("Endereço: " + ong.getEndereco());
	            System.out.println("Telefone: " + ong.getTelefone());
	            System.out.println("Email: " + ong.getEmail());
	            System.out.println();
	        }
	    }
	}

	
    
}
