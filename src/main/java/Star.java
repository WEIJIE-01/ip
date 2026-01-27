public class Star {
    public static void main(String[] args) {
        // Prints welcome message in UI
        Ui.printWelcomeMessage();

        while (true){
            String message = Ui.scanInput();
            if (message.equals("bye")){
                break;
            }
            else {
                System.out.println(message + "\n");
            }
        }

        // Prints goodbye message in UI
        Ui.printOutMessage();

    }
}
