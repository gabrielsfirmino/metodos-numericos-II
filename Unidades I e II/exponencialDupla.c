//Gabriel Sousa Firmino - 362963
//Código compilado e executado no terminal do Ubuntu

#include <stdio.h>
#include <stdlib.h>
#include <math.h>


double funcao_Fx(double x)
{
	double F;

	F=pow(x,2)-x*log(x);
	return F;
}

double parametrizacao_1(double a, double b, double s)
{
    double Xs;

    Xs = ((a+b)/2)+((b-a)/2)*tanhl(M_PI_2*sinh(s));
    return Xs;
}

double funcao_Gs(double limiteA, double limiteB, double S)
{
	double G;
    double xS;

    xS=parametrizacao_1(limiteA, limiteB, S);
	G=funcao_Fx(xS)*cosh(S)/pow(cosh(M_PI_2*sinh(S)),2);
	return G;
}

double simpsomTresOitavos(double limiteInf, double limiteSup, double sI, double sF, double particao)
{
	long double Fx0, Fx1, Fx2, Fx3;
	long double I=0, subIntervalo, tamanhoIntervalo;
	int contador;

    tamanhoIntervalo=2*sF;
	subIntervalo=tamanhoIntervalo/particao;

	for (contador=1; contador<=particao; contador++)
	{
		subIntervalo=(tamanhoIntervalo/3)/particao;
		Fx0=funcao_Gs(limiteInf, limiteSup, sI);
		Fx1=funcao_Gs(limiteInf, limiteSup, sI + subIntervalo);
		Fx2=funcao_Gs(limiteInf, limiteSup, sI + 2*subIntervalo);
		Fx3=funcao_Gs(limiteInf, limiteSup, sI + 3*subIntervalo);
		sI=sI + 3*subIntervalo;
		I=((3*subIntervalo/8) * (Fx0 + 3*Fx1 + 3*Fx2 + Fx3))+I;

	}
	return I;
}

double calculaIntegral(double inferior, double superior, double pontoCorte, double tolerancia)
{
	double I_1, I_2;
	double  particao_1, particao_2;

	particao_1=1;
	particao_2=5;

	do
	{
		I_1=simpsomTresOitavos(inferior, superior, -pontoCorte, pontoCorte, particao_1);
		I_2=simpsomTresOitavos(inferior, superior, -pontoCorte, pontoCorte, particao_2);
		particao_1=particao_2;
		particao_2=particao_2 + 5;

	} while((fabs(I_2 - I_1)/I_1) >= tolerancia);

	return I_2;
}

int main(int argc, char const *argv[])
{

	double a, b, t;
	double integral_1, integral_2;
	double S_1, S_2, N;

	printf("\nExponencial dupla aplicada a função F(x) = x^2 - x*log(x)");
	printf("\nEntre com o valor do limite inferior: ");
	scanf("%lf", &a);
	printf("\nEntre com o valor do limite superior: ");
	scanf("%lf", &b);
	printf("\nEntre com o valor da tolerância: ");
	scanf("%lf", &t);

	printf("\ncalculando...\n");

    N=pow(2,1000);
	S_1=log((2/M_PI)*log(4*N));
	S_2=log((2/M_PI)*log(4*N));

	do
	{
		integral_1=((b-a)*M_PI/4)*calculaIntegral(a,b,S_1,t);
		integral_2=((b-a)*M_PI/4)*calculaIntegral(a,b,S_2,t);
		S_1=2*S_1;
		S_2=2*S_2;

	} while((fabs(integral_2 - integral_1)/integral_1) >= t);

	printf("\nA tolerância foi atingida, e o valor da integral é igual a %lf\n", integral_2);

	return EXIT_SUCCESS;

}
