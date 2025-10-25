import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

// (CLASSES AUXILIARES ) 

class Pessoa {
    private String nome;
    private int idade;
    private String endereco;
    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome; this.idade = idade; this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Endereço: " + endereco;
    }
}

class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;
    public Produto(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo; this.nome = nome; this.preco = preco; this.quantidade = quantidade;
    }
    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    @Override
    public String toString() {
        return String.format(Locale.US, 
            "Cód: %d | Produto: %-15s | Preço: R$ %.2f | Estoque: %d", 
            codigo, nome, preco, quantidade);
    }
}


public class ListaDeExercicios {
    
    private static List<Produto> estoque = new ArrayList<>();

    
    // MÉTODOS DOS EXERCÍCIOS 
    
    
    // EXERCÍCIO 1 (Demonstração)
    public static void exercicio1() { 
        System.out.println("\n--- [1] Reserva de Hotel (Demonstração) ---");
        int numeroQuarto = 305;
        double valorDiaria = 150.75;
        String nomeHospede = "Nuara Valle";
        System.out.println("Quarto: " + numeroQuarto);
        System.out.println("Valor da Diária: R$ " + String.format("%.2f", valorDiaria));
        System.out.println("Hóspede: " + nomeHospede);
    }

    // EXERCÍCIO 2 (Interativo com Loop e Opção de Sair)
    public static void exercicio2(Scanner scanner) {
        System.out.println("\n--- [2] Verificador de Produto (Interativo) ---");
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n[2.1] Digite 0 para voltar ao Menu.");
            System.out.print("Digite o código do produto (um número inteiro): ");
            
            if (scanner.hasNextInt()) {
                int codigoProduto = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                if (codigoProduto == 0) {
                    continuar = false;
                    System.out.println("Voltando ao Menu Principal...");
                    continue;
                }

                String resultado = (codigoProduto % 2 == 0) ? "Par" : "Ímpar";
                System.out.println("Código: " + codigoProduto);
                System.out.println("O código é um número " + resultado + ".");
            } else {
                String entradaInvalida = scanner.next();
                if (entradaInvalida.equalsIgnoreCase("0")) {
                    continuar = false;
                    System.out.println("Voltando ao Menu Principal...");
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                }
            }
        }
    }

    // EXERCÍCIO 3 (Demonstração)
    public static void exercicio3() {
        System.out.println("\n--- [3] Contagem de Clientes ---");
        for (int cliente = 1; cliente <= 10; cliente++) {
            System.out.println("Cliente nº: " + cliente);
        }
    }

    // EXERCÍCIO 4 (Interativo - Adição de Clientes)
    public static void exercicio4(Scanner scanner) {
        System.out.println("\n--- [4] Lista de Espera (Interativo) ---");
        List<String> listaEspera = new ArrayList<>(Arrays.asList("Nuara", "Ana"));
        
        System.out.println("Lista Inicial: " + listaEspera);
        System.out.println("\n[4.1] Digite 'sair' para voltar ao Menu.");
        System.out.print("Digite o nome de um novo cliente para a lista: ");
        
        String novoCliente = scanner.nextLine().trim();

        if (novoCliente.equalsIgnoreCase("sair")) {
            System.out.println("Voltando ao Menu Principal...");
            return;
        }

        if (!novoCliente.isEmpty()) {
            listaEspera.add(novoCliente);
            System.out.println("* Cliente Adicionado: " + novoCliente);
        }

        if (!listaEspera.isEmpty()) {
            String clienteAtendido = listaEspera.remove(0); 
            System.out.println("* Cliente Removido/Atendido: " + clienteAtendido);
        }

        System.out.println("Lista Final: " + listaEspera);
    }

    // EXERCÍCIO 5 (Interativo)
    public static void exercicio5(Scanner scanner) {
        System.out.println("\n--- [5] Avaliação de Notas (Interativo) ---");
        
        double[] notas = new double[3];

        System.out.println("Digite 3 notas para encontrar a maior:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Nota %d: ", i + 1);
            // Verifica se a próxima entrada é um número antes de tentar ler
            if (scanner.hasNextDouble()) {
                notas[i] = scanner.nextDouble();
            } else {
                System.out.println("Entrada inválida. Usando 0.0.");
                notas[i] = 0.0;
                scanner.next(); // Limpa o token inválido
            }
        }
        scanner.nextLine(); // Consome a quebra de linha
        
        double maiorNota = Arrays.stream(notas).max().orElse(0.0);
        
        System.out.println("Notas digitadas: " + Arrays.toString(notas));
        System.out.println("A maior nota é: " + maiorNota);
    }

    // EXERCÍCIO 6 (Demonstração)
    private static boolean ehPrimo(int n) { return n > 1 && java.util.stream.IntStream.range(2, (int)Math.sqrt(n) + 1).noneMatch(i -> n % i == 0); }
    public static void exercicio6() { 
        System.out.println("\n--- [6] Números Primos (1 a 100) ---");
        List<Integer> primos = new ArrayList<>();
        for (int i = 1; i <= 100; i++) { if (ehPrimo(i)) primos.add(i); }
        System.out.println(primos);
    }
    
    // EXERCÍCIO 7 (Totalmente Interativo: Jogo da Velha com Opção de Reiniciar/Sair) 
    
    private static void exibirTabuleiroJogo(char[][] tab) {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tab[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -+-+-");
        }
        System.out.println();
    }
    
    private static boolean verificarVitoriaJogo(char[][] tab, char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tab[i][0] == jogador && tab[i][1] == jogador && tab[i][2] == jogador) return true;
            if (tab[0][i] == jogador && tab[1][i] == jogador && tab[2][i] == jogador) return true;
        }
        if (tab[0][0] == jogador && tab[1][1] == jogador && tab[2][2] == jogador) return true;
        if (tab[0][2] == jogador && tab[1][1] == jogador && tab[2][0] == jogador) return true;
        return false;
    }

    private static boolean verificarEmpateJogo(char[][] tab) {
        for (char[] row : tab) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    public static void exercicio7(Scanner scanner) {
        System.out.println("\n--- [7] Jogo da Velha (Completo e Interativo) ---");
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            char[][] tabuleiro = new char[3][3];
            for (char[] row : tabuleiro) Arrays.fill(row, ' '); 
            char jogadorAtual = 'X';
            boolean jogoAtivo = true;

            System.out.println("Novo jogo iniciado!");
            
            while (jogoAtivo) {
                exibirTabuleiroJogo(tabuleiro);
                System.out.println("Jogador " + jogadorAtual + ", é sua vez.");
                System.out.println("Digite -1 para voltar ao Menu Principal.");
                
                boolean jogadaValida = false;
                int linha = -1, coluna = -1;

                while (!jogadaValida) {
                    try {
                        System.out.print("Digite a LINHA (0, 1, 2 ou -1): ");
                        linha = scanner.nextInt();
                        
                        if (linha == -1) {
                            jogoAtivo = false;
                            jogarNovamente = false;
                            jogadaValida = true;
                            System.out.println("Voltando ao Menu Principal...");
                            continue;
                        }

                        System.out.print("Digite a COLUNA (0, 1, 2): ");
                        coluna = scanner.nextInt();

                        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                            tabuleiro[linha][coluna] = jogadorAtual;
                            jogadaValida = true;
                        } else {
                            System.out.println("Posição inválida ou já ocupada. Tente novamente.");
                        }
                    } catch (Exception e) {
                        System.out.println("Entrada inválida. Digite apenas números.");
                        scanner.nextLine(); 
                    }
                }

                if (!jogoAtivo) break; // Sai do loop interno se -1 foi digitado

                // Verifica Vitoria e Empate
                if (verificarVitoriaJogo(tabuleiro, jogadorAtual)) {
                    exibirTabuleiroJogo(tabuleiro);
                    System.out.println("!!! JOGADOR " + jogadorAtual + " VENCEU !!!");
                    jogoAtivo = false;
                } else if (verificarEmpateJogo(tabuleiro)) {
                    exibirTabuleiroJogo(tabuleiro);
                    System.out.println("O JOGO TERMINOU EMPATADO!");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
                
            }
            scanner.nextLine(); // Garante que a próxima entrada seja limpa
            
            if (jogarNovamente) { // Se o jogo terminou, pergunta se quer jogar de novo
                System.out.print("Deseja jogar outra partida? (s/n): ");
                String resposta = scanner.nextLine().trim();
                if (resposta.equalsIgnoreCase("n")) {
                    jogarNovamente = false;
                    System.out.println("Voltando ao Menu Principal...");
                }
            }
        }
    }
    

    // EXERCÍCIO 8 (Demonstração)
    public static void exercicio8() { 
        System.out.println("\n--- [8] Frequência de Pedidos (Demonstração) ---");
        int[] codigos = {101, 205, 101, 310, 205, 101, 400, 205, 101};
        Map<Integer, Integer> freq = new HashMap<>();
        for (int c : codigos) freq.put(c, freq.getOrDefault(c, 0) + 1);
        System.out.println("Frequência: " + freq);
    }

    // EXERCÍCIO 9 (Demonstração)
    public static void exercicio9() { 
        System.out.println("\n--- [9] Cadastro de Clientes (Demonstração OO) ---");
        List<Pessoa> clientes = new ArrayList<>(Arrays.asList(new Pessoa("Roberto Souza", 45, "Rua A"), new Pessoa("Camila Ferreira", 28, "Av. Brasil")));
        for (Pessoa cliente : clientes) System.out.println(cliente);
    }

    // EXERCÍCIO 10 (Interativo)
    public static void adicionarItem(int codigo, String nome, double preco, int quantidade) { 
        for (Produto p : estoque) if (p.getCodigo() == codigo) { System.out.println("ERRO: Produto " + codigo + " já existe."); return; }
        estoque.add(new Produto(codigo, nome, preco, quantidade)); 
        System.out.println("Produto '" + nome + "' adicionado.");
    }
    public static void atualizarEstoque(int codigo, int novaQuantidade) { 
        for (Produto p : estoque) if (p.getCodigo() == codigo) { p.setQuantidade(novaQuantidade); return; }
    }
    public static void listarEstoque() { 
        System.out.println("\n--- ESTOQUE ATUAL ---");
        if (estoque.isEmpty()) System.out.println("O estoque está vazio.");
        for (Produto p : estoque) System.out.println(p);
    }
    
    public static void exercicio10(Scanner scanner) {
        System.out.println("\n--- [10] Gerenciamento de Estoque (Interativo) ---");
        estoque.clear(); 
        adicionarItem(1001, "Vestido", 89.90, 50);
        adicionarItem(2005, "Calça Jeans", 120.00, 30);
        listarEstoque();

        System.out.print("\nDeseja adicionar um novo produto? (s/n). Digite 'n' para voltar ao Menu: ");
        String resposta = scanner.nextLine().trim();

        if (resposta.equalsIgnoreCase("n")) {
            System.out.println("Voltando ao Menu Principal...");
            return;
        }

        if (resposta.equalsIgnoreCase("s")) {
            try {
                System.out.print("Nome do novo produto: ");
                String nome = scanner.nextLine();
                System.out.print("Preço: ");
                double preco = scanner.nextDouble();
                System.out.print("Quantidade inicial: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                adicionarItem(9999, nome, preco, quantidade); 
                listarEstoque();
            } catch (Exception e) {
                System.out.println("Erro na entrada. Voltando ao menu. Garanta que você digitou números para Preço e Quantidade.");
                // Limpa o buffer de entrada caso tenha ocorrido um erro de tipo
                if (scanner.hasNextLine()) { 
                    scanner.nextLine(); 
                }
            }
        }
    }


    // NOVO MÉTODO: Pergunta se o usuário quer ver o menu novamente
    private static void aguardarOuVoltarMenu(Scanner scanner) {
        System.out.println("\n---------------------------------------------");
        System.out.print("Deseja exibir o Menu Principal agora? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();
        
        if (resposta.equals("n")) {
            // Se o usuário não quiser o menu, faz uma pausa ou espera por Enter
            System.out.println("Pressione ENTER para continuar (o menu aparecerá em seguida).");
            scanner.nextLine(); 
        }
        // Se a resposta for 's' ou qualquer outra coisa, o loop do main exibe o menu.
    }
    
    
    // MÉTODO MAIN: Menu Interativo - Achei interessante colocar, gosto de Menus interativos. 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        while (escolha != 0) {
            // Exibir o menu ANTES de perguntar a escolha
            System.out.println("\n=============================================");
            System.out.println("  MENU DE EXERCÍCIOS JAVA (Interativo)");
            System.out.println("=============================================");
            System.out.println(" 1. Variáveis (Demonstração)");
            System.out.println(" 2. Condicionais (Interativo - Digite 0 para sair)");
            System.out.println(" 3. Laços de Repetição (Demonstração)");
            System.out.println(" 4. ArrayList (Interativo - Digite 'sair')");
            System.out.println(" 5. Array Simples (Interativo - Roda uma vez)");
            System.out.println(" 6. Laços/Funções (Demonstração)");
            System.out.println(" 7. Matriz (JOGO DA VELHA - Digite -1 para sair)");
            System.out.println(" 8. HashMap (Demonstração)");
            System.out.println(" 9. Classes e Objetos (Demonstração)");
            System.out.println(" 10. Sistema Completo (Interativo - Digite 'n' para sair)");
            System.out.println(" 0. Sair");
            System.out.println("---------------------------------------------");
            System.out.print("Digite o número do exercício (0 para sair): ");
            
            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha após o int
                
                try {
                    switch (escolha) {
                        case 1: exercicio1(); aguardarOuVoltarMenu(scanner); break; // Chamada da função auxiliar
                        case 2: exercicio2(scanner); break;
                        case 3: exercicio3(); aguardarOuVoltarMenu(scanner); break; // Chamada da função auxiliar
                        case 4: exercicio4(scanner); break;
                        case 5: exercicio5(scanner); aguardarOuVoltarMenu(scanner); break; // Chamada da função auxiliar
                        case 6: exercicio6(); aguardarOuVoltarMenu(scanner); break; // Chamada da função auxiliar
                        case 7: exercicio7(scanner); break;
                        case 8: exercicio8(); aguardarOuVoltarMenu(scanner); break; // Chamada da função auxiliar
                        case 9: exercicio9(); aguardarOuVoltarMenu(scanner); break; // Chamada da função auxiliar
                        case 10: exercicio10(scanner); break;
                        case 0: 
                            System.out.println("\nPrograma encerrado. Até mais!");
                            break;
                        default:
                            System.out.println("\nOpção inválida. Tente novamente.");
                            // Adicionar uma pausa após a mensagem de erro pode ser útil
                            // aguardarOuVoltarMenu(scanner); 
                    }
                } catch (Exception e) {
                    System.out.println("\nOcorreu um erro. Voltando ao menu. Erro: " + e.getMessage());
                    // Limpa o buffer de entrada caso tenha ocorrido um erro de tipo
                    if (scanner.hasNextLine()) { 
                        scanner.nextLine(); 
                    }
                }

            } else {
                System.out.println("\nEntrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa o token inválido
                escolha = -1;
            }
        }
        scanner.close();
    }
}