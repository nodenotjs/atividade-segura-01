public class Musica {
    private String titulo;
    private int duracao;
    private Pessoa compositor;

    public Musica(String titulo, int duracao, Pessoa compositor) {
        setTitulo(titulo);
        setDuracao(duracao);
        setCompositor(compositor);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public Pessoa getCompositor() {
        return compositor;
    }

    public void setTitulo(String titulo) {
        if (duracao < 0)
            throw new RuntimeException("Duração não pode ser negativa");
        this.titulo = titulo;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setCompositor(Pessoa compositor) {
        this.compositor = compositor;
    }

    public void tocarMusica() {
        System.out.println("Tocando música...");
    }

    public String toString() {
        return String.format("Título: %s, Duração: %s, Compositor: %s", titulo, duracao, compositor.getNome());
    }
}
