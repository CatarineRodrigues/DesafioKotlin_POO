import kotlin.system.exitProcess

/* ideia base
um programa que leia as notas da primeira, segunda, terceira e quarta avaliação de um aluno.
Calcule e imprima a média semestral.
somente notas 0-10 validar a nota antes de add ela no array, array dentro de um if
“novo cálculo (1-sim 2-nao)” ao final de cada aluno
 ----> indicando se deseja ou não EXECUTAR o algoritmo NOVAMENTE
 (aceitar apenas os código 1 ou 2)
● Quando 4 notas válidas forem lidas, deve ser impressa a mensagem
após ler as 4 notas = exibir "média= ” seguido do valor do cálculo.
e mostrar a pergunta
"novo cálculo (1-sim 2-nao)"
  -> -> 2 o programa deve ser encerrado.
  exitProcess(0)
● O programa deve parar quando o valor lido para este X for igual a 2.
se for 1 RODAR TODO O PROGRAMA NOVAMENTE
 */

/* estrutura
//menu inicial explicando o q faz
//pedindo e validando notas = if array / else, insira novamente
calculo média com retorno parametro puxa as notas
exibir média puxar do retorno anterior
//caixa opção 1 ou 2  if 1 rodar novamente else if 2 sair else retorna a mesma caixa opção
 */


fun main(){
    println("Instruções iniciais:")
    println("Nesse sistema você irá inserir as 4 notas (de um mesmo aluno), quando for pedido, e ao final te mostraremos qual foi a média final.")
    println("Inicializando sistema...")
    sistamaEscola()
}

fun sistamaEscola() {
    println("\n-----------------------------------------------------")
    println("Bem vindo ao nosso sistema de notas da Escola SimCity")
    println("-----------------------------------------------------")

    var listaNotas = cadastroNotasAluno()
    var media = calculoMedia(listaNotas)
    println("A média semestral do aluno foi $media")

    perguntaExecutarNovamente()
}

fun cadastroNotasAluno(): DoubleArray{
    var listaNotas = DoubleArray(4)
    for (i in listaNotas.indices) {
        println("Escreva a média o aluno teve na ${i + 1} prova")
        var notaAluno = readln().toDouble()
        listaNotas[i] = analisandoNotas(notaAluno)
    }
    return listaNotas
}

fun calculoMedia(listaNotas: DoubleArray): Double {
    var media: Double = 0.0
    listaNotas.forEachIndexed { index, _ ->
        media += listaNotas[index]
    }
    return media / 4
}

fun analisandoNotas(notaAluno: Double): Double{
    var analiseNota = notaAluno                      // criei uma nova variável pq ñ posso alterar valor de parâmetro
    if (analiseNota < 0 || analiseNota > 10 ) {
        do {
            println("Nota inválida! Insira um valor entre 0 e 10")
            analiseNota = readln().toDouble()
        }
        while (analiseNota < 0 || analiseNota > 10)
    }
    println("Nota cadastrada")
    return analiseNota
}

fun perguntaExecutarNovamente(){
    println("\nDeseja fazer um novo cálculo? \n1-sim 2-nao")
    val numeroDigitado = readln().toInt()
    when (numeroDigitado) {
        1 -> sistamaEscola()
        2 -> encerrarSistema()
        else -> perguntaExecutarNovamente()
    }
}

fun encerrarSistema(){
    println("Obrigado por usar nosso sistema!")
    exitProcess(0)
}