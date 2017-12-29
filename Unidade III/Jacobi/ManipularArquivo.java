import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ManipularArquivo 
{
	
	public static double[][] lerMatriz(String caminhoMatriz) throws Exception 
	{
		BufferedReader arquivo = new BufferedReader(new FileReader(caminhoMatriz));
		String linha = arquivo.readLine();
		String[] dimensao = linha.split("x");
		int quantidadeLinha = Integer.parseInt(dimensao[0]);
		int quantidadeColuna = Integer.parseInt(dimensao[1]);
		double[][] matriz = new double[quantidadeLinha][quantidadeColuna];
		
		for (int i=0; i<quantidadeLinha; i++)
		{
			linha = arquivo.readLine();
			String[] valores = linha.split("\t");
			for (int j=0; j<quantidadeColuna; j++) 
			{
				matriz[i][j] = Double.parseDouble(valores[j]);
			}
		}
		arquivo.close();
		return matriz;
	}
	
	public static double lerEscalar(String caminho_vetor) throws Exception 
	{
		BufferedReader arquivo = new BufferedReader(new FileReader(caminho_vetor));
		String linha = arquivo.readLine();
		double tolerancia = Double.parseDouble(linha);
		
		return tolerancia;
	}
	
	public static void escreverMatriz(String caminho_matriz, double[][] matriz) throws Exception
	{
		int tamanho = matriz.length;
		FileWriter arquivo = new FileWriter(caminho_matriz);
		PrintWriter escreverArq = new PrintWriter(arquivo);
		
		for (int i=0; i<tamanho; i++)
		{
			for (int j=0; j<tamanho; j++) 
			{
				escreverArq.print(matriz[i][j]);
				escreverArq.print("\t");
			}
			escreverArq.println();
		}
		
		arquivo.close();
	}
}