package by.htp.web.command;

public class CommandChooser {
	public static Command chooseCommand(String name) {

		Command currCommand = null;
		switch (name) {
		case "auth":
			currCommand = new AuthCommand();
			break;
		//case "calculate":
		//	currCommand = new CalculateCommand();
		//	break;
		case "addBook":
			currCommand = new AdminAddBook();
			
			break;
		default:
			
		}
		return currCommand;
	}

}
