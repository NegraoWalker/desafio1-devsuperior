package com.walker.spring.boot.desafio1.devsuperior;

import com.walker.spring.boot.desafio1.devsuperior.entity.Order;
import com.walker.spring.boot.desafio1.devsuperior.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final OrderService orderService;

	public Application(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Locale.setDefault(new Locale("en", "US"));
		System.out.println("***********************************");
		System.out.println("Informe os dados do pedido:");
		System.out.print("Código: ");
		int code = scanner.nextInt();
		System.out.print("Valor: ");
		double value = scanner.nextDouble();
		System.out.print("Porcentagem de desconto: ");
		double discount = scanner.nextDouble();

		Order order = new Order(code, value, discount);
		System.out.println("***********************************");
		System.out.println("Pedido com código: " + code);
		System.out.printf("Valor Total: R$%.2f", orderService.total(order));
		System.out.println();
		System.out.println("***********************************");
		scanner.close();
	}
}
