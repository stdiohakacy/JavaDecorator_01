package structual.Decorator._01;

import java.util.Date;

public abstract class EmployeeDecorator implements EmployeeComponent {
	protected EmployeeComponent employee;

	protected EmployeeDecorator(EmployeeComponent employee) {
		this.employee = employee;
	}

	@Override
	public String getName() {
		return employee.getName();
	}

	@Override
	public void join(Date joinDate) {
		employee.join(joinDate);
	}

	@Override
	public void terminate(Date terminateDate) {
		employee.terminate(terminateDate);
	}
}

class Manager extends EmployeeDecorator {

	protected Manager(EmployeeComponent employee) {
		super(employee);
	}

	public void createRequirement() {
		System.out.println(this.employee.getName() + " is create requirements.");
	}

	public void assignTask() {
		System.out.println(this.employee.getName() + " is assigning tasks.");
	}

	public void manageProgress() {
		System.out.println(this.employee.getName() + " is managing the progress.");
	}

	@Override
	public void doTask() {
		employee.doTask();
		createRequirement();
		assignTask();
		manageProgress();
	}
}

class TeamLeader extends EmployeeDecorator {

	protected TeamLeader(EmployeeComponent employee) {
		super(employee);
	}

	public void planing() {
		System.out.println(this.employee.getName() + " is planing.");
	}

	public void motivate() {
		System.out.println(this.employee.getName() + " is motivating his members.");
	}

	public void monitor() {
		System.out.println(this.employee.getName() + " is monitoring his members.");
	}

	@Override
	public void doTask() {
		employee.doTask();
		planing();
		motivate();
		monitor();
	}
}

class TeamMember extends EmployeeDecorator {
	 
    protected TeamMember(EmployeeComponent employee) {
        super(employee);
    }
 
    public void reportTask() {
        System.out.println(this.employee.getName() + " is reporting his assigned tasks.");
    }
 
    public void coordinateWithOthers() {
        System.out.println(this.employee.getName() + " is coordinating with other members of his team.");
    }
 
    @Override
    public void doTask() {
        employee.doTask();
        reportTask();
        coordinateWithOthers();
    }
}

