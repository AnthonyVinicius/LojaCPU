package br.com.ifpe.apresentation;
import java.util.Scanner;
import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.AmdCpu;
import br.com.ifpe.entities.AmdCpuBuilder;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.controler.EmployeeControler;

public class EmployeeGUI {
	EmployeeControler employeeControler = new EmployeeControler();
	Scanner scanner = new Scanner(System.in);

	public void gui() {
		while (true) {
			System.out.println("\n[1]-Register CPU\n[2]-Search CPU\n[3]-Delete CPU\n[4]-View all CPUs");
			String option = scanner.nextLine();

			switch (option) {
			case "1":
				register();
				break;
			case "2":
				search();
				break;
			case "3":
				delete();
				break;
			case "4":
				viewAll();
				break;
			default:
				System.out.println("O valor " + option + " é invalido");
				break;
			}
		}
	}

	private void register() {
		String model;
		String socket;
		int core;
		int threads;
		double hrz;
		double price;

		System.out.print("Qual Modelo de CPU deseja Adicionar?: ");
		System.out.println("\nIntel [1]\nRyzen [2]");
		int modelChoice = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Digite o Modelo:");
		model = scanner.nextLine().toLowerCase().replace(" ", "");

		System.out.println("Digite o Socket:");
		socket = scanner.nextLine();

		System.out.println("Digite a quantidade de Core:");
		core = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Digite o Threads:");
		threads = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Digite a Frequência:");
		hrz = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Digite o Preço:");
		price = scanner.nextDouble();
		scanner.nextLine();
		if(modelChoice == 1 ) {

			IntelCpu intelCpu = new IntelCpuBuilder()
					.model(model)
					.socket(socket)
					.core(core)
					.threads(threads)
					.hrz(hrz)
					.price(price)
					.build();
			employeeControler.register(intelCpu);
		}else if(modelChoice == 2 ) {
			AmdCpu amdCpu = new AmdCpuBuilder()
					.model(model)
					.socket(socket)
					.core(core)
					.threads(threads)
					.hrz(hrz)
					.price(price)
					.build();
			employeeControler.register(amdCpu);
		}else {
			System.out.println("Modelo Indisponivel no Sistema");
		}
	}

	private void search() {
		System.out.println("Digite o Modelo:");
		String model = scanner.nextLine().toLowerCase().replace(" ", "");
		CpuAbstract cpu = employeeControler.search(model);
		if (cpu != null) {
			System.out.println(cpu);
		} else {
			System.out.println("CPU não encontrada.");
		}
	}

	private void delete() {
		System.out.println("Digite o Modelo:");
		String model = scanner.nextLine().toLowerCase().replace(" ", "");
		employeeControler.delete(model);
	}

	private void viewAll() {
		System.out.println(employeeControler.viewAll().toString());
	}

}
