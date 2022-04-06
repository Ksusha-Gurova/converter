public class Start {
    public static void main(String[] args) {
        TerminalApi.start();
        while (true){
            TerminalApi.requestDataFromUser();
        }
    }
}
