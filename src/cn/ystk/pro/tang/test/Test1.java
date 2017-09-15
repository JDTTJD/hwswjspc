package cn.ystk.pro.tang.test;


public class Test1 {
	public static void main(String[] args) {
		MybatisTest x=new MybatisTest();
		int r = x.deleteTangById(8);
		if(r>0){
			System.out.println("成功"+r);
		}else{
			System.out.println("失败");
		}
	}
}
