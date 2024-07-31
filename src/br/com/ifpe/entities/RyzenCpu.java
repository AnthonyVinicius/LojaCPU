package br.com.ifpe.entities;

import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class RyzenCpu extends CpuAbstract{
	
	public RyzenCpu() {
		// TODO Auto-generated constructor stub
	}


	public RyzenCpu(String model, String socket, int core, int threads, double hrz, double price) {
		super(model, socket, core, threads, hrz, price);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "RyzenCpu: \nModelo: " + getModel() + "\nSocket: " + getSocket() + ",\nCore: "
				+ getCore() + ",\nThreads: " + getThreads() + ",\nHrz: " + getHrz() + ",\nPrice: "
				+ getPrice();
	}

	
	
}	
