//Gabriel Sousa Firmino - 362963
//Compilado e executado no Ubuntu

import java.util.ArrayList;

public class QR
{
	public static void main(String[] args) throws Exception
	{
		String endereco_matriz = "Matriz.txt";
		double[][] matriz_A = ManipularArquivo.lerMatriz(endereco_matriz);
		int dimensao_matriz = matriz_A.length;

		String endereco_tolerancia = "Tolerancia.txt";
		double tolerancia = ManipularArquivo.lerEscalar(endereco_tolerancia);	
		double e = 0;

		double[][] matriz_Ast = new double[dimensao_matriz][dimensao_matriz];
		double[][] matriz_Rst = new double[dimensao_matriz][dimensao_matriz];
		double[][] matriz_Qst = new double[dimensao_matriz][dimensao_matriz];
		double[][] matriz_Q = new double[dimensao_matriz][dimensao_matriz];
		
		ArrayList<double[][]> matrizes = new ArrayList<double[][]>();

		matriz_Q = Operacoes.matrizIdentidade(dimensao_matriz);	
		matriz_Ast = matriz_A;

		do 
		{
			matrizes = Operacoes.construir_QR(matriz_Ast);
			matriz_Rst = matrizes.get(0); 
			matriz_Qst = matrizes.get(1);
			matriz_Q = Operacoes.multiplicacaoMatrizMatriz(matriz_Q, matriz_Qst);
			matriz_Ast = Operacoes.multiplicacaoMatrizMatriz(matriz_Rst, matriz_Qst);
			e = Operacoes.normaMatricial(matriz_Ast);
		}while(e > tolerancia);	

		String endereco_matriz_Entrada = "MatrizEntrada.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_Entrada, matriz_A);

		String endereco_matriz_QR = "MatrizQR.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_QR, matriz_Q);

		String endereco_matriz_Diagonal = "MatrizDiagonal.txt";
		ManipularArquivo.escreverMatriz(endereco_matriz_Diagonal, matriz_Ast);
		
		System.out.println("Matrizes geradas com sucesso.");
	}
}