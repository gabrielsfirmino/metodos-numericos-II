//Gabriel Sousa Firmino - 362963
//Código compilado e executado no terminal do Ubuntu

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int menu()
{

	int escolha;

	printf("\nFórmulas abertas de Newton-Cotes aplicadas a função F(x) = x^2 - x*log(x)\n");
	printf("1 - Polinômio de substituição com grau 1\n");
	printf("2 - Polinômio de substituição com grau 2\n");
	printf("3 - Polinômio de substituição com grau 3\n");
	printf("4 - Polinômio de substituição com grau 4\n");
	printf("5 - Polinômio de substituição com grau 5\n");
	printf("0 - Sair");
	printf("\nEscolha a opção com grau do polinômio de substituição desejado: ");
	scanf("%d", &escolha);

	return escolha;
}


double funcao(double x)
{
	double F;

	F=pow(x,2) - x*log(x);
	return F;

}

double calculaIntegral (int grau, double limiteInf, double limiteSup, double tamanhoIntervalo, int particao)
{

	double Fx0, Fx1, Fx2, Fx3, Fx4, Fx5;
	double integral=0; 
	double subIntervalo;
	int contador; 

	for (contador=1; contador<=particao; contador++)
	{

		switch(grau)
		{

			case 1:

				subIntervalo=(tamanhoIntervalo/3)/particao;
				Fx0=funcao(limiteInf + subIntervalo);
				Fx1=funcao(limiteInf + 2*subIntervalo);
				limiteInf=limiteInf + 3*subIntervalo;
				integral=((3*subIntervalo/2) * (Fx0 + Fx1))+integral;
				break;

			case 2:

				subIntervalo=(tamanhoIntervalo/4)/particao;
				Fx0=funcao(limiteInf + subIntervalo);
				Fx1=funcao(limiteInf + 2*subIntervalo);
				Fx2=funcao(limiteInf + 3*subIntervalo);
				limiteInf=limiteInf + 4*subIntervalo;
				integral=((4*subIntervalo/3) * (2*Fx0 - Fx1 + 2*Fx2))+integral;
				break;

			case 3:

				subIntervalo=(tamanhoIntervalo/5)/particao;
				Fx0=funcao(limiteInf + subIntervalo);
				Fx1=funcao(limiteInf + 2*subIntervalo);
				Fx2=funcao(limiteInf + 3*subIntervalo);
				Fx3=funcao(limiteInf + 4*subIntervalo);
				limiteInf=limiteInf + 5*subIntervalo;
				integral=((5*subIntervalo/24) * (11*Fx0 + Fx1 + Fx2 + 11*Fx3))+integral;
				break;

			case 4:

				subIntervalo=(tamanhoIntervalo/6)/particao;
				Fx0=funcao(limiteInf + subIntervalo);
				Fx1=funcao(limiteInf + 2*subIntervalo);
				Fx2=funcao(limiteInf + 3*subIntervalo);
				Fx3=funcao(limiteInf + 4*subIntervalo);
				Fx4=funcao(limiteInf + 5*subIntervalo);
				limiteInf=limiteInf + 6*subIntervalo;
				integral=((6*subIntervalo/20) * (11*Fx0 - 14*Fx1 + 26*Fx2 - 14*Fx3 + 11*Fx4))+integral;
				break;

			case 5:

				subIntervalo=(tamanhoIntervalo/7)/particao;
				Fx0=funcao(limiteInf + subIntervalo);
				Fx1=funcao(limiteInf + 2*subIntervalo);
				Fx2=funcao(limiteInf + 3*subIntervalo);
				Fx3=funcao(limiteInf + 4*subIntervalo);
				Fx4=funcao(limiteInf + 5*subIntervalo);
				Fx5=funcao(limiteInf + 6*subIntervalo);
				limiteInf=limiteInf + 7*subIntervalo;
				integral=((7*subIntervalo/1440) * (611*Fx0 - 453*Fx1 + 562*Fx2 + 562*Fx3 - 453*Fx4 + 611*Fx5))+integral;
				break;

		}
		
	}

	return integral;

}

int main(int argc, char const *argv[])
{

	double a, b, t, delta;
	double integral_1, integral_2;
	int particao_1, particao_2;
	int opcao;

	int passo;

	opcao=menu();

	while(opcao != 0)
	{
		passo=0;

		system("clear");
		
		printf("\nEntre com o valor do limite inferior: ");
		scanf("%lf", &a);
		printf("\nEntre com o valor do limite superior: ");
		scanf("%lf", &b);
		printf("\nEntre com o valor da tolerância: ");
		scanf("%lf", &t);

		printf("\ncalculando...\n");
		
		delta=b-a;
		particao_1=1;
		particao_2=5;

		do
		{

			integral_1=calculaIntegral(opcao,a,b,delta,particao_1);
			integral_2=calculaIntegral(opcao,a,b,delta,particao_2);
			particao_1=particao_2;
			particao_2=particao_2 + 5;
			passo++;

		} while(((fabs(integral_2 - integral_1)) / integral_1) >= t);

		printf("\nApós %d passo(s), a tolerância foi atingida, e o valor da integral é igual a %.10f\n", passo, integral_2);

		opcao=menu();

	}

	system("clear");

	return EXIT_SUCCESS;

}