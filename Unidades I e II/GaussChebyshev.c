//Gabriel Sousa Firmino - 362963
//Código compilado e executado no terminal do Ubuntu

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int menu()
{

	int escolha;

	printf("\nQuadraturas de Gauss-Chebyshev aplicadas a integral na forma I[-1,1] = (1/(sqrt(1 - x^2))) * F(x),\n");
	printf("onde F(x) = x^3 - (x^2) - 1.");
	printf("\nDigite o número de ponto(s) de Chebyshev desejado ou 0 (zero) se deseja sair: ");
	scanf("%d", &escolha);

	return escolha;
}

double funcao(double x)
{
	double F;

	F=pow(x,3) - pow(x,2) - 1;
	return F;

}

double calculaIntegral (int nPontos)
{

	int contador;
	double 	Xk;
	double integral, somatorio=0;

	for (contador=1;contador<=nPontos;contador++)
	{
		Xk=cos(((contador-0.5)/nPontos)*M_PI);
		somatorio=somatorio+funcao(Xk);
	}

	integral=(M_PI/nPontos)*somatorio;

	return integral;

}

int main(int argc, char const *argv[])
{

	double integral;
	int n;

	n=menu();

	while(n != 0)
	{

		system("clear");

		integral=calculaIntegral(n);

		printf("\ncalculando...\n");
		
		printf("\nO valor da integral é igual a %lf\n", integral);

		n=menu();

	}

	system("clear");

	return EXIT_SUCCESS;
}