package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
/*
DTO(Data Transfer Object, 데이터 전송 객체)란 프로세스 간에 데이터를 전달하는 객체를 의미
 */
@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}