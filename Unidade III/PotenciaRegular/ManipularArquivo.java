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
	
	public static double[] lerVetor(String caminho_vetor) throws Exception 
	{
		BufferedReader arquivo = new BufferedReader(new FileReader(caminho_vetor));
		String linha = arquivo.readLine();
		String[] dimensao = linha.split("x");
		int quantidadeLinha = Integer.parseInt(dimensao[0]);
		double[] vetor = new double[quantidadeLinha];
		
		for (int i=0; i<quantidadeLinha; i++)
		{
			linha = arquivo.readLine();
			vetor[i] = Double.parseDouble(linha);
		}

		arquivo.close();
		return vetor;
	}
	
	public static double lerTolerancia(String caminho_vetor) throws Exception 
	{
		BufferedReader arquivo = new BufferedReader(new FileReader(caminho_vetor));
		String linha = arquivo.readLine();
		double tolerancia = Double.parseDouble(linha);
		
		return tolerancia;
	}
	
	public static void escreverVetor(String caminho_vetor, double[] vetor) throws Exception
	{
		int tamanho = vetor.length;
		FileWriter arquivo = new FileWriter(caminho_vetor);
		PrintWriter escreverArq = new PrintWriter(arquivo);
		
		escreverArq.printf("%dx%d%n", tamanho, tamanho);
		for(int i=0; i<tamanho; i++)
		{
			escreverArq.println(vetor[i]);
		}
		
		arquivo.close();
	}
	
	public static void escreverEscalar(String caminho_escalar, double escalar) throws Exception
	{
		FileWriter arquivo = new FileWriter(caminho_escalar);
		PrintWriter escreverArq = new PrintWriter(arquivo);
		escreverArq.println(escalar);
		arquivo.close();
	}
}
