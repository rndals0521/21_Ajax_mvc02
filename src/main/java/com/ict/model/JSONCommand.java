package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class JSONCommand {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		List<VO> list = DAO.getList();
		int count = 0;
		sb.append("[");
		for (VO k : list) {
			if(count == list.size()-1) {
				sb.append("{\"id\" : \""+k.getIdx()+"\", \"name\" : \""+k.getName()+"\", \"subject\" : \""+k.getSubject()+"\", \"content\" : \""+k.getContent()+"\", \"email\" : \""+k.getEmail()+"\", \"pwd\" : \""+k.getPwd()+"\", \"regdate\" : \""+k.getRegdate()+"\"}");
			}else {
				sb.append("{\"id\" : \""+k.getIdx()+"\", \"name\" : \""+k.getName()+"\", \"subject\" : \""+k.getSubject()+"\", \"content\" : \""+k.getContent()+"\", \"email\" : \""+k.getEmail()+"\", \"pwd\" : \""+k.getPwd()+"\", \"regdate\" : \""+k.getRegdate()+"\"},");
			}
			count++;
		}
		sb.append("]");
		
		return sb.toString();
	}
}
