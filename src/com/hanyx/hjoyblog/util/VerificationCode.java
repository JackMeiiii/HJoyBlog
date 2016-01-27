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
	//在内存中创建图象 获取图形上下�?生成随机�?设定背景�?填充矩形  设置字体  画边�? 随机产生155条干扰线 取随机生成的验证�?位数�?将认证码显示到图象中 图像生效
	//输出图像到页�?)
	public static String verifyCode(OutputStream os) throws IOException{
		int width=60,height=21;
		BufferedImage image=new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB);
		//获取图形上下�?
		Graphics gh=image.getGraphics();
		//生成随机�?
		Random random=new Random();
		//设置背景�?
		gh.setColor(getRandColor(200, 255));
		//填充矩形
		gh.fillRect(0, 0, width, height);
		//设置字体
		gh.setFont(new Font("MONOSPACED",Font.ITALIC,20 ));
		//画边�?
		gh.drawRect(0,0,width,height);
		//随机产生155条干扰线
		for(int i=0;i<155;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			gh.drawLine(x,y,(x+x1),(y+y1));
		}
		//去随机生成的四位验证�?
		String codes="";
		for(int i=0;i<4;i++){
			String code=String.valueOf(random.nextInt());
			codes+=code;
			//将验证码显示在图像当�?
			gh.drawString(code, (13*i)+6, 16);
		}
		//图像生效
		gh.dispose();
		//输出图像到页�?
		ImageIO.write(image,"JPEG", os);
		return codes;
	}
}
