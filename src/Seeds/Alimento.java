package Seeds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

	public class Alimento {
	
	    private static List<Alimento> alimentosDoados = new ArrayList<>();
	
	    private String usuarioDoacao;
	    private String nomeAlimento;
	    private String quantidadeAlimento;
	    private String validadeAlimento;
	    private String armazenamentoAlimento;
	    private boolean aceito;



	    public Alimento(String nomeAlimento, String quantidadeAlimento, String validadeAlimento, String armazenamentoAlimento, String usuarioDoacao) {
	        this.nomeAlimento = nomeAlimento;
	        this.quantidadeAlimento = quantidadeAlimento;
	        this.validadeAlimento = validadeAlimento;
	        this.armazenamentoAlimento = armazenamentoAlimento;
	        this.usuarioDoacao = usuarioDoacao;
	    }
	    
	    public String getUsuarioDoacao() {
	        return usuarioDoacao;

	    }
	    
	    public void setUsuarioDoacao(String usuarioDoacao) {
	        this.usuarioDoacao = usuarioDoacao;
	    }

	    public void cadastrarAlimento(Alimento alimento, String usuarioDoacao) {
	        alimento.setUsuarioDoacao(usuarioDoacao);
	        alimentosDoados.add(alimento);
	        System.out.println("Item cadastrado com sucesso!\n");
	    }

	  
	    public String getNomeAlimento() {
	        return nomeAlimento;
	    }

	    public String getQuantidadeAlimento() {
	        return quantidadeAlimento;
	    }
	    
	    public String getValidadeAlimento() {
	        return validadeAlimento;
	    }
	    
	    public String getArmazenamentoAlimento() {
	        return armazenamentoAlimento;
	    }
	    
	    public void exibirAlimentosDoados() {
	        if (alimentosDoados.isEmpty()) {
	            System.out.println("\nNenhum alimento foi doado ainda.\n");
	        } else {
	            System.out.println("Lista de alimentos doados:");
	            for (Alimento alimento : alimentosDoados) {
	                System.out.println("\nItem: " + alimento.getNomeAlimento());
	                System.out.println("Quantidade: " + alimento.getQuantidadeAlimento());
	                System.out.println("Validade: " + alimento.getValidadeAlimento());
	                System.out.println("É perecível?: " + alimento.getArmazenamentoAlimento());
	            }
	        }
	    }

	    
	    public static void exibirAlimentosDoUsuario(String usuario) {
	        boolean encontrou = false;
	        for (Alimento alimento : alimentosDoados) {
	            if (alimento.getUsuarioDoacao().equals(usuario)) {
	                encontrou = true;
	                System.out.println("\nItem: " + alimento.getNomeAlimento());
	                System.out.println("Quantidade: " + alimento.getQuantidadeAlimento());
	                System.out.println("Validade: " + alimento.getValidadeAlimento());
	                System.out.println("É perecível?: " + alimento.getArmazenamentoAlimento());
	            }
	        }
	        if (!encontrou) {
	            System.out.println("\nVocê ainda não cadastrou nenhum item.\n");
	        }
	    }

	    public void excluirAlimento(String nomeAlimento) {
	        Iterator<Alimento> iterator = alimentosDoados.iterator();
	        while (iterator.hasNext()) {
	            Alimento alimento = iterator.next();
	            if (alimento.getNomeAlimento().equals(nomeAlimento)) {
	                iterator.remove();
	                System.out.println("Item excluído com sucesso!\n");
	                return;
	            }
	        }
	        System.out.println("Item não encontrado.\n");
	    }
	    
	    public boolean aceitarItemDoado(String nomeItem) {
	        Iterator<Alimento> iterator = alimentosDoados.iterator();
	        while (iterator.hasNext()) {
	            Alimento alimento = iterator.next();
	            if (alimento.getNomeAlimento().equals(nomeItem)) {
	                alimento.setAceito(true);
	                iterator.remove();
	                return true;
	            }
	        }
	        return false;
	    }


	    public boolean isAceito() {
	        return aceito;
	    }

	    public void setAceito(boolean aceito) {
	        this.aceito = aceito;
	    }

	    public void exibirItensAceitos() {
	        boolean encontrou = false;
	        for (Alimento alimento : alimentosDoados) {
	            if (alimento.isAceito()) {
	                encontrou = true;
	                System.out.println("\nItem: " + alimento.getNomeAlimento());
	                System.out.println("Quantidade: " + alimento.getQuantidadeAlimento());
	                System.out.println("Validade: " + alimento.getValidadeAlimento());
	                System.out.println("É perecível?: " + alimento.getArmazenamentoAlimento());
	            }
	        }
	        if (!encontrou) {
	            System.out.println("\nNenhum item foi aceito.\n");
	        }
	    }
	    
	    public static List<Alimento> getAlimentosDoados() {
	        return alimentosDoados;
	    }


}

