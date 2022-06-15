package kr.co.sist.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AjaxService {

	public String createJSON() {
		String json;
		String[] data= {"�ڹ�","�ڹٽ�ũ��Ʈ","HTML","CSS","Oracle DBMS"};
		
		//{pubDate:����ð�����,data[{name:"�ڹ�},,,]}
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
