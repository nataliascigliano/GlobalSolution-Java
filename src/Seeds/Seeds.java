package Seeds;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Seeds {
	
	public static void main(String[] args) {
        CadastroLogin cadastroLogin = new CadastroLogin();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Bem vindo ao SeedSupport, serviço de suporte virtual da SeedS!");
        boolean finalizar = false;
        boolean logado = false;
        String usuarioLogado = "";       
        Alimento alimento = new Alimento("", "", "", "", "");
        Ong ong = null;
        List<Alimento> alimentosDoados = new ArrayList<>();
        
        

        while (!finalizar) {
        	 if (!logado) {
				System.out.println("\nSelecione a opção desejada:\n1 - Cadastro\n2 - Login\n0 - Sair");
				
				int resposta = scanner.nextInt();
				scanner.nextLine(); 
			
	            switch (resposta) {
		            case 1:
		                System.out.println("\nAgradecemos o interesse em ajudar a causa!\nPara continuarmos, informe se você é:");
		                System.out.println("1 - Pessoa Física");
		                System.out.println("2 - Pessoa Jurídica");
		                System.out.println("3 - ONG");

		                int tipoUsuario = scanner.nextInt();
		                scanner.nextLine();
		                
			                switch (tipoUsuario) {
					            case 1:
			                        System.out.println("\nDigite o nome de usuário:");
			                        String usuarioPf = scanner.nextLine();
			                        System.out.println("Digite o seu nome completo:");
			                        String nomePf = scanner.nextLine();
			                        System.out.println("Digite o CPF:");
			                        String cpf = scanner.nextLine();
			                        System.out.println("Digite o seu endereço:");
			                        String enderecoPf = scanner.nextLine();
			                        System.out.println("Digite a senha:");
			                        String senhaPf = scanner.nextLine();
			                        PessoaFisica pessoaFisica = new PessoaFisica(usuarioPf, senhaPf, nomePf, enderecoPf, cpf);
			                        cadastroLogin.cadastrarUsuario(pessoaFisica);
			                        break;
			                        
					            case 2:
			                        System.out.println("\nDigite o nome de usuário:");
			                        String usuarioPj = scanner.nextLine();
			                        System.out.println("Digite o nome:");
			                        String nomePj = scanner.nextLine();
			                        System.out.println("Digite o CNPJ:");
			                        String cnpj = scanner.nextLine();
			                        System.out.println("Digite o endereço:");
			                        String enderecoPj = scanner.nextLine();
			                        System.out.println("Digite a senha:");
			                        String senhaPj = scanner.nextLine();
			                        PessoaJuridica pessoaJuridica = new PessoaJuridica(usuarioPj, senhaPj, nomePj, enderecoPj, cnpj);
			                        cadastroLogin.cadastrarUsuario(pessoaJuridica);
			                        break;

					            case 3:
			                        System.out.println("\nDigite o nome de usuário:");
			                        String usuarioOng = scanner.nextLine();
			                        System.out.println("Digite o nome da ONG:");
			                        String nomeOng = scanner.nextLine();
			                        System.out.println("Digite o endereço:");
			                        String enderecoOng = scanner.nextLine();
			                        System.out.println("Digite o telefone para contato:");
			                        String telefoneOng = scanner.nextLine();
			                        System.out.println("Digite o email para contato:");
			                        String emailOng = scanner.nextLine();
			                        System.out.println("Digite a senha:");
			                        String senhaOng = scanner.nextLine();
			                        Ong novaOng = new Ong(usuarioOng, senhaOng, nomeOng, enderecoOng, telefoneOng, emailOng);
			                        cadastroLogin.cadastrarUsuario(novaOng);
			                        ong = novaOng;
					                break;
					            default:
					                System.out.println("Opção inválida. Tente novamente.");
					                break;
			            }

		                break;
		            case 2: {
                        System.out.println("\nDigite o nome do usuário:");
                        String nomeLogin = scanner.nextLine();
                        System.out.println("Digite a senha do usuário:");
                        String senhaLogin = scanner.nextLine();
                        logado = cadastroLogin.realizarLogin(nomeLogin, senhaLogin);
                        usuarioLogado = nomeLogin;
                        break; } 
		            case 0:
		                finalizar = true;
		                break;
		            default:
		                System.out.println("Opção inválida. Tente novamente.\n");
		                break;

	            }
	        } else {
	        	
	        	String tipoUsuario = cadastroLogin.obterTipoUsuario(usuarioLogado);
	        	
	        	if (tipoUsuario.equals("Pessoa Física") || tipoUsuario.equals("Pessoa Jurídica")) {

	                System.out.println("\nSelecione uma opção:");
	                System.out.println("1 - Realizar cadastro de um alimento para doação");
	                System.out.println("2 - Verificar alimentos cadastrados");
	                System.out.println("3 - Excluir alimento cadastrado");
	                System.out.println("4 - Verificar pontos de coleta");
	                System.out.println("5 - Verificar ONGs cadastradas na SeedS");
	                System.out.println("6 - Fazer logout");
	                System.out.println("0 - Sair");
	
	                int opcao = scanner.nextInt();
	                scanner.nextLine(); 
	                
	                switch (opcao) {
		                case 1:
		                    boolean doarOutroAlimento = true;
		                    while (doarOutroAlimento) {
		                        System.out.println("\nAgradecemos o interesse em ajudar a causa! Para continuarmos, precisamos de algumas informações sobre o alimento a ser doado:");
		                        System.out.println("Qual o nome do item?");
		                        String nomeAlimento = scanner.nextLine();
		                        System.out.println("Qual a quantidade?");
		                        String quantidadeAlimento = scanner.nextLine();
		                        System.out.println("Qual a data de validade?");
		                        String validadeAlimento = scanner.nextLine();
		                        System.out.println("O alimento é perecível?");
		                        String armazenamentoAlimento = scanner.nextLine();
		                        alimento = new Alimento(nomeAlimento, quantidadeAlimento, validadeAlimento, armazenamentoAlimento, usuarioLogado);
		                        alimento.setUsuarioDoacao(usuarioLogado);
		                        alimento.cadastrarAlimento(alimento, usuarioLogado);

		                        boolean opcaoValida = false;
		                        while (!opcaoValida) {
		                            System.out.println("\nDeseja doar outro alimento?");
		                            System.out.println("1 - Sim");
		                            System.out.println("2 - Não");
		                            int opcaoDoarOutro = scanner.nextInt();
		                            scanner.nextLine();

		                            if (opcaoDoarOutro == 2) {
		                                doarOutroAlimento = false;
		                                opcaoValida = true;
		                            } else if (opcaoDoarOutro == 1) {
		                                opcaoValida = true;
		                            } else {
		                                System.out.println("Opção inválida. Digite 1 para Sim ou 2 para Não.");
		                            }
		                        }
		                    }
		                    break;

	                    case 2:
	                        alimento.exibirAlimentosDoUsuario(usuarioLogado);
	                        break;

	                    case 3:
	                        System.out.println("\nDigite o nome do alimento a ser excluído:");
	                        String nomeAlimentoExcluir = scanner.nextLine();
	                        alimento.excluirAlimento(nomeAlimentoExcluir);
	                        break;

	                    case 4:
		                    System.out.println("Atualmente possuímos dois pontos de coleta na cidade de São Paulo, em conjunto com as ONGs ajudadas.\nPara doar, é necessário realizar o cadastro do item previamente, "
		                    		+ "mediante aprovação, podendo ser feito online ou fisicamente nos locais de coleta:\n"
		                    		+ "1. Associação Beneficente Santa Fé - Endereço: Rua Rio Grande, 853, Vila Mariana\n"
		                    		+ "2. Casa do Zezinho - Endereço: Rua Anália Dolácio Albino, 77 - Parque Maria Helena\n\n");
	                        break;
	                        
	                    case 5:
	                        cadastroLogin.exibirOngsCadastradas();
	                        break;

	                    case 6:
	                        logado = false;
	                        usuarioLogado = "";
	                        break;

	                        
	                    case 0:
	                        finalizar = true;
	                        break;
	                        
	                    default:
	                        System.out.println("Opção inválida. Tente novamente.");
	                        break;
	                        
	                }
                
	        	} else  {	        		
	        		
                    System.out.println("\nSelecione uma opção:");
                    System.out.println("1 - Verificar itens doados");
                    System.out.println("2 - Aceitar um item doado");
                    System.out.println("3 - Fazer logout");
                    System.out.println("0 - Sair");


                    int opcao = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    switch (opcao) {
    	                case 1:
    	                	alimento.exibirAlimentosDoados();
    	                    break;
    	                    
    	                case 2:
    	                    System.out.println("\nLista de alimentos doados:");
    	                    alimento.exibirAlimentosDoados();

    	                    System.out.println("\nDigite o nome do item a ser aceito:");
    	                    String nomeItem = scanner.nextLine();
    	                    
    	                    Alimento alimentoAceito = null;
    	                    for (Alimento a : alimento.getAlimentosDoados()) {
    	                        if (a.getNomeAlimento().equalsIgnoreCase(nomeItem)) {
    	                            alimentoAceito = a;
    	                            break;
    	                        }
    	                    }
    	                    
    	                    if (alimentoAceito != null) {
    	                    	alimento.aceitarItemDoado(nomeItem);;
    	                        System.out.println("Item aceito com sucesso!");
    	                    } else {
    	                        System.out.println("Item não encontrado na lista de alimentos doados.");
    	                    }
    	                    break;

                        case 3:
                            logado = false;
                            usuarioLogado = "";
                            break;
                        case 0:
                            finalizar = true;
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
	
                }
            }

	}
}
}
