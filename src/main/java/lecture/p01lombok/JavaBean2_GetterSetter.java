package lecture.p01lombok;

import lombok.Getter;
import lombok.Setter;

// pom.xml 에 maven repository -> lombok . 아래것 찾아서 복붙
/**
 *<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
 *<dependency>
 *    <groupId>org.projectlombok</groupId>
 *    <artifactId>lombok</artifactId>
 *    <version>1.18.24</version>
 *    <scope>provided</scope>
 *</dependency> 
 * */

@Setter
@Getter
public class JavaBean2_GetterSetter {
	private String company;
	private int score;
	private String location;
}
