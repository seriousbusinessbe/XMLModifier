package be.seriousbusiness.xml_modifier;

import org.dozer.DozerBeanMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.seriousbusiness.xml_modifier.map.Mapper;

public class Start {
	
	public static final void main(String[] args){
		final ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application-config.xml");
		Mapper mapper=applicationContext.getBean("mapper",Mapper.class);
		DozerBeanMapper d=mapper.getD();
		boolean t=true;
	}

}
