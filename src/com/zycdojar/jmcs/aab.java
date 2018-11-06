package com.zycdojar.jmcs;

import java.io.IOException;

public class aab extends Thread {
	public void run(){
		String[] cmd = new String[4];
		cmd[0] = "java";
		cmd[1] = "-Dfile.encoding=UTF-8";
		cmd[2] = "-jar";
		cmd[3] = aaa.ServerDir;
		try {
			aaa.server = Runtime.getRuntime().exec(cmd);
			aaa.ServerOutput=aaa.server.getInputStream();
			aaa.Command=aaa.server.getOutputStream();
			byte[] bbuf = new byte[1024];
			int hasRead = 0;
			while(true){
				if((hasRead = aaa.ServerOutput.read(bbuf))>0){
					aaa.txtrZycdojar.append(new String(bbuf,0,hasRead)+'\n');
				}
				if(aaa.ServerClose){
					break;
				}
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
