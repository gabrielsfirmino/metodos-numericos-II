//Gabriel Sousa Firmino - 362963
//Compilado e executado no Ubuntu

public class Jacobi
{
	public static void main(String[] args) throws Exception
	{
		String endereco_matriz = "Matriz.txt";
		double[][] matriz_A = ManipularArquivo.lerMatriz(endereco_matriz);

		String endereco_tolerancia = "Tolerancia.txt";
		double tolerancia = ManipularArquivo.lerEscalar(endereco_tolerancia);
		double e;

		int dimensao_matriz = matriz_A.length;

		double[][] matriz_A_barra = new double[dimensao_matriz][dimensao_matriz];
		double[][] matriz_J = new double[dimensao_matriz][dimensao_matriz];
		double[][] matriz_J_ij = new double[dimensao_matriz][dimensao_matriz];


		matriz_J = Operacoes.matrizIdentidade(dimensao_matriz);
		matriz_A_barra = matriz_A;

		do
		{
			for(int j=0; j<dimensao_matriz-1; j++)
			{
				for(int i=j; i<dimensao_matriz; i++)
				{
					matriz_J_ij = Operacoes.gerar_J(i, j, dimensao_matriz, matriz_A_barra[j][j], matriz_A_barra[i][j], matriz_A_barra[i][i]);
					matriz_A_barra = Operacoes.multiplicacaoMatrizMatriz(Operacoes.transposta(matriz_J_ij), Operacoes.multiplicacaoMatrizMatriz(matriz_A_barra, matriz_J_ij));
					matriz_J = Operacoes.multiplicacaoMatrizMatriz(matriz_J_ij, matriz_J);
				}
			}
			e = Operacoes.normaMatricial(matriz_A_barra);
		} while(e > tolerancia);

		String endereco_matriz_Entrada = "MatrizEntrada.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_Entrada, matriz_A);

		String endereco_matriz_Jacobi = "MatrizJacobi.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_Jacobi, matriz_J);

		String endereco_matriz_Diagonal = "MatrizDiagonal.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_Diagonal, matriz_A_barra);

		System.out.println("Matrizes geradas com sucesso.");
	}
}
