//Gabriel Sousa Firmino - 362963
//Código compilado e executado no terminal do Ubuntu

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int menu()
{

	int escolha;

	printf("\nQuadraturas de Gauss-Hermite aplicadas a integral na forma I[0,infinito] = e^(-x) * F(x),\n");
	printf("onde F(x) = x^3 - (x^2) - 1.\n");
	printf("1 - Polinômio de Laguerre com 1 ponto(s)\n");
	printf("2 - Polinômio de Laguerre com 2 ponto(s)\n");
	printf("3 - Polinômio de Laguerre com 3 ponto(s)\n");
	printf("4 - Polinômio de Laguerre com 4 ponto(s)\n");
	printf("5 - Polinômio de Laguerre com 5 ponto(s)\n");
	printf("5 - Polinômio de Laguerre com 6 ponto(s)\n");
	printf("0 - Sair");
	printf("\nEscolha a opção com o número de pontos de Laguerre desejado: ");
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
            p1=funcao(1);
            integral=p1;

			break;

		case 2:
            p1=funcao(0.5857)*0.8535;
            p2=funcao(3.4142)*0.1464;
            integral=p1+p2;

			break;

		case 3:
            p1=funcao(0.4157)*0.7110;
            p2=funcao(2.2442)*0.2785;
            p3=funcao(6.2899)*0.0103;
            integral=p1+p2+p3;

			break;

		case 4:
            p1=funcao(0.3225)*0.6031;
            p2=funcao(1.7457)*0.3574;
            p3=funcao(4.5366)*0.0388;
            p4=funcao(9.3950)*0.0005;
            integral=p1+p2+p3+p4;

			break;

		case 5:
            p1=funcao(0.2635)*0.5217;
            p2=funcao(1.4134)*0.3986;
            p3=funcao(3.5964)*0.0759;
            p4=funcao(7.0858)*0.0036;
            p5=funcao(12.6408)*0.00002;
            integral=p1+p2+p3+p4+p5;

			break;

		case 6:
			p1=funcao(0.2228)*0.4589;
            p2=funcao(1.1889)*0.4170;
            p3=funcao(2.9927)*0.1133;
            p4=funcao(5.7751)*0.0103;
            p5=funcao(9.9374)*0.0002;
            p6=funcao(15.9828)*0.00000008;
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