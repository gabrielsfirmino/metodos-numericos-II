
public class Operacoes 
{
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
}
