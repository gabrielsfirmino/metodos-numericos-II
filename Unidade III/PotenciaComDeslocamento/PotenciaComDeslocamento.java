//Gabriel Sousa Firmino - 362963
//Compilado e executado no Ubuntu

public class PotenciaComDeslocamento
{
	public static void potenciaInverso(double[][] matriz, double[] vetor, double tolerancia) throws Exception
	{
		double[] phi;
		double lambda_anterior;

		double[] vetor_corrente = vetor;
		double lambda = 0;
		do
		{
			lambda_anterior = lambda;
			phi = Operacoes.divisaoVetorEscalar(vetor_corrente, Operacoes.normalizar(vetor_corrente));
			vetor_corrente = ResolverSistemaLinear.decomposicaoLU(matriz, phi);
			lambda = Operacoes.multiplicacaoVetorVetor(phi, vetor_corrente);
		} while((Math.abs((lambda-lambda_anterior)/lambda)) > tolerancia);

		String endereco_phi = "Phi.txt";
		ManipularArquivo.escreverVetor(endereco_phi, phi);

		String endereco_lambda = "Lambda_Barra.txt";
		ManipularArquivo.escreverEscalar(endereco_lambda, lambda);

	}

	public static void main(String[] args) throws Exception
	{
		double[] phi;
		double mi;
		double lambda_barra;

		String endereco_matriz = "Matriz.txt";
		double[][] matriz_A = ManipularArquivo.lerMatriz(endereco_matriz);

		String endereco_vetor = "Vetor.txt";
		double[] vetor_inicial = ManipularArquivo.lerVetor(endereco_vetor);

		String endereco_tolerancia = "Tolerancia.txt";
		double tolerancia = ManipularArquivo.lerEscalar(endereco_tolerancia);

		int dimensao_matriz = matriz_A.length;
		int dimensao_vetor = vetor_inicial.length;

		double[][] matriz_A_barra = new double[dimensao_matriz][dimensao_matriz];
		double[] lambda = new double[dimensao_vetor];
		double[][] id = Operacoes.matrizIdentidade(dimensao_matriz);

		for(int i=0; i<dimensao_matriz; i++)
		{
			mi = Operacoes.discosGerschgorin(matriz_A, i);
			matriz_A_barra = Operacoes.subtracaoMatrizMatriz(matriz_A, Operacoes.multiplicacaoMatrizEscalar(id, mi));
			potenciaInverso(matriz_A_barra, vetor_inicial, tolerancia);

			String endereco_lambda_barra = "Lambda_Barra.txt";
			lambda_barra = ManipularArquivo.lerEscalar(endereco_lambda_barra);

			String endereco_phi = "Phi.txt";
			phi = ManipularArquivo.lerVetor(endereco_phi);

			lambda[i] = lambda_barra - mi;
			String endereco_lambda = "Lambda_"+i+".txt";
			ManipularArquivo.escreverEscalar(endereco_lambda, lambda[i]);
		}

		System.out.printf("Arquivos contendo lambda barra, lambda e phi gerados com sucesso.\n");
	}
}
