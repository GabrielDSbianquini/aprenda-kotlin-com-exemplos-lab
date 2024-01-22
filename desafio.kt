package Kotlin.Introducao

import java.util.Scanner

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val idade: Int) {

}

data class ConteudoEducacional(val nome: String, var duracao: Int, var Nivel: Nivel) {
}
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}
fun exibirformacoes(Formacoes: List<Formacao>) {
    println("Formações disponíveis: ")
    for (Formacao in Formacoes) {
        println(Formacao)
    }
}
fun exibirConteudos(Conteudos: List<ConteudoEducacional>){
    println("Conteúdos disponiveis: ")
    for (Conteudo in Conteudos){
        println(Conteudo)
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introduçao ao Kotlin", 20, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação orientada a objetos", 60, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Tratando exceções", 30, Nivel.AVANCADO)
    val conteudo4 = ConteudoEducacional("Conheçendo o Springboot",40,Nivel.AVANCADO)
    val Formacao = Formacao("Desenvolvedor Kotlin", listOf(conteudo1,conteudo2, conteudo3))
    val Formacoes = listOf(Formacao)
    val Conteudos = listOf(conteudo1, conteudo2, conteudo3,conteudo4)

    val Usuario1 = Usuario("Gabriel", 20)
    val Usuario2 = Usuario("CJ", 29)
    Formacao.inscritos.add(Usuario1)
    Formacao.inscritos.add(Usuario2)
    Formacao.matricular(Usuario1)

   var opcao: Int = 0
    val scanner = Scanner(System.`in`)

   while (opcao != 3) {
       println("Selecione uma opção: \n 1-Para exibir as formações disponíveis\n 2-Exibir conteúdos disponíveis \n 3-Para sair")
       opcao = scanner.nextInt()
       when (opcao) {
           1 -> exibirformacoes(Formacoes)
           2 -> exibirConteudos(Conteudos)
           3 -> "Saindo..."
           else -> "Opcao inavalida"
       }
     }
  }
