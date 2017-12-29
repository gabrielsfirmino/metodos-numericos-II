//Gabriel Sousa Firmino - 362963
//Código compilado e executado no terminal do Ubuntu

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int menu()
{

	int escolha;

	printf("\nQuadraturas de Gauss-Legendre aplicadas a função F(x) = x^2 - x*log(x)\n");
	printf("1 - Polinômio de Legendre com 1 ponto(s)\n");
	printf("2 - Polinômio de Legendre com 2 ponto(s)\n");
	printf("3 - Polinômio de Legendre com 3 ponto(s)\n");
	printf("4 - Polinômio de Legendre com 4 ponto(s)\n");
	printf("5 - Polinômio de Legendre com 5 ponto(s)\n");
	printf("0 - Sair");
	printf("\nEscolha a opção com o número de pontos de Legendre desejado: ");
	scanf("%d", &escolha);

	return escolha;
}

double parametrizacao(double limiteA, double limiteB, double s)
{
    double P;

    P=((limiteA + limiteB)/2) + ((limiteB - limiteA)/2)*s;
    return P;
}

double funcao(double x)
{
	double F;

	F=pow(x,2) - x*log(x);
	return F;

}

double calculaIntegral (int grau, double limiteInf, double limiteSup, double tamanhoIntervalo, int particao)
{

	double p1, p2, p3, p4, p5;
	double integral=0;
	double subIntervalo;
	int contador;

	subIntervalo=tamanhoIntervalo/particao;

	for (contador=1; contador<=particao; contador++)
	{

        limiteSup=limiteInf+subIntervalo;

		switch(grau)
		{

			case 1:
                p1=funcao(parametrizacao(limiteInf,limiteSup,0))*2;
                integral=(((limiteSup-limiteInf)/2)*p1)+integral;
				break;

			case 2:
                p1=funcao(parametrizacao(limiteInf,limiteSup,-0.5773));
                p2=funcao(parametrizacao(limiteInf,limiteSup,0.5773));
                integral=(((limiteSup-limiteInf)/2)*(p1+p2))+integral;
				break;

			case 3:
                p1=funcao(parametrizacao(limiteInf,limiteSup,-0.7745))*0.5556;
                p2=funcao(parametrizacao(limiteInf,limiteSup,0))*0.8889;
                p3=funcao(parametrizacao(limiteInf,limiteSup,0.7745))*0.5556;
                integral=(((limiteSup-limiteInf)/2)*(p1+p2+p3))+integral;
				break;

			case 4:
                p1=funcao(parametrizacao(limiteInf,limiteSup,-0.8611))*0.3478;
                p2=funcao(parametrizacao(limiteInf,limiteSup,-0.3399))*0.6521;
                p3=funcao(parametrizacao(limiteInf,limiteSup,0.3399))*0.6521;
                p4=funcao(parametrizacao(limiteInf,limiteSup,0.8611))*0.3478;
                integral=(((limiteSup-limiteInf)/2)*(p1+p2+p3+p4))+integral;

				break;

			case 5:
                p1=funcao(parametrizacao(limiteInf,limiteSup,-0.9061))*0.2369;
                p2=funcao(parametrizacao(limiteInf,limiteSup,-0.5384))*0.4786;
                p3=funcao(parametrizacao(limiteInf,limiteSup,0))*0.5688;
                p4=funcao(parametrizacao(limiteInf,limiteSup,0.5384))*0.4786;
                p5=funcao(parametrizacao(limiteInf,limiteSup,0.9061))*0.2369;
                integral=(((limiteSup-limiteInf)/2)*(p1+p2+p3+p4+p5))+integral;

				break;

		}

		limiteInf=limiteSup;

	}

	return integral;

}

int main(int argc, char const *argv[])
{

	double a, b, t, delta;
	double integral_1, integral_2;
	int particao_1, particao_2;
	int opcao;

	opcao=menu();

	while(opcao != 0)
	{

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

		} while((fabs(integral_2 - integral_1)) >= t);

		printf("\nO valor da integral é igual a %lf\n", integral_2);

		opcao=menu();

	}

	system("clear");

	return EXIT_SUCCESS;
}
