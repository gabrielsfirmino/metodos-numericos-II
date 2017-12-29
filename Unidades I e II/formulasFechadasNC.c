//Gabriel Sousa Firmino - 362963
//Código compilado e executado no terminal do Ubuntu

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int menu()
{

	int escolha;

	printf("\nFórmulas fechadas de Newton-Cotes aplicadas a função F(x) = x^2 - x*log(x)\n");
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


float funcao(float x)
{
	float F;

	F=pow(x,2) - x*log(x);
	return F;

}

float calculaIntegral (int grau, float limiteInf, float limiteSup, float tamanhoIntervalo, int particao)
{

	float Fx0, Fx1, Fx2, Fx3, Fx4, Fx5;
	float integral=0; 
	float subIntervalo;
	int contador; 

	for (contador=1; contador<=particao; contador++)
	{

		switch(grau)
		{

			case 1:

				subIntervalo=tamanhoIntervalo/particao;
				Fx0=funcao(limiteInf);
				Fx1=funcao(limiteInf + subIntervalo);
				limiteInf=limiteInf + subIntervalo;
				integral=((subIntervalo/2) * (Fx0 + Fx1))+integral;
				break;

			case 2:

				subIntervalo=(tamanhoIntervalo/2)/particao;
				Fx0=funcao(limiteInf);
				Fx1=funcao(limiteInf + subIntervalo);
				Fx2=funcao(limiteInf + 2*subIntervalo);
				limiteInf=limiteInf + 2*subIntervalo;
				integral=((subIntervalo/3) * (Fx0 + 4*Fx1 + Fx2))+integral;
				break;

			case 3:

				subIntervalo=(tamanhoIntervalo/3)/particao;
				Fx0=funcao(limiteInf);
				Fx1=funcao(limiteInf + subIntervalo);
				Fx2=funcao(limiteInf + 2*subIntervalo);
				Fx3=funcao(limiteInf + 3*subIntervalo);
				limiteInf=limiteInf + 3*subIntervalo;
				integral=((3*subIntervalo/8) * (Fx0 + 3*Fx1 + 3*Fx2 + Fx3))+integral;
				break;

			case 4:

				subIntervalo=(tamanhoIntervalo/4)/particao;
				Fx0=funcao(limiteInf);
				Fx1=funcao(limiteInf + subIntervalo);
				Fx2=funcao(limiteInf + 2*subIntervalo);
				Fx3=funcao(limiteInf + 3*subIntervalo);
				Fx4=funcao(limiteInf + 4*subIntervalo);
				limiteInf=limiteInf + 4*subIntervalo;
				integral=((2*subIntervalo/45) * (7*Fx0 + 32*Fx1 + 12*Fx2 + 32*Fx3 + 17*Fx4))+integral;
				break;

			case 5:

				subIntervalo=(tamanhoIntervalo/5)/particao;
				Fx0=funcao(limiteInf);
				Fx1=funcao(limiteInf + subIntervalo);
				Fx2=funcao(limiteInf + 2*subIntervalo);
				Fx3=funcao(limiteInf + 3*subIntervalo);
				Fx4=funcao(limiteInf + 4*subIntervalo);
				Fx5=funcao(limiteInf + 5*subIntervalo);
				limiteInf=limiteInf + 5*subIntervalo;
				integral=((5*subIntervalo/288) * (19*Fx0 + 75*Fx1 + 60*Fx2 + 60*Fx3 + 75*Fx4 + 19*Fx5))+integral;
				break;

		}
		
	}

	return integral;

}

int main(int argc, char const *argv[])
{

	float a, b, t, delta;
	float integral_1, integral_2;
	int particao_1, particao_2;
	int opcao;

	int passo;

	opcao=menu();

	while(opcao != 0)
	{
		passo=0;

		system("clear");
		
		printf("\nEntre com o valor do limite inferior: ");
		scanf("%f", &a);
		printf("\nEntre com o valor do limite superior: ");
		scanf("%f", &b);
		printf("\nEntre com o valor da tolerância: ");
		scanf("%f", &t);

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