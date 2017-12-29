
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
	
	public static double[] multiplicacaoMatrizVetor(double[][] matriz, double[] vetor)
	{
		double parcial;
		int tamanho = matriz.length;
		double[] resultado = new double[tamanho];
		
		for(int i=0; i<tamanho; i++)
		{
			parcial=0;
			for(int j=0; j<tamanho; j++)
			{
				parcial = parcial + matriz[i][j]*vetor[j];
			}
			resultado[i] = parcial;
		}
		return resultado;
	}
	
	public static double multiplicacaoVetorVetor(double[] vetor_1, double[] vetor_2)
	{
		double resultado=0;
		int tamanho = vetor_1.length;
		
		for(int i=0; i<tamanho; i++)
		{
			resultado = resultado + (vetor_1[i]*vetor_2[i]);
		}		
		
		return resultado;
	}

	public static double[][] multiplicacaoMatrizEscalar(double[][] matriz, double escalar)
	{
		int dimensao = matriz.length;
		double[][] matriz_resultado = new double[dimensao][dimensao];

		for(int i=0; i<dimensao; i++)
		{
			for(int j=0; j<dimensao; j++)
			{
				matriz_resultado[i][j] = matriz[i][j] * escalar;
			}
		}

		return matriz_resultado;
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

	public static double discosGerschgorin(double[][] matriz, int indice)
	{
		double somatorio=0, limite_superior, limite_inferior;
		int tamanho = matriz.length;

		for(int i=0; i<tamanho; i++)
		{
			if(i != indice)
				somatorio = somatorio + Math.abs(matriz[indice][i]);
		}

		limite_inferior = matriz[indice][indice] - somatorio;
		limite_superior = matriz[indice][indice] + somatorio;

		return (limite_inferior*indice);
	}
	
}