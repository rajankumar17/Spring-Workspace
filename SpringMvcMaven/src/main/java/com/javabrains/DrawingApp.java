package com.javabrains;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SuppressWarnings("deprecation")
public class DrawingApp {

	
	static Logger log=Logger.getLogger(DrawingApp.class);
	
	/**
	 * @param args
	 */
	
	public enum Station {
	    A1, A2, A3, A4, A5, A6, A7, A8, A9, A10;
	    public int distance(Station other) {
	        return Math.abs(other.ordinal() - this.ordinal());
	    }
	}
/*	static class FirstException extends Exception {
		 
        public FirstException(String msg) {
            super(msg);
        }
    }
 
    static class SecondException extends Exception {
 
        public SecondException(String msg) {
            super(msg);
        }
    }
 
    static class ThirdException extends Exception {
 
        public ThirdException(String msg) {
            super(msg);
        }
    }
	
	public static void foo(String s)
	  throws ThirdException, FirstException, SecondException{
	    try {
	    	if (s.equals("First"))
                throw new FirstException("First");
            else if (s.equals("Second"))
                throw new SecondException("Second");
            else
                throw new ThirdException("Third");
	    }catch (Exception e) {
		      throw e;
	    }
	    
	  }
*/
	
	 public static final String EXAMPLE_TEST = "This |is my small |example "
         + "string which I'm going to " + "use for pattern matching.";
	public static void main(String[] args) {
		
		ShapeService sh=new ShapeService() {
		};
		sh.draw("hello");
		/*try{
			foo("abc");
        }catch(FirstException | SecondException | ThirdException e){
            //below assignment will throw compile time exception since e is final
            //e = new Exception();
            System.out.println(e.getMessage());
        }*/
		
		
		//BasicConfigurator.configure();
		/*
		 * BeanFactory factory=new XmlBeanFactory(new
		 * FileSystemResource("src/spring.xml")); Triangle
		 * triangle=(Triangle)factory.getBean("Triangle");
		 */

		/*ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		ShapeService traingle = context.getBean("triangle",ShapeService.class);
		ShapeService circle = context.getBean("circle",ShapeService.class);
		Triangle t = context.getBean("triangle",Triangle.class);

		traingle.draw("Hi");
		circle.draw("Hello");
		t.draw("Bye");*/
		
		/*System.out.println(Station.A6.distance(Station.A1));
		
		Date d1=new Date();
		Calendar c1=new GregorianCalendar(2016,3, 8, 18, 25);
		//c1.set(2016, 4, 8, 18, 25);
		//c1.getTime();
		System.out.println(c1.getTime());
		
		Calendar calendar = Calendar.getInstance(Locale.US);
		System.out.println("First Day Of Week: " + calendar.getFirstDayOfWeek());
		 
		calendar = Calendar.getInstance(Locale.FRANCE);
		System.out.println("First Day Of Week: " + calendar.getFirstDayOfWeek());*/
		
		/*List<Flight> flights=new ArrayList<Flight>();
		
		File file=new File("C:\\Users\\rajan.kumar1\\Project\\files");
		List<File> files=Arrays.asList(file.listFiles());
		for (File string : files) {
			System.out.println(string);
			System.out.println(string.getName());
			try {
				//File f=new File("C:\\Users\\rajan.kumar1\\Project\\files\\"+string);
				FileReader fr=new FileReader(string);
				BufferedReader br=new BufferedReader(fr);
				String a;
				int count=0;
				while((a=br.readLine())!=null){
					count++;
					if(count>1){
					String [] val=new String[20];
					Flight fl=new Flight();
					val=a.split("[|]");
					fl.setFLIGHT_NUM(val[0]);
					fl.setDEP_LOC(val[1]);
					fl.setARR_LOC(val[2]);
					fl.setVALID_TILL(val[3]);
					fl.setFLIGHT_TIME(val[4]);
					fl.setFLIGHT_DURN(val[5]);
					fl.setFARE(Integer.parseInt((val[6]).trim()));
					flights.add(fl);
				}
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		/*DrawingApp da=new DrawingApp();
		da.runMe("rajan");
		MyLogger ml=new MyLogger();
		try {
			ml.setup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*for (Flight flight : flights) {
			System.out.println(flight.toString());
		}
		log.info("Flight details printed");*/
		
		/*System.out.println(EXAMPLE_TEST.matches("\\w.*"));
        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
        System.out.println(splitString.length);// should be 14
        for (String string : splitString) {
                System.out.println(string);
        }
        // replace all whitespace with tabs
        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));*/
		
		

	}
	
private void runMe(String parameter){
		
		if(log.isDebugEnabled()){
			log.debug("This is debug : " + parameter);
		}
		
		if(log.isInfoEnabled()){
			log.info("This is info : " + parameter);
		}
		
		log.warn("This is warn : " + parameter);
		log.error("This is error : " + parameter);
		log.fatal("This is fatal : " + parameter);
		
	}

}
