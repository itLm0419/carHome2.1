package com.carhome.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class SearchAction{
	private static final long serialVersionUID = 1186329124047737315L;
	private String input;
	private List<String> keywords;
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	public String getKeyWord()
	{
		String words[] = {"aa","bb","cc","dd","abcd","aaaa","bacd"};
		keywords = new ArrayList<String>();
		for(String s : words)
		{
			if(s.contains(input))
			{
				keywords.add(s);
			}
		}
		return "success";
	}
	
}
