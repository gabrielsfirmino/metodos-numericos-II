
public class ResolverSistemaLinear 
{
	public static double[] decomposicaoLU(double[][] matriz, double[] vetor)
	{
		int dimensao = vetor.length;
		double auxiliar;
		double[] x = new double[dimensao];
		double[] y = new double[dimensao];
		double[][] L = new double[dimensao][dimensao];
		double[][] U = new double[dimensao][dimensao];
		double[][] matriz_auxiliar = new double[dimensao][dimensao];
		
		for(int i=0; i<dimensao; i++)
		{
			for(int j=0; j<dimensao; j++)
			{
				L[i][j] = 0;
				U[i][j] = 0;
				matriz_auxiliar[i][j] = 0;
			}
		}
		
		for(int i=0; i<dimensao; i++)
	    {
	        for(int j=0; j<dimensao; j++)
	        {
	            U[i][j] = matriz[i][j];
	        }
	    }

	    for(int j=0; j<dimensao-1; j++)
	    {
	        for(int i=j+1; i<dimensao; i++)
	        {
	            auxiliar = U[i][j] / U[j][j];
	            U[i][j] = 0;
	            matriz_auxiliar[i][j] = auxiliar;
	            for(int k=j+1; k<dimensao; k++)
	            {
	                U[i][k] = U[i][k] - (auxiliar * U[j][k]);
	            }
	        }
	    }
	    
	    for(int i=0; i<dimensao; i++)
	    {
	        for(int j=0; j<dimensao; j++)
	        {
	            if(i==j)
	                L[i][j] = 1;
	            else
	                if(i>j)
	                    L[i][j] = matriz_auxiliar[i][j];
	        }
	    }
	    
	    y=vetor;
	    y=Operacoes.multiplicacaoMatrizVetor(L, y);
	 
	    x=y;
	    x=Operacoes.multiplicacaoMatrizVetor(U, x);
	    
	    return x;
	}
}
