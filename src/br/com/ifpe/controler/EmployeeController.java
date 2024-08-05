package br.com.ifpe.controler;
import java.util.List;
import java.util.function.Predicate;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class EmployeeController{

	private final GenericDAO<CpuAbstract> cpuDAO;
	
	public EmployeeController() {
		this.cpuDAO = DAOFactory.createDAO(CpuAbstract.class);
	}

	public CpuAbstract search(String model) {
		Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equals(model);
		return cpuDAO.search(foundCpu);
	}


	public void register(CpuAbstract cpu) {
		cpuDAO.register(cpu);

	}

	public void delete(String model) {
		CpuAbstract cpu = search(model);
		if (cpu != null) {
			cpuDAO.delete(cpu);
			System.out.println("CPU deletada com sucesso.");
		} else {
			System.out.println("CPU não encontrada.");
		}
	}

	public List<CpuAbstract> viewAll() {
		return cpuDAO.listAll();
	}
	
}