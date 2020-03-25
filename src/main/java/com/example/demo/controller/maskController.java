package com.example.demo.controller;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class maskController {
	
	@RequestMapping(value = "getMask", produces = "application/xml;UTF-8")
	public String mask() {
		String str ="";
		String addr = "https://openapi.gg.go.kr/EmgMedInfo?KEY=b183b13f6ecc430faa25fe28d12f3e9b&pindex=1&Size=50";
		try {
			URL url = new URL(addr);
			InputStream os = url.openStream();
			byte data[] = new byte[100];
			while(true) {
				int n = os.read(data);
				String s =  new String(data, 0, n);
				str += s;
				/*
				 * Arrays.fill(data, (byte)0); if( n == -1) { break; }
				 */
				str = str.replace("\" ?>", "\"?>");
			}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return str;
	}
}
