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
	
	public static double[] divisaoVetorEscalar(double[] vetor, double escalar)
	{	
		int tamanho = vetor.length;
		double[] resultado = new double[tamanho];
		
		for(int i=0; i<tamanho; i++)
		{
			resultado[i] = vetor[i]/escalar;
		}
		
		return resultado;
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
	
	public static double[][] multiplicacaoVetorVetor(double[] vetor_1, double[] vetor_2)
	{
		int tamanho = vetor_1.length;
		double[][] resultado = new double[tamanho][tamanho];
		
		for(int i=0; i<tamanho; i++)
		{
			for(int j=0; j<tamanho; j++)
			{
				resultado[j][i] = vetor_1[i]*vetor_2[j];
			}
		}		
		
		return resultado;
	}

	public static double[][] multiplicacaoMatrizEscalar(double[][] matriz, double escalar)
	{
		int tamanho = matriz.length;
		double[][] resultado = new double[tamanho][tamanho];
		
		for(int i=0; i<tamanho; i++)
		{
			for(int j=0; j<tamanho; j++)
			{
				resultado[i][j] = matriz[i][j]*escalar;
			}
		}		
		
		return resultado;
	}

	public static double[][] subtracaoMatrizMatriz(double[][] matriz_1, double[][] matriz_2)
	{
		int dimensao = matriz_1.length;
		double[][] matriz_resultado = new double[dimensao][dimensao];

		for(int i=0; i<dimensao; i++)
		{
			for(int j=0; j<dimensao; j++)
			{
				matriz_resultado[i][j] = matriz_1[i][j] - matriz_2[i][j];
			}
		}

		return matriz_resultado;
	}
	
	public static double[][] transposta(double[][] matriz)
	{
		int dimensao = matriz.length;
		double[][] matriz_transposta = new double[dimensao][dimensao];
		
		for(int i=0; i<dimensao; i++)
			for(int j=0; j<dimensao; j++)
				matriz_transposta[i][j] = matriz[j][i];
		
		return matriz_transposta;
	}
	
	public static double[][] gerar_Q(double[] vetor_coluna, int indice)
	{
		double normalizado;
		int dimensao = vetor_coluna.length;
		double[] vetor_c = new double[dimensao];
		double[] vetor_n = new double[dimensao];
		double[] vetor_nc = new double[dimensao];
		double[][] matriz_Q = new double[dimensao][dimensao];
		double[][] matriz_I = new double[dimensao][dimensao];
		matriz_I = Operacoes.matrizIdentidade(dimensao);
		
		for(int i=0; i<dimensao; i++)
		{
			vetor_c[i] = 0;
			vetor_n[i] = 0;
			vetor_nc[i] = 0;
		}
	
		for(int i=indice+1; i<dimensao; i++)
			vetor_c[i] = vetor_coluna[i];
		
		normalizado = Operacoes.normalizar(vetor_c);
		double alfa = (double) Math.signum(vetor_c[indice+1]);

		vetor_n = vetor_c;
		vetor_n[indice+1] =  vetor_c[indice+1] - alfa*normalizado;

		normalizado = Operacoes.normalizar(vetor_n);
		vetor_nc = Operacoes.divisaoVetorEscalar(vetor_n, normalizado);
		
		matriz_Q = Operacoes.subtracaoMatrizMatriz(matriz_I,Operacoes.multiplicacaoMatrizEscalar(Operacoes.multiplicacaoVetorVetor(vetor_nc, vetor_nc),2));
		return matriz_Q;
	}	
}