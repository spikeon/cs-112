import javax.swing.*;

public abstract class Window extends JFrame {
    private String title;
    private int width;
    private int height;

    public JPanel panel;

    public Window(){
        this.title = "My Window";
        this.height = 500;
        this.width = 500;
        render();
    }

    public Window(String title){
        this.title = title;
        this.height = 500;
        this.width = 500;
        render();
    }

    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        panel = new JPanel();

        render();
    }

    public abstract void buildPanel();

    public void render(){
        // Set Window Title
        setTitle(title);

        // Set Window Size
        setSize(width, height);

        // Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildPanel();

        add(panel);

        // Show the Window
        setVisible(true);

    }
}
