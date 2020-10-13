package cn.com.chnsys.fileuploaddownload;

import cn.com.chnsys.fileuploaddownload.storage.StorageProperties;
import cn.com.chnsys.fileuploaddownload.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadingFilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadingFilesApplication.class, args);
	}

	/**
	 * 启动项目之后清空存放文件的空间(默认为./upload-dir),然后创建目录用来存放上传的文件
	 * @param storageService 存储服务
	 * @return CommandLineRunner
	 */
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
