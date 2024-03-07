import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        Album album = scanAlbumFromUser();
        System.out.println("Mostrando todos os dados:\n");
        album.mostrarTodosOsDados();
    }

    private static Album scanAlbumFromUser() {
        Album album = null;

        final Pattern albumInputPattern = Pattern.compile(
                "(?<name>.+?), (?<year>-?\\d+), (?<gender>.+?), (?<artistname>.+?), (?<artistage>\\d+)",
                Pattern.CASE_INSENSITIVE);
        final Pattern musicInputPattern = Pattern.compile(
                "(?:(?<title>.+?), (?<durationseconds>\\d+), (?<composername>.+?), (?<composerage>\\d+))|(?<cmdexit>exit)",
                Pattern.CASE_INSENSITIVE);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira os dados do album (formato: nome, ano, gênero, nome do artista, idade do artista)");

        do {
            Matcher matcher = albumInputPattern.matcher(scanner.nextLine());
            try {
                if (!matcher.find()) {
                    throw new RuntimeException();
                }

                String nome = matcher.group("name");
                int ano = Integer.parseInt(matcher.group("year"));
                String gender = matcher.group("gender");
                String artistName = matcher.group("artistname");
                int artistAge = Integer.parseInt(matcher.group("artistage"));

                Pessoa artista = new Pessoa(artistName, artistAge);
                album = new Album(gender, ano, nome, artista);

            } catch (Exception e) {
                System.out.println("Formato inválido");
                continue;
            }
        } while (album == null);

        boolean shouldExit = false;
        do {
            System.out.println(
                    "Insira os dados da música (formato: título, duração (em segundos), nome do compositor, idade do compositor) OU digite exit para sair");

            Matcher matcher = musicInputPattern.matcher(scanner.nextLine());
            try {
                if (!matcher.find()) {
                    throw new RuntimeException("not find");
                }

                if (matcher.group("cmdexit") != null) {
                    shouldExit = true;
                    continue;
                }

                String titulo = matcher.group("title");
                int duracao = Integer.parseInt(matcher.group("durationseconds"));
                String nomeCompositor = matcher.group("composername");
                int idadeCompositor = Integer.parseInt(matcher.group("composerage"));

                Pessoa compositor = new Pessoa(nomeCompositor, idadeCompositor);
                Musica music = new Musica(titulo, duracao, compositor);
                album.adicionarMusica(music);
                System.out.println("Música adicionada!");

            } catch (Exception e) {
                System.out.println("Formato inválido");
                System.out.println(e);
                continue;
            }
        } while (!shouldExit);

        scanner.close();
        return album;
    }
}
