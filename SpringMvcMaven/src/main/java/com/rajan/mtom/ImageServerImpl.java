package com.rajan.mtom;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface="com.rajan.mtom.ImageServer")
public class ImageServerImpl implements ImageServer{

	public Image downloadImage(String name) {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File image = new File(classLoader.getResource("upload/"+name).getFile());
			return ImageIO.read(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String uploadImage(Image data) {
		if(data!=null){
			//store somewhere
			return "Upload Successful";
		}

		throw new WebServiceException("Upload Failed!");
	}

}
