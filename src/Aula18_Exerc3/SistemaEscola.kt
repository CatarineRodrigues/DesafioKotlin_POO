package Aula18_Exerc3

import kotlin.system.exitProcess

open class SistemaEscola {
    var listaNotasAluno: ArrayList<Aluno> = ArrayList(4)
    var aluno = Aluno()
    var notaA = Aluno()

    private fun bemVindo() {
        println("\n-----------------------------------------------------")
        println("Bem vindo ao nosso sistema de notas da Escola SimCity")
        println("-----------------------------------------------------")
    }

    fun menuSistema() {
        bemVindo()
        while (true) {
            println("-------------------------------------")
            println("1 - Cadastrar notas")
            println("2 - Visualizar notas cadastradas")
            println("3 - Mostrar média semestral do aluno")
            println("4 - Sair")
            println("-------------------------------------")
            when (readln().toInt()) {
                1 -> {
                    cadastrarNotas()
//                perguntaExecutarNovamente()
                }
                2 -> visualizarListaNotas()
                3 -> println(aluno.exibirMedia(listaNotasAluno))
                4 -> encerrarSistema()
            }
        }
    }

    fun cadastrarNotas() {
        for (i in 1..4) {
            println("Escreva a nota que o aluno teve na ${i}º prova")
            aluno.notaProva = readln().toDouble()
            if (aluno.notaProva !in 0.0..10.0) {
                notaA = validarNotas(aluno)
            }
            println("Nota cadastrada")

            listaNotasAluno.add(notaA)
        }
    }

    fun validarNotas(nota: Aluno): Aluno {
        var notaAluno = nota
        while (notaAluno.notaProva !in 0.0..10.0) {
            println("Nota inválida! Insira um valor entre 0 e 10")
            notaAluno.notaProva = readln().toDouble()
        }
        return notaAluno
    }

    fun visualizarListaNotas() {
        listaNotasAluno.forEachIndexed { i, nota ->
            println("A ${i + 1}º nota cadastrada foi ${nota.notaProva} ")
        }
    }
//    var listaNotas = cadastroNotasAluno()
//    var media = calculoMedia(listaNotas)
//    println("A média semestral do aluno foi $media")

//    private fun perguntaExecutarNovamente() {
//        println("\nDeseja fazer um novo cálculo? \n1-sim 2-nao")
//        when (readln().toInt()) {
//            1 -> cadastrarNotas()
//            2 -> encerrarSistema()
//            else -> perguntaExecutarNovamente()
//        }
//    }

    private fun encerrarSistema() {
        println("Obrigado por usar nosso sistema!")
        exitProcess(0)
    }
}