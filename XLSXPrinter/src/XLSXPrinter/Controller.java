package XLSXPrinter;

public class Controller {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Pojo pojo = new Pojo();
        new FileChooser().chooseFile(pojo);
        new ChooseFrame(pojo);

    }
}
