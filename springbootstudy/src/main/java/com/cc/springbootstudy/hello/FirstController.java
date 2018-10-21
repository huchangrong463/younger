package com.cc.springbootstudy.hello;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cc.springbootstudy.amq.AMQProducer;
import com.cc.springbootstudy.conf.MyConf;
import com.cc.springbootstudy.conf.SysConf;
import com.cc.springbootstudy.es.MySpringClient;
import com.cc.springbootstudy.other.MyBean;
import com.cc.springbootstudy.profile.MyProfile;


@RestController
@RequestMapping("/hello")
public class FirstController {
	private static Logger log = Logger.getLogger(FirstController.class);

	@Autowired
	private MyBean myBean;
	
	@Autowired
	private MessageSource ms;
	
	@Autowired
    private CounterService counterService;
	@Autowired
	private GaugeService gaugeService;

	
	@Value(value="${cc.add.k1}")
	private String k1;
//	@Value(value="${cc.add.k2}")
//	private String k2;
	
	@Autowired
	private SysConf sc;
	@Autowired
	private MyConf mc;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private MyProfile mp;
	
	@Autowired
	private AMQProducer amq;
	
	@Autowired
	private MySpringClient es;
	
	
	@RequestMapping("/abc")
//	@ResponseBody
	public MyModel abc() {
		
		es.testES();
		
		amq.send("now send msg abcccccccc111111111");
		
		myBean.t1();
		
		counterService.increment("abc.call.count");
		gaugeService.submit("cc.redis.hit", 79);
		
		System.out.println("msg1==="+ms.getMessage("user.msg1",new Object[] {"中文测试111"},Locale.CHINA));

		System.out.println("1111111111111now use profile db==="+mp.getDBConf());
		
		log.debug("now is debug");
		log.info("now is info");
		log.warn("now is warn");
		log.error("now is error");
		
		System.out.println("now in FirstController.abc");
		
		
		System.out.println("k1==="+k1+" , k2==="+env.getProperty("cc.add.k2"));
		
		System.out.println("env===="+env.toString());
		
		System.out.println("sysconf === k1==="+sc.getK1()+" , k2==="+sc.getK2());
		
		System.out.println("myconf === k3==="+mc.getK3()+" , k4==="+mc.getK4());
		
//		return "Hello World!";
		
		return new MyModel("id1", "cctest", 111);
	}
}
