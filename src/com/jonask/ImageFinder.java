package com.jonask;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageFinder {
	
	public static boolean findImage(BufferedImage image, BufferedImage imagetofind) {	
		for(int y=0;y<image.getHeight();y++) {
			for(int x=0;x<image.getWidth();x++) {
				System.out.println("BackgroundXY: "+x+":"+y);
				
				if(image.getRGB(x, y)==imagetofind.getRGB(0,0)) {
					
					int countpixels=imagetofind.getWidth()*imagetofind.getHeight();
					
					if(!(imagetofind.getHeight()+y>image.getHeight())&&!(imagetofind.getWidth()+x>image.getWidth())) {
					for(int yy=y;yy<imagetofind.getHeight()+y;yy++) {
						for(int xx=x;xx<imagetofind.getWidth()+x;xx++) {
							
							if(image.getRGB(xx, yy)==imagetofind.getRGB(xx-x,yy-y)) {
							System.out.println("De er ens");
							countpixels--;
							}else {
								countpixels=-1;
								break;
							}
						}
						if(countpixels==-1) {
							break;
						}
					}
					if(countpixels<1) {
						System.out.println("Fandt billede");
						return true;
					}
					}
				}
				
			}
		}
		
		return false;
	}
	
	public static Position findImagePos(BufferedImage image, BufferedImage imagetofind) {
		Position pos;
		for(int y=0;y<image.getHeight();y++) {
			for(int x=0;x<image.getWidth();x++) {
				if(image.getRGB(x, y)==imagetofind.getRGB(0,0)) {
					
					int countpixels=imagetofind.getWidth()*imagetofind.getHeight();
					pos = new Position(x,y);
					
					if(!(imagetofind.getHeight()+y>image.getHeight())&&!(imagetofind.getWidth()+x>image.getWidth())) {
					for(int yy=y;yy<imagetofind.getHeight()+y;yy++) {
						for(int xx=x;xx<imagetofind.getWidth()+x;xx++) {
							
							if(image.getRGB(xx, yy)==imagetofind.getRGB(xx-x,yy-y)) {
							//System.out.println("De er ens");
							countpixels--;
							}else {
								countpixels=-1;
								break;
							}
						}
						if(countpixels==-1) {
							break;
						}
					}
					if(countpixels==0) {
						return pos;
					}
					}
				}
				
			}
		}
		
		
		return null;
	}
	
	
	public static List<Position> findAllImagePos(BufferedImage image, BufferedImage imagetofind) {
		List<Position> pos = new ArrayList<Position>();
		for(int y=0;y<image.getHeight();y++) {
			for(int x=0;x<image.getWidth();x++) {
				if(image.getRGB(x, y)==imagetofind.getRGB(0,0)) {
					
					int countpixels=imagetofind.getWidth()*imagetofind.getHeight();
					
					if(!(imagetofind.getHeight()+y>image.getHeight())&&!(imagetofind.getWidth()+x>image.getWidth())) {
					for(int yy=y;yy<imagetofind.getHeight()+y;yy++) {
						for(int xx=x;xx<imagetofind.getWidth()+x;xx++) {
							
							if(image.getRGB(xx, yy)==imagetofind.getRGB(xx-x,yy-y)) {
							//System.out.println("De er ens");
							countpixels--;
							}else {
								countpixels=-1;
								break;
							}
						}
						if(countpixels==-1) {
							break;
						}
					}
					if(countpixels==0) {
						pos.add(new Position(x,y));
					}
					}
				}
				
			}
		}
		return pos;
	}
	
}
