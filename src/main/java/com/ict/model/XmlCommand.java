package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class XmlCommand {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		List<VO> list = DAO.getList();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		for (VO k : list) {
			sb.append("<product id=\""+k.getIdx()+"\" subject=\""+k.getSubject()+"\" content=\""+k.getContent()+"\" email=\""
					+k.getEmail()+"\" pwd=\""+k.getPwd()+"\" regdate=\""+k.getRegdate()+"\">");
			sb.append(k.getName());
			sb.append("</product>");
		}
		sb.append("</products>");
		return sb.toString();
	}
}