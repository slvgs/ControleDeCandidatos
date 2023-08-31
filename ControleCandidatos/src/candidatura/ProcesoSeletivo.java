package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcesoSeletivo {
	public static void main(String[] args) {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORDANA"};
		System.out.println("Processo Seletivo");
		selecaoCandidatos();
		for (String candidato: candidatos) {
			EntrarEmContato(candidato);
		}
		
		
		
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORDANA"};
	
		int candidatosSelecionados = 0; 
		int candidatoAtual = 0;
		double salBase = 2000.0;
		
		
		//se caso tiver 5 candidatos selecionados em meio ao random dos salarios a execução de seleção de candidatos se encerra, caso não, ele continuara rodando 
		//entao enquanto "candidatoSelecionados" for menos que 5 e "candidatoAtual" for menor que os "candidadatos" no array ele continuara rodando ou vai parar.
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length ) {

			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O cadidato" + candidato + " Solicitou este valor de salário" + salarioPretendido);
			
			if(salBase >= salarioPretendido) {
				
				System.out.println("O candidato " + candidato +" foi selecionado para a vaga");
				
				candidatosSelecionados++;
				
			}
			
			candidatoAtual++;
		}
		
		
		
		
		
		
	}
	
	static void EntrarEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		
		do {
			
			atendeu = atender();
			continuarTentando = !atendeu;
			
				if (continuarTentando) {
					tentativasRealizadas++;
				}else {
					System.out.println("CONTATO REALIZADO COM SUCESSO ");
				}
			
			
			
			
			
			
			
		}while(continuarTentando && tentativasRealizadas < 3);
		
		
			if(atendeu) {
				System.out.println("CONSEGUIMOS CONTATO COM " + candidato + "NA " + tentativasRealizadas + "TENTATIVA");
			}else {
				System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " + tentativasRealizadas + "REALIZADA");
			}
		
	}

	
	static boolean atender(){
		
		return new Random().nextInt(3)==1;
	}
	
	
	
	
	static double valorPretendido () {
		
		//ThreadLocalRandom = um gerador de números aleatórios isolado
		//current = retorna a classe do thread atual 
		//ira retornar um valor duplo entre 1900 a 2000
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido){
		
		double salBase = 2000.0;
		
		if(salBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
			
		}else if(salBase == salarioPretendido){
			System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA");
		}else {
			System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
		}
			
		
	}

}
