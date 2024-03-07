import java.util.ArrayList;

public class Album {
    private String nome;
    private String genero;
    private int ano;
    private Pessoa artista;
    private ArrayList<Musica> musicas;

    public Album(String genero, int ano, String nome, Pessoa artista) {
        this.genero = genero;
        this.ano = ano;
        this.nome = nome;
        this.artista = artista;
        this.musicas = new ArrayList<Musica>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void mostrarTodosOsDados() {
        System.out.println(String.format("Nome: %s\nGênero: %s\nAno: %s\nArtista: %s\nMúsicas:", nome, genero, ano, artista.getNome()));
        for (Musica musica : musicas) {
            System.err.println("- " + musica);
        }
    }
}
