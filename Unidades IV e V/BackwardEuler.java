//Gabriel Sousa Firmino - 362963

import java.util.Scanner;

public class BackwardEuler
{
	public static double funcao(double u, double t)
	{
	    return -(3*u) - (10*t);
	}

	public static double forwardEuler(double estadoAnterior, double deltaT, double tempoCorrente)
	{
	    return estadoAnterior + (deltaT*funcao(estadoAnterior, tempoCorrente));
	}

	public static double backwardEuler(double estadoAnterior, double estadoCorrenteBarra, double deltaT, double tempoCorrente)
	{
	    return estadoAnterior + (deltaT*funcao(estadoCorrenteBarra, tempoCorrente));
	}

	public static void main(String[] args)
	{
		Scanner ler = new Scanner(System.in);
		double estadoInicial, estadoAnterior, estadoCorrenteChute, estadoCorrente;
		double tempoInicial, tempoCorrente;
		double pontos;
		double delta;

		System.out.printf("Backward-Euler aplicado a formula -3u - 10t\n");
		System.out.println();
		System.out.printf("Entre com o valor para o estado inicial:");
		estadoInicial = ler.nextDouble();
		System.out.printf("Entre com o valor do tempo inicial:");
		tempoInicial = ler.nextDouble();
		System.out.printf("Entre com o valor para o delta:");
		delta = ler.nextDouble();
		System.out.printf("Entre com o numero do estado que desejar calcular:");
		pontos = ler.nextDouble();

		estadoCorrente = estadoInicial;
		estadoAnterior = estadoInicial;
		tempoCorrente = tempoInicial;

		for(int i=0; i<pontos; i++)
		{
			estadoCorrenteChute = forwardEuler(estadoAnterior, delta, tempoCorrente);
			tempoCorrente = tempoCorrente + delta;
			estadoCorrente = backwardEuler(estadoAnterior, estadoCorrenteChute, delta, tempoCorrente);
			estadoAnterior = estadoCorrente;
		}

		System.out.println("Resultado para o estado "+pontos+" igual a "+estadoCorrente);
	}
}
