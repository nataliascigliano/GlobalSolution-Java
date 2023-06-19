package Seeds;

public class Usuario {
	    private String usuario;
	    private String senha;
	    private String nome;
	    private String endereco;


	    public Usuario(String usuario, String senha, String nome, String endereco) {
	        this.usuario = usuario;
	        this.senha = senha;
	        this.setNome(nome);
	        this.endereco = endereco;
	    }

	    public String getUsuario() {
	        return usuario;
	    }

	    public String getSenha() {
	        return senha;
	    }

		public String getNome() {
			return nome;
		}

		public String getEndereco() {
			return endereco;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
	}


