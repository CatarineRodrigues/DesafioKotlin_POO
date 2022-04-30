package Aula18_Exerc3

import kotlin.system.exitProcess

class SistemaEscola {
    fun instrucoesIniciais(){
        println("Instruções iniciais:")
        println("Nesse sistema você irá inserir as 4 notas (de um mesmo aluno), quando for pedido, e ao final te mostraremos qual foi a média final.")
        println("Inicializando sistema...")
    }

    fun sistama() {
        bemVindo()
        val listaNotas = cadastroNotasAluno()
        val media = calculoMedia(listaNotas)
        println("A média semestral do aluno foi $media")

        perguntaExecutarNovamente()
    }

    fun bemVindo(){
        println("\n-----------------------------------------------------")
        println("Bem vindo ao nosso sistema de notas da Escola SimCity")
        println("-----------------------------------------------------")
    }

    fun cadastroNotasAluno(): DoubleArray{
        val listaNotas = DoubleArray(4)
        for (i in listaNotas.indices) {
            println("Escreva a nota que o aluno teve na ${i + 1}º prova")
            val notaAluno = readln().toDouble()
            listaNotas[i] = analisandoNotas(notaAluno)
        }
        return listaNotas
    }

    fun calculoMedia(listaNotas: DoubleArray): Double {
        var media = 0.0
        listaNotas.forEachIndexed { index, _ ->
            media += listaNotas[index]
        }
        return media / 4
    }

    fun analisandoNotas(notaAluno: Double): Double{
        var analiseNota = notaAluno
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
        when (readln().toInt()) {
            1 -> sistama()
            2 -> encerrarSistema()
            else -> perguntaExecutarNovamente()
        }
    }

    fun encerrarSistema(){
        println("Obrigado por usar nosso sistema!")
        exitProcess(0)
    }


}