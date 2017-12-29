//Gabriel Sousa Firmino - 362963
//Código compilado e executado no terminal do Ubuntu

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int menu()
{

	int escolha;

	printf("\nQuadraturas de Gauss-Hermite aplicadas a integral na forma I[-infinito,infinito] = e^(-x^2) * F(x),\n");
	printf("onde F(x) = x^3 - (x^2) - 1.\n");
	printf("1 - Polinômio de Hermite com 1 ponto(s)\n");
	printf("2 - Polinômio de Hermite com 2 ponto(s)\n");
	printf("3 - Polinômio de Hermite com 3 ponto(s)\n");
	printf("4 - Polinômio de Hermite com 4 ponto(s)\n");
	printf("5 - Polinômio de Hermite com 5 ponto(s)\n");
	printf("5 - Polinômio de Hermite com 6 ponto(s)\n");
	printf("0 - Sair");
	printf("\nEscolha a opção com o número de pontos de Hermite desejado: ");
	scanf("%d", &escolha);

	return escolha;
}

double funcao(double x)
{
	double F;

	F=pow(x,3) - pow(x,2) - 1;
	return F;

}

double calculaIntegral (int op)
{

	double p1,p2,p3,p4,p5,p6;
	double integral;

	switch(op)
	{

		case 1:
            p1=funcao(0)*1.7724;
            integral=p1;

			break;

		case 2:
            p1=funcao(-0.7071)*0.8862;
            p2=funcao(0.7071)*0.8862;
            integral=p1+p2;

			break;

		case 3:
            p1=funcao(-1.2247)*0.2954;
            p2=funcao(0)*1.1816;
            p3=funcao(1.2247)*0.2954;
            integral=p1+p2+p3;

			break;

		case 4:
            p1=funcao(-1.6506)*0.0813;
            p2=funcao(-0.5246)*0.8049;
            p3=funcao(0.5246)*0.8049;
            p4=funcao(1.6506)*0.0813;
            integral=p1+p2+p3+p4;

			break;

		case 5:
            p1=funcao(-2.0201)*0.0199;
            p2=funcao(-0.9585)*0.3936;
            p3=funcao(0)*0.9453;
            p4=funcao(0.9585)*0.3936;
            p5=funcao(2.0201)*0.0199;
            integral=p1+p2+p3+p4+p5;

			break;

		case 6:
			p1=funcao(-2.3506)*0.0045;
            p2=funcao(-1.3358)*0.1570;
            p3=funcao(-0.4360)*0.7246;
            p4=funcao(0.4360)*0.7246;
            p5=funcao(1.3358)*0.1570;
            p6=funcao(2.3506)*0.0045;
            integral=p1+p2+p3+p4+p5+p6;

			break;

	}

	return integral;

}

int main(int argc, char const *argv[])
{

	double integral;
	int opcao;

	opcao=menu();

	while(opcao != 0)
	{

		system("clear");

		integral=calculaIntegral(opcao);

		printf("\ncalculando...\n");
		
		printf("\nO valor da integral é igual a %lf\n", integral);

		opcao=menu();

	}

	system("clear");

	return EXIT_SUCCESS;
}