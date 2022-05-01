package Aula18_Exerc3

class Aluno(var notaProva: Double = 0.0) {

    fun exibirMedia(listaNotasAluno: ArrayList<Aluno>): String {
        var mediaAluno = 0.0
        listaNotasAluno.forEachIndexed { _, aluno ->
            mediaAluno += aluno.notaProva
        }

        return "A média semestral do aluno foi ${mediaAluno / 4}"
    }
}