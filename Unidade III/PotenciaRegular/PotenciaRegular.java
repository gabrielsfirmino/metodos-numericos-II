//Gabriel Sousa Firmino - 362963
//Compilado e executado no Ubuntu

public class PotenciaRegular
{		
	public static void main(String[] args) throws Exception 
	{	
		double[] phi;
		double lambda_anterior;
		
		String endereco_matriz = "Matriz.txt";
		double[][] matriz_A = ManipularArquivo.lerMatriz(endereco_matriz);
		
		String endereco_vetor = "Vetor.txt";
		double[] vetor_inicial = ManipularArquivo.lerVetor(endereco_vetor);
		
		String endereco_tolerancia = "Tolerancia.txt";
		double tolerancia = ManipularArquivo.lerTolerancia(endereco_tolerancia);
		
		int dimensao_matriz = matriz_A.length;
		int dimensao_vetor = vetor_inicial.length;
		
		double[] vetor_corrente = vetor_inicial;
		double lambda = 0;
		
		do 
		{
			lambda_anterior = lambda;
			phi = Operacoes.divisaoVetorEscalar(vetor_corrente, Operacoes.normalizar(vetor_corrente));
			vetor_corrente = Operacoes.multiplicacaoMatrizVetor(matriz_A, phi);
			lambda = Operacoes.multiplicacaoVetorVetor(phi, vetor_corrente);
		} while((Math.abs(lambda-lambda_anterior)/lambda) > tolerancia);

		String endereco_phi = "Phi.txt";
		ManipularArquivo.escreverVetor(endereco_phi, phi);
		
		String endereco_lambda = "Lambda.txt";
		ManipularArquivo.escreverEscalar(endereco_lambda, lambda);
		
		System.out.println("Arquivos contendo o phi e o lambda gerados com sucesso.");
	}
}