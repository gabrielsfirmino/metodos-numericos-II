public class Operacoes 
{
	public static double[][] matrizIdentidade(int dimensao)
	{
		double[][] matriz_identidade = new double[dimensao][dimensao];

		for(int i=0; i<dimensao; i++)
		{
			for(int j=0; j<dimensao; j++)
			{
				if(i==j)
					matriz_identidade[i][j] = 1;
				else
					matriz_identidade[i][j] = 0;
			}
		}

		return matriz_identidade;
	}

	public static double normalizar(double[] vetor)
	{
		double vetor_normalizado, somatorio=0;
		int tamanho = vetor.length;
		
		for(int i=0; i<tamanho; i++)
		{
			somatorio = somatorio + (vetor[i]*vetor[i]);
		}
		
		vetor_normalizado = Math.sqrt(somatorio);
		
		return vetor_normalizado;
	}
	
	public static double[][] multiplicacaoMatrizMatriz(double[][] matriz_A, double[][] matriz_B)
	{
		int tamanho = matriz_A.length;
		double[][] resultado = new double[tamanho][tamanho];
		
		for (int i = 0; i < tamanho; i++)
        	for (int j = 0; j < tamanho; j++) 
            	for (int k = 0; k < tamanho; k++) 
                	resultado[i][j] += matriz_A[i][k]*matriz_B[k][j];
                
		return resultado;
	}

	public static double[][] transposta(double[][] matriz)
	{
		int tamanho = matriz.length;
		double[][] matriz_transposta = new double[tamanho][tamanho];

		for(int i=0; i<tamanho; i++)
		{
			for(int j=0; j<tamanho; j++)
			{
				matriz_transposta[i][j] = matriz[j][i];
			}
		}

		return matriz_transposta;
	}

	public static double normaMatricial(double[][] matriz)
	{
		double norma=0;
		int tamanho = matriz.length;

		for(int i=0; i<tamanho; i++)
		{
			for(int j=0; j<tamanho; j++)
			{
				if(j<i)
					norma = norma + Math.abs(matriz[i][j]);
			}
		}		

		norma = Math.sqrt(norma);
		return norma;
	}
	
	public static double[][] gerar_J(int indice_i, int indice_j, int tamanho, double a_jj, double a_ij, double a_ii)
	{
		double[][] matriz_J = new double[tamanho][tamanho];
		double theta;

		if(a_ii == a_jj)
			theta = Math.PI/4;
		else
			theta = Math.atan((2*a_ij)/(a_ii-a_jj))/2;

		matriz_J = Operacoes.matrizIdentidade(tamanho);

		matriz_J[indice_j][indice_j] = Math.cos(theta);
		matriz_J[indice_j][indice_i] = -Math.sin(theta);
		matriz_J[indice_i][indice_j] = Math.sin(theta);
		matriz_J[indice_i][indice_i] = Math.cos(theta);

		return matriz_J;
	}
	
}