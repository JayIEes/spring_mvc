package kr.co.sist.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AjaxService {

	public String createJSON() {
		String json;
		String[] data= {"자바","자바스크립트","HTML","CSS","Oracle DBMS"};
		
		//{pubDate:현재시간정보,data[{name:"자바},,,]}
		JSONObject jsonData=new JSONObject();
		jsonData.put("pubDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		jsonData.put("lang", String.valueOf(data.length));
		
		JSONArray jsonArr=new JSONArray();
		JSONObject jsonTemp=null;
		for(String name:data) {
			jsonTemp=new JSONObject();
			jsonTemp.put("name", name);
			jsonArr.add(jsonTemp);
		}
		jsonData.put("data",jsonArr);
		
		json=jsonData.toJSONString();
		
		return json;
	}
	
//	public static void main(String[] args) {
//	System.out.println(new AjaxService().createJSON());
//	}
	
	
	
}//class
