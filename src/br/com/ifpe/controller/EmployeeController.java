package br.com.ifpe.controller;

import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class EmployeeController {
    private static EmployeeController instance;
    private final GenericDAO<CpuAbstract> cpuDAO;

    private EmployeeController() {
        this.cpuDAO = DAOFactory.createDAO(CpuAbstract.class);
    }

    public static EmployeeController getInstance() {
        if (instance == null) {
            synchronized (EmployeeController.class) {
                if (instance == null) {
                    instance = new EmployeeController();
                }
            }
        }
        return instance;
    }

    public CpuAbstract search(String model) {
        Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equalsIgnoreCase(model);
        return cpuDAO.search(foundCpu);
    }

    public boolean alreadyRegister(String model) {
        CpuAbstract temp = search(model);
        if (temp != null && model.equalsIgnoreCase(temp.getModel())) {
            System.out.println("Model already registered in the system");
            return false;
        } else {
            return true;
        }
    }

    public void register(CpuAbstract cpu) {
        cpuDAO.register(cpu);
        System.out.println("Model successfully registered.");
    }

    public void delete(String model) {
        CpuAbstract cpu = search(model);
        if (cpu != null) {
            cpuDAO.delete(cpu);
            System.out.println("CPU successfully deleted.");
        } else {
            System.out.println("CPU not found.");
        }
    }

    public List<CpuAbstract> viewAll() {
        List<CpuAbstract> cpus = cpuDAO.listAll();
        System.out.println("Listing all CPUs:");
        return cpus;
    }
}