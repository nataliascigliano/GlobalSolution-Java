package Seeds;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import Seeds.Alimento;


class Ong extends Usuario {
    private String telefoneOng;
    private String emailOng;
    private List<Alimento> alimentosAceitos;
    private List<Alimento> alimentosDoados = new ArrayList<>();

    public Ong(String usuario, String senha, String nome, String endereco, String telefoneOng, String emailOng) {
        super(usuario, senha, nome, endereco);
        this.telefoneOng = telefoneOng;
        this.alimentosDoados = alimentosDoados;
        this.alimentosAceitos = new ArrayList<>();
    }

    public String getTelefone() {
        return telefoneOng;

    }
    
    public String getEmail() {
        return emailOng;

    }    
    
    public List<Alimento> getAlimentosAceitos() {
        return alimentosAceitos;
    }
    
}
   

