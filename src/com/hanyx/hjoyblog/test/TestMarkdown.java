package com.hanyx.hjoyblog.test;

import java.io.IOException;

import org.markdown4j.Markdown4jProcessor;

import com.hanyx.hjoyblog.util.MarkdownUtil;

/**
 * @desc: ����һ�� markdown תHTML
 * @author ��Ԫ��
 */
public class TestMarkdown {
	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		sb.append("# HJoyBlog\n"
				+ "ѧϰJava��������һ���򵥵��Ჩ��ϵͳ,˳�㵱�����ѵα�ҵ��� :)"
				+ "\n"
				+ "\n"
				+ "##��ɫ\n"
				+ "* SpringMVC\n"
				+ "* MongoDB\n"
				+ "* MarkDown\n"
				+ "* jQuery\n"
				+ "* Pure");
		String html = MarkdownUtil.parse(sb.toString());
		System.out.println(html);
	}
}
