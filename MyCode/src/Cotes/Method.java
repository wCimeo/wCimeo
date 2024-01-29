package Cotes;
import java.util.Scanner;

public class Method {
	int choice;
	double a;
	double b;
	double h;
	//ȫ�ֿ��õ�����
	static double[] x = new double[100];//���ֵķ������ơ�100
	
	//���캯��
	Method(){}
	Method(double a,double b){
		this.a = a;
		this.b = b;
	}
	
	//����n�ȷ�
	public void getPartValue(int n){
		double h = (b-a)/n;
		for(int i=0;i<=n;i++){
			x[i] = (a+i*h);
		}
	}
	
	//��1�������ʽ
		public double function1(double x){
			double num = 1.0/(Math.sqrt((1+Math.pow(x, 3))));
			return num;
		}
	
	//��2�������ʽ
	/**
	 * ������˼��һ�㣬����������ʽ�ķ�ĸΪx�����ȡ��0�Ļ��ͻᵼ�½����NAN
	 * ������Ҫ������жϣ����x==0������Ҫ����1
	 */
	public double function2(double x){
		double num;
		if(x==0)
			num =1;
		else
			num = (double)Math.sin(x)/x;
		return num;
		}	
	
	//��������������Cotes��ʽ-��1
		public double CalResult1(int n){
			double res = 0;
			h = (a+b)/n;
			double fa = function1(a);
			double fb = function1(b);
			
			double f3=0;
			for(int k=1;k<=n-1;k++){
				f3+=function1(x[k]);
			}

			double f2_1=0;
			double f2_2=0;
			double f2_3=0;
			for(int k=0;k<=n-1;k++){
				f2_1+=32*function1(a+((k+0.25)*h));
				f2_2+=12*function1(a+((k+0.50)*h));
				f2_3+=32*function1(a+((k+0.75)*h));
			}
			double f2 = f2_1 + f2_2 + f2_3;
			double res1 = 7*fa + f2 + 14*f3 + 7*fb;
			res = res1*h/90.0;
			
			return res;
		}
		
		//��������������Cotes��ʽ-��2
			public double CalResult2(int n){
				double res = 0;
				h = (a+b)/n;
				double fa = function2(a);
				double fb = function2(b);
				
				double f3=0;
				for(int k=1;k<=n-1;k++){
					f3+=function2(x[k]);
				}
				
				double f2_1=0;
				double f2_2=0;
				double f2_3=0;
				for(int k=0;k<=n-1;k++){
					f2_1+=32*function2(a+((k+0.25)*h));
					f2_2+=12*function2(a+((k+0.50)*h));
					f2_3+=32*function2(a+((k+0.75)*h));
				}
				double f2 = f2_1 + f2_2 + f2_3;
				double res1 = 7*fa + f2 + 14*f3 + 7*fb;
				res = res1*h/90.0;
				
				return res;
			}
}
