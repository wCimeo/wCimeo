package Cotes;
import java.util.Scanner;
import Cotes.Method;
/**
* @author ����
* 2023��11��2�� 
 ����9:33:51
*/

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		double a;
		double b;
		double res1=0;
		boolean con =true;
		int deci;

		while(con){
			System.out.println("��ѡ����Ҫ�������⣨1/2����");
			choice = sc.nextInt();
			if(choice != 1 && choice !=2){
				System.out.println("������������������������룡����");
				continue;
			}
			
			System.out.println("������û��ֵ��½�a���Ͻ�b��");
			a = sc.nextDouble();
			b = sc.nextDouble();
			
			Method m = new Method(a,b);
			
			for(int i=1; i<=20;i++){
				System.out.println("���½��е���n="+i+"ʱ�ļ���");
				m.getPartValue(i);
				
				if(choice == 1){
					res1 = m.CalResult1(i);
					//����С��λ��
					int change1 = (int)(res1*1000000);
					double res = (double)(change1)/1000000;
					System.out.println("���="+res);
					
					if(res==0.909604){
						System.out.println("n="+i+"ʱ��6λ��Ч����\n");
						break;
					}
				}else if(choice==2){
					res1 = m.CalResult2(i);
					//����С��λ��
					int change2 = (int)(res1*100000);
					double res2 = (double)(change2)/100000;
					System.out.println("���="+res2);
					
					if(res2==1.54993){
						System.out.println("n="+i+"ʱ��6λ��Ч����\n");
						break;
					}
				}
			}
			System.out.println("�����Ҫ�˳�����ϵͳ��������0��");
			System.out.println("��Ҫ������������1��");
			deci = sc.nextInt();
			if(deci == 0){
				System.out.println("���Ѿ��˳���ϵͳ������������");
				con = false;
			}	
		}
	}
}
