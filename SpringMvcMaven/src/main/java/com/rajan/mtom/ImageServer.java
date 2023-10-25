package com.rajan.mtom;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ImageServer {
	
	//download a image from server
	@WebMethod Image downloadImage(String name);

	//update image to server
	@WebMethod String uploadImage(Image data);

}
