package Cotes;
import java.util.Scanner;
import Cotes.Method;
/**
* @author 陈梦
* 2023年11月2日 
 下午9:33:51
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
			System.out.println("请选择您要做的例题（1/2）：");
			choice = sc.nextInt();
			if(choice != 1 && choice !=2){
				System.out.println("您输入的数据有误，请重新输入！！！");
				continue;
			}
			
			System.out.println("请输入该积分的下界a和上界b：");
			a = sc.nextDouble();
			b = sc.nextDouble();
			
			Method m = new Method(a,b);
			
			for(int i=1; i<=20;i++){
				System.out.println("以下进行的是n="+i+"时的计算");
				m.getPartValue(i);
				
				if(choice == 1){
					res1 = m.CalResult1(i);
					//保留小数位数
					int change1 = (int)(res1*1000000);
					double res = (double)(change1)/1000000;
					System.out.println("结果="+res);
					
					if(res==0.909604){
						System.out.println("n="+i+"时有6位有效数字\n");
						break;
					}
				}else if(choice==2){
					res1 = m.CalResult2(i);
					//保留小数位数
					int change2 = (int)(res1*100000);
					double res2 = (double)(change2)/100000;
					System.out.println("结果="+res2);
					
					if(res2==1.54993){
						System.out.println("n="+i+"时有6位有效数字\n");
						break;
					}
				}
			}
			System.out.println("如果需要退出计算系统，请输入0！");
			System.out.println("想要继续，请输入1！");
			deci = sc.nextInt();
			if(deci == 0){
				System.out.println("您已经退出该系统。。。。。。");
				con = false;
			}	
		}
	}
}
