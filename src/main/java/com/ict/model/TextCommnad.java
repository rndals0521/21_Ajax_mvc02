package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class TextCommnad {
	
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		
		// 원래는 계산 및 DB 처리 
		List<VO> list = DAO.getList();
		int count = 0;
		for (VO k : list) {
			if(count == list.size()-1)
			{
				sb.append(k.getIdx()+","+k.getName()+","+k.getSubject()+","+k.getContent()+","+k.getEmail()+","+k.getPwd()+","+k.getRegdate());
			}
			else {
				sb.append(k.getIdx()+","+k.getName()+","+k.getSubject()+","+k.getContent()+","+k.getEmail()+","+k.getPwd()+","+k.getRegdate()+"/");
			}
			count++;
		}
			
		return sb.toString();
	}
}
