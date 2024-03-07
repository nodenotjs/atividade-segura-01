public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setIdade(int idade) {
        if (idade < 0)
            throw new RuntimeException("Idade não pode ser menor do que 0");
        this.idade = idade;
    }
}