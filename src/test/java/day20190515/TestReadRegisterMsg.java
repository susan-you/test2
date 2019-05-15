package day20190515;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;


public class TestReadRegisterMsg {
  @Test(enabled=false)
  public void readRegisterCode() throws IOException {  
		String msgCodeFilePath="E:\\GBTemp\\thirdparty-service.log";
		String msgTemplateId="d47051c8773343d48136f859689fa7e5|value";
		String msgCodeRecivePhone="13694246425";
		int msgCodeLength=6;
		  FileReader fReader=new FileReader(msgCodeFilePath);
		  BufferedReader bReader=new BufferedReader(fReader);
		  String LineInfo="";
		  String matchLine="";
		  String msgCode="";
		  int beginIndex=-1;
		  boolean flag=false;
		  while((LineInfo=bReader.readLine())!=null) {
			  if(LineInfo.indexOf(msgCodeRecivePhone)!=-1&&LineInfo.indexOf(msgTemplateId)!=-1) {
				  matchLine=LineInfo;
				  beginIndex=LineInfo.indexOf(msgTemplateId);  
				  flag=true ;

			  }
		  }
		if(flag) {
			msgCode=matchLine.substring(beginIndex+msgTemplateId.length(),beginIndex+msgTemplateId.length()+msgCodeLength);
		
			 System.out.println(msgCode);
		}
		  
		  bReader.close();

  }
  
 
}
