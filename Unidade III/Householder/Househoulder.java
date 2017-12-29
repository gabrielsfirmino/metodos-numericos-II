//Gabriel Sousa Firmino - 362963
//Compilado e executado no Ubuntu

public class Househoulder 
{
	public static void main(String[] args) throws Exception 
	{
		String endereco_matriz = "Matriz.txt";
		double[][] matriz_A = ManipularArquivo.lerMatriz(endereco_matriz);
		
		int dimensao_matriz = matriz_A.length;
		
		double[][] matriz_A_barra = new double[dimensao_matriz][dimensao_matriz];
		double[][] matriz_H = new double[dimensao_matriz][dimensao_matriz];
		double[][] matriz_Q = new double[dimensao_matriz][dimensao_matriz];
		double[] vetor_coluna = new double[dimensao_matriz];
		
		matriz_H = Operacoes.matrizIdentidade(dimensao_matriz);

		matriz_A_barra = matriz_A;
		
		for(int i=0; i<(dimensao_matriz-2); i++)
		{
			for(int j=0; j<dimensao_matriz; j++)
			{
				vetor_coluna[j] = matriz_A_barra[j][i];
			}
			matriz_Q = Operacoes.gerar_Q(vetor_coluna, i);
			matriz_H = Operacoes.multiplicacaoMatrizMatriz(matriz_H, matriz_Q);
			matriz_A_barra = Operacoes.multiplicacaoMatrizMatriz(Operacoes.multiplicacaoMatrizMatriz(matriz_Q, matriz_A_barra), Operacoes.transposta(matriz_Q));
		}
		
		String endereco_matriz_Entrada = "MatrizEntrada.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_Entrada, matriz_A);
		
		String endereco_matriz_A_barra = "MatrizTridiagonal.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_A_barra, matriz_A_barra);

		String endereco_matriz_Householder = "MatrizHouseholder.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_Householder, matriz_H);
		
		System.out.println("Matrizes geradas com sucesso.");
	}
}