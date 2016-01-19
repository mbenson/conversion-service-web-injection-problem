package com.mbenson;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
public class WebProblemApplication {

	public class ConvertingBeanPostProcessor implements BeanPostProcessor {

		private @Autowired ConversionService conversionService;

		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
			return bean;
		}

		@Override
		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
			return bean;
		}

	}

	@Bean
	public ConvertingBeanPostProcessor convertingBeanPostProcessor() {
		/*
		 * in reality this would represent a BeanPostProcessor that
		 * wraps a bean with another bean that also includes a conversionService for later use
		 */
		return new ConvertingBeanPostProcessor();
	}

	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				System.out.println("foo");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WebProblemApplication.class, args).close();
	}
}
