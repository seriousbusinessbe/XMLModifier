package be.seriousbusiness.xml_modifier.map;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
	@Autowired(required=true)
	@Qualifier("dozerBeanMapper")
	private DozerBeanMapper dozerBeanMapper;
	
	public Mapper(){
		//dozerBeanMapper.map(new String(), String.class);
	}
	
	public DozerBeanMapper getD(){
		return dozerBeanMapper;
	}

}
