package lecture.p01lombok;

public class App {

	public static void main(String[] args) {
		
		JavaBean1 j1 = new JavaBean1();
		j1.setName("seojung");
		j1.setAge(30);
		j1.setAddress("dangsan");
				
		System.out.println(j1.getName());
		System.out.println(j1.getAge());
		System.out.println(j1.getAddress());
		
		JavaBean2_GetterSetter j2 = new JavaBean2_GetterSetter();
		j2.setCompany("HyunDae");
		j2.setLocation("Seoul");
		j2.setScore(98);
		
		System.out.println(j2.getCompany());
		System.out.println(j2.getLocation());
		System.out.println(j2.getScore());
		
		JavaBean4_ToString_EqualsAndHashcode j4 = new JavaBean4_ToString_EqualsAndHashcode();
		j4.setAddress("seoul");
		j4.setScore(88);
		System.out.println(j4.toString()); //toString() 없으면, 참조값을 출력
		
		
		
		
	}
}
