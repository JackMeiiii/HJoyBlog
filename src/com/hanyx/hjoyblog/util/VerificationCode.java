package com.hanyx.hjoyblog.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerificationCode {

	public static String getMimeType(){
		return "image/jpeg" ;
	}
	
	public static Color getRandColor(int fc,int bc){
		Random random=new Random();
		if(bc>255){
			bc=255;
		}
		if(fc>255){
			fc=255;
		}
		int r=fc+random.nextInt((bc-fc));
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		return new Color(r,g,b);
	}
	//BufferedImage Graphics ImageIO
	public static String verifyCode(OutputStream os) throws IOException{
		int width=60,height=21;
		//����ͼ��
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//��ȡͼ��������
		Graphics gh=image.getGraphics();
		//��ȡ�����
		Random random=new Random();
		//���ñ���ɫ
		gh.setColor(getRandColor(200, 250));
		//���ο�
		gh.fillRect(0, 0, width, height);
		//��������
		gh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		//���߿�
		gh.setColor(new Color(0xcc, 0xd9, 0xe8));
		gh.drawRect(0,0,width,height);
		//������
		for(int i=0;i<155;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			gh.drawLine(x,y,(x+x1),(y+y1));
		}
		//���������
		String codes="";
		for(int i=0;i<4;i++){
			String code=String.valueOf(random.nextInt(10));
			codes+=code;
			//����֤����ʾ��ͼ����
			gh.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			gh.drawString(code, (13*i)+6, 16);
		}
		//ͼ����Ч
		gh.dispose();
		//���ͼ��ҳ��
		ImageIO.write(image,"JPEG", os);
		return codes;
	}
}
