import java.io.PrintStream;
import javax.swing.*;

public class Main {
    public static class CmdParams {
        public String inputFile;
        public String inputN;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            params.inputFile = args[0];
            params.inputN = args[1];
            if (args.length > 2) {
                params.outputFile = args[2];
            }
            if (args.length > 2) {
                params.help = true;
                params.error = true;
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }


    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <n> <input-file> (<output-file>)");
            out.println("  <cmd> --help");
            System.exit(params.error ? 1 : 0);
        }
        if (params.window) {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Window().setVisible(true);
        } else {
            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
            out.close();
        }
    }
}
