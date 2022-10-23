/*
 * Fachada (Facade) es un tipo de patrón de diseño estructural. Viene motivado por la necesidad de 
 * estructurar un entorno de programación y reducir su complejidad con la división en subsistemas, 
 * minimizando las comunicaciones y dependencias entre estos.
 * 
 * */


package Facade;

import java.io.File;

public class VideoConversionFacade {
	
	public File convertVideo(String fileName, String format) {
		VideoFile file = new VideoFile(fileName);
		Codec sourceCodec = CodecFactory.extraxt(file);
		Codec destinationCodec;
		
		if(format.equals("mp4")) {
			destinationCodec = new OggCompressionCodec();
		}else {
			destinationCodec = new MPEG4CompressionCodec();
		}
		
		VideoFile buffer = BitrateReader.read(file, sourceCodec);
		VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
		File result = (new AudioMixer()).fix(intermediateResult);
		
		return result;
	}

}
